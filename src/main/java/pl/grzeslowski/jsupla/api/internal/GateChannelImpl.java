package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.GateChannel;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

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
