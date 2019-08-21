package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.OnOffChannel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class OnChannelImpl extends ChannelImpl implements OnOffChannel {
    private final OnOffState state;

    OnChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> OnOffStateImpl.on(channel));
    }

    @Override
    public Optional<OnOffState> findState() {
        return Optional.ofNullable(state);
    }
}
