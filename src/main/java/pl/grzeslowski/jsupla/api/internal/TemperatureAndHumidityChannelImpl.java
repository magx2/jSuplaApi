package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.TemperatureAndHumidityChannel;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class TemperatureAndHumidityChannelImpl extends ChannelImpl implements TemperatureAndHumidityChannel {
    private final TemperatureAndHumidityState state;

    TemperatureAndHumidityChannelImpl(final Channel channel) {
        super(channel);
        final TemperatureState temperatureState = new ThermometerChannelImpl(channel).getState();
        final HumidityState humidityState = new HumidityChannelImpl(channel).getState();
        state = new TemperatureAndHumidityStateImpl(
                humidityState.getHumidityState(),
                temperatureState.getTemperatureState()
        );
    }

    @Override
    public TemperatureAndHumidityState getState() {
        return state;
    }
}
