package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.TemperatureAndHumidityChannel;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class TemperatureAndHumidityChannelImpl extends ChannelImpl implements TemperatureAndHumidityChannel {
    private final TemperatureAndHumidityState state;
    private final ThermometerChannelImpl thermometerChannel;
    private final HumidityChannelImpl humidityChannel;

    TemperatureAndHumidityChannelImpl(final Channel channel) {
        super(channel);
        thermometerChannel = new ThermometerChannelImpl(channel);
        humidityChannel = new HumidityChannelImpl(channel);
        state = findState(channel, () -> new TemperatureAndHumidityStateImpl(
                humidityChannel.findState().orElseThrow(() -> new IllegalStateException("Channel should have humidity")).getHumidityState(),
                thermometerChannel.findState().orElseThrow(() -> new IllegalStateException("Channel should have temperature")).getTemperatureState()
        ));
    }

    @Override
    public Optional<TemperatureAndHumidityState> findState() {
        return Optional.ofNullable(state);
    }

    @Override
    public int getTemperatureAdjustment() {
        return thermometerChannel.getTemperatureAdjustment();
    }

    @Override
    public int getHumidityAdjustment() {
        return humidityChannel.getHumidityAdjustment();
    }
}
