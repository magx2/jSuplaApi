package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.GateChannel;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class GateChannelImpl extends ChannelImpl implements GateChannel {
    private final PartialOpenState state;

    protected GateChannelImpl(final Channel channel) {
        super(channel);
        state = new PartialOpenStateImpl(channel);
    }

    @Override
    public PartialOpenState getState() {
        return state;
    }
}
