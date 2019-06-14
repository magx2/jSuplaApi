package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.NoneChannel;
import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class NoneChannelImpl extends ChannelImpl implements NoneChannel {
    private static final State STATE = new State() {
    };

    NoneChannelImpl(final Channel channel) {
        super(channel);
    }

    @Override
    public State getState() {
        return STATE;
    }
}
