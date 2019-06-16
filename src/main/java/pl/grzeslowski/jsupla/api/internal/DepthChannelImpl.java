package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DepthChannel;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DepthChannelImpl extends ChannelImpl implements DepthChannel {
    private final DepthState state;

    DepthChannelImpl(final Channel channel) {
        super(channel);
        state = new StateImpl(channel);
    }

    @Override
    public DepthState getState() {
        return state;
    }
}
