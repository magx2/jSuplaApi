package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.HsbTypeConverter;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;
import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;
import pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionEnumNames;
import pl.grzeslowski.jsupla.api.generated.model.ChannelState;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.StringJoiner;

import static java.lang.String.format;
import static java.math.RoundingMode.CEILING;
import static java.util.Objects.requireNonNull;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.OFF;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.ON;

final class StateImpl implements BrightnessState, ColorAndBrightnessState, ColorState, DepthState, DistanceState,
                                         HumidityState, OnOffState, PartialOpenState, RollerShutterState,
                                         TemperatureAndHumidityState, TemperatureState {
    private final ChannelState state;
    private final Integer param1;
    private final Integer param2;
    private final Integer param3;
    private Class<? extends State> type;

    StateImpl(final Integer param1,
              final Integer param2,
              final Integer param3,
              final ChannelFunctionEnumNames name,
              final ChannelState state) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.state = requireNonNull(state);
        this.type = iniTypeDispatcher(name);
    }

    @Override
    public Percentage getBrightness() {
        checkType(BrightnessState.class);
        return new Percentage(state.getBrightness());
    }

    @Override
    public HsbTypeConverter.Rgb getRgb() {
        checkType(ColorState.class);
        return HsbTypeConverter.INSTANCE.toHsv(
                state.getColor(),
                state.getBrightness()
        ).toRgb();
    }

    @Override
    public HsbTypeConverter.Hsv getHsv() {
        checkType(ColorState.class);
        return HsbTypeConverter.INSTANCE.toHsv(
                state.getColor(),
                state.getBrightness()
        );
    }

    @Override
    public BigDecimal getDepth() {
        checkType(DepthState.class);
        return state.getDepth();
    }

    @Override
    public BigDecimal getDistanceState() {
        checkType(DistanceState.class);
        return state.getDistance();
    }

    @Override
    public Percentage getHumidityState() {
        checkType(HumidityState.class);
        final BigDecimal humidity = state.getHumidity();
        if (param3 != null) {
            return new Percentage(new BigDecimal(param3)
                                          .divide(new BigDecimal(1000.0), CEILING)
                                          .add(humidity));
        } else {
            return new Percentage(humidity);
        }
    }

    @Override
    public Optional<OnOff> partialState() {
        checkType(PartialOpenState.class);
        if (param3 == null) {
            return Optional.empty();
        } else {
            return Optional.of(state.getPartialHi() ? ON : OFF);
        }
    }

    @Override
    public boolean isCalibrating() {
        checkType(PartialOpenState.class);
        return state.getCalibrating();
    }

    @Override
    public Percentage getShut() {
        checkType(RollerShutterState.class);
        return new Percentage(state.getShut());
    }

    @Override
    public Percentage getOpen() {
        checkType(RollerShutterState.class);
        return getShut().invert();
    }

    @Override
    public OnOff getOnfOff() {
        checkType(OnOffState.class);
        final boolean booleanState;
        if (state.getHi() != null) {
            booleanState = state.getHi();
        } else if (state.getOn() != null) {
            booleanState = state.getOn();
        } else {
            throw new IllegalStateException();
        }
        final OnOff onOffState = booleanState ? ON : OFF;
        final Integer inverted = param3;
        if (inverted != null) {
            if (inverted > 0) {
                return onOffState.invert();
            } else {
                return onOffState;
            }
        } else {
            return onOffState;
        }
    }

    @Override
    public BigDecimal getTemperature() {
        checkType(TemperatureState.class);
        final BigDecimal temperature = state.getTemperature();
        if (param2 != null) {
            return new BigDecimal(param2)
                           .divide(new BigDecimal(1000.0), CEILING)
                           .add(temperature);
        } else {
            return temperature;
        }
    }

    private void checkType(Class<? extends State> clazz) {
        if (!clazz.isAssignableFrom(type)) {
            throw new IllegalStateException(
                    format("Class of this State `%s` is not sub type of `%s`!",
                            type.getSimpleName(),
                            clazz.getSimpleName())
            );
        }
    }

    @Override
    public Class<? extends State> getType() {
        return type;
    }

    @Override
    public <T extends State> T castTo(Class<? extends T> clazz) {
        checkType(clazz);
        return clazz.cast(this);
    }

    private Class<? extends State> iniTypeDispatcher(final ChannelFunctionEnumNames name) {
        return type = ChannelFunctionDispatcher.DISPATCHER.dispatch(name, new ChannelFunctionDispatcher.FunctionSwitch<Class<? extends State>>() {
            @Override
            public Class<? extends State> onNone(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onControllingTheGatewayLock(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onControllingTheGate(final ChannelFunctionEnumNames name) {
                return PartialOpenState.class;
            }

            @Override
            public Class<? extends State> onControllingTheGarageDoor(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onThermometer(final ChannelFunctionEnumNames name) {
                return TemperatureState.class;
            }

            @Override
            public Class<? extends State> onHumidity(final ChannelFunctionEnumNames name) {
                return null;
            }

            @Override
            public Class<? extends State> onHumidityAndTemperature(final ChannelFunctionEnumNames name) {
                return HumidityState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorGateway(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorGate(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorGarageDoor(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onNoLiquidSensor(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onControllingTheDoorLock(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorDoor(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onControllingTheRollerShutter(final ChannelFunctionEnumNames name) {
                return RollerShutterState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorRollerShutter(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onPowerSwitch(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onLightSwitch(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onDimmer(final ChannelFunctionEnumNames name) {
                return BrightnessState.class;
            }

            @Override
            public Class<? extends State> onRgbLighting(final ChannelFunctionEnumNames name) {
                return ColorAndBrightnessState.class;
            }

            @Override
            public Class<? extends State> onDimmerAndRgbLightning(final ChannelFunctionEnumNames name) {
                return BrightnessState.class;
            }

            @Override
            public Class<? extends State> onDepthSensor(final ChannelFunctionEnumNames name) {
                return DepthState.class;
            }

            @Override
            public Class<? extends State> onDistanceSensor(final ChannelFunctionEnumNames name) {
                return DistanceState.class;
            }

            @Override
            public Class<? extends State> onOpeningSensorWindow(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onMailSensor(final ChannelFunctionEnumNames name) {
                return OnOffState.class;
            }

            @Override
            public Class<? extends State> onWindSensor(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onPressureSensor(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onRainSensor(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onWeightSensor(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onWeatherStation(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onStaircaseTimer(final ChannelFunctionEnumNames name) {
                return State.class;
            }

            @Override
            public Class<? extends State> onDefault(final ChannelFunctionEnumNames name) {
                return onNone(name);
            }
        });
    }

    @Override
    public String toString() {
        return stateToString(new StringJoiner(", ", StateImpl.class.getSimpleName() + "[", "]"))
                       .add("param1=" + param1)
                       .add("param2=" + param2)
                       .add("param3=" + param3)
                       .add("type=" + type)
                       .toString();
    }

    @SuppressWarnings("Duplicates")
    private StringJoiner stateToString(StringJoiner joiner) {
        if (state.getOn() != null) {
            joiner.add("on=" + state.getOn());
        }
        if (state.getHi() != null) {
            joiner.add("hi=" + state.getHi());
        }
        if (state.getHumidity() != null) {
            joiner.add("humidity=" + state.getHumidity());
        }
        if (state.getTemperature() != null) {
            joiner.add("temperature=" + state.getTemperature());
        }
        if (state.getBrightness() != null) {
            joiner.add("brightness=" + state.getBrightness());
        }
        if (state.getColor() != null) {
            joiner.add("color=" + state.getColor());
        }
        if (state.getCalibrating() != null) {
            joiner.add("calibrating=" + state.getCalibrating());
        }
        if (state.getDepth() != null) {
            joiner.add("depth=" + state.getDepth());
        }
        if (state.getDistance() != null) {
            joiner.add("distance=" + state.getDistance());
        }
        if (state.getPartialHi() != null) {
            joiner.add("partialHi=" + state.getPartialHi());
        }
        if (state.getShut() != null) {
            joiner.add("shut=" + state.getShut());
        }
        if (state.getColorBrightness() != null) {
            joiner.add("color_brightness=" + state.getColorBrightness());
        }
        return joiner;
    }

}
