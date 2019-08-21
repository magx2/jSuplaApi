package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DistanceChannel;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DistanceChannelImpl extends ChannelImpl implements DistanceChannel {
    private final DistanceState state;

    DistanceChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> new DistanceStateImpl(channel.getState().getDistance()));
    }

    @Override
    public Optional<DistanceState> findState() {
        return Optional.ofNullable(state);
    }
}
