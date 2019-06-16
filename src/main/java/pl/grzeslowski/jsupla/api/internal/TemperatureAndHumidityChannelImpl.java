package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.TemperatureAndHumidityChannel;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class TemperatureAndHumidityChannelImpl extends ChannelImpl implements TemperatureAndHumidityChannel {
    private final TemperatureAndHumidityState state;

    TemperatureAndHumidityChannelImpl(final Channel channel) {
        super(channel);
        final TemperatureState temperatureState = new TemperatureChannelImpl(channel).getState();
        final HumidityState humidityState = new HumidityChannelImpl(channel).getState();
        state = new TemperatureAndHumidityStateImpl(
                humidityState.getHumidity(),
                temperatureState.getTemperature()
        );
    }

    @Override
    public TemperatureAndHumidityState getState() {
        return state;
    }
}
