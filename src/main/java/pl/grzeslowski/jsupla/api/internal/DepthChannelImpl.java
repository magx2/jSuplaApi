package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DepthChannel;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DepthChannelImpl extends ChannelImpl implements DepthChannel {
    private final DepthState state;

    DepthChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> new DepthStateImpl(channel.getState().getDepth()));
    }

    @Override
    public Optional<DepthState> findState() {
        return ofNullable(state);
    }
}
