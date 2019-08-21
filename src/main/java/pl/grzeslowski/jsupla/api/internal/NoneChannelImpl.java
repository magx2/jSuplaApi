package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.NoneChannel;
import pl.grzeslowski.jsupla.api.channel.state.State;

import java.util.Optional;

import static java.util.Optional.of;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class NoneChannelImpl extends ChannelImpl implements NoneChannel {
    private static final State STATE = new State() {
    };

    NoneChannelImpl(final Channel channel) {
        super(channel);
    }

    @Override
    public Optional<State> findState() {
        return of(STATE);
    }
}
