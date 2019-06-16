package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DistanceChannel;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DistanceChannelImpl extends ChannelImpl implements DistanceChannel {
    private final DistanceState state;

    DistanceChannelImpl(final Channel channel) {
        super(channel);
        state = new BigDecimalState(channel.getState().getDistance());
    }

    @Override
    public DistanceState getState() {
        return state;
    }
}
