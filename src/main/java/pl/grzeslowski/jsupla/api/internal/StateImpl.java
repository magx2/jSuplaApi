package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.ChannelState;
import pl.grzeslowski.jsupla.api.Color;
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
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.StringJoiner;

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

    StateImpl(final Integer param1,
              final Integer param2,
              final Integer param3,
              final ChannelState state) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.state = requireNonNull(state);
    }

    @Override
    public Percentage getBrightness() {
        return new Percentage(state.getBrightness());
    }

    @Override
    public Color.Rgb getRgb() {
        return HsbTypeConverter.INSTANCE.toHsv(
                state.getColor(),
                state.getBrightness()
        ).toRgb();
    }

    @Override
    public Color.Hsv getHsv() {
        return HsbTypeConverter.INSTANCE.toHsv(
                state.getColor(),
                state.getBrightness()
        );
    }

    @Override
    public BigDecimal getDepth() {
        return state.getDepth();
    }

    @Override
    public BigDecimal getDistanceState() {
        return state.getDistance();
    }

    @Override
    public Percentage getHumidityState() {
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
        if (param3 == null) {
            return Optional.empty();
        } else {
            return Optional.of(state.isPartialHi() ? ON : OFF);
        }
    }

    @Override
    public boolean isCalibrating() {
        return state.isIsCalibrating();
    }

    @Override
    public Percentage getShut() {
        return new Percentage(state.getShut());
    }

    @Override
    public Percentage getOpen() {
        return getShut().invert();
    }

    @Override
    public OnOff getOnfOff() {
        final boolean booleanState;
        if (state.isHi() != null) {
            booleanState = state.isHi();
        } else if (state.isOn() != null) {
            booleanState = state.isOn();
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
        final BigDecimal temperature = state.getTemperature();
        if (param2 != null) {
            return new BigDecimal(param2)
                           .divide(new BigDecimal(1000.0), CEILING)
                           .add(temperature);
        } else {
            return temperature;
        }
    }

    @SuppressWarnings("Duplicates")
    private StringJoiner stateToString(StringJoiner joiner) {
        if (state.isOn() != null) {
            joiner.add("on=" + state.isOn());
        }
        if (state.isHi() != null) {
            joiner.add("hi=" + state.isHi());
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
        if (state.isIsCalibrating() != null) {
            joiner.add("calibrating=" + state.isIsCalibrating());
        }
        if (state.getDepth() != null) {
            joiner.add("depth=" + state.getDepth());
        }
        if (state.getDistance() != null) {
            joiner.add("distance=" + state.getDistance());
        }
        if (state.isPartialHi() != null) {
            joiner.add("partialHi=" + state.isPartialHi());
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
