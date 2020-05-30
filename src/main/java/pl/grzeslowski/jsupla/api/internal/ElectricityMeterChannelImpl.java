package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.ElectricityMeterChannel;
import pl.grzeslowski.jsupla.api.channel.state.ElectricityMeterState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class ElectricityMeterChannelImpl extends ChannelImpl implements ElectricityMeterChannel {
    private final ElectricityMeterState state;

    ElectricityMeterChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> new ElectricityMeterStateImpl(channel));
    }

    @Override
    public Optional<ElectricityMeterState> findState() {
        return Optional.ofNullable(state);
    }
}
