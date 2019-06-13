package pl.grzeslowski.jsupla.api.channel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DepthChannelImpl extends ChannelImpl implements DepthChannel {
    private final DepthState state;

    DepthChannelImpl(final Channel channel) {
        super(channel);
        state = new BigDecimalState(channel.getState().getDepth());
    }

    @Override
    public DepthState getState() {
        return state;
    }
}
