package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.ControllingChannel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
final class ControllingChannelImpl extends ChannelImpl implements ControllingChannel {
    private final OnOffState state;
    private final int openingTimeInMs;
    private final int idOfOpeningSensor;

    ControllingChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> build(channel));
        openingTimeInMs = channel.getParam1();
        idOfOpeningSensor = channel.getParam2();
    }

    private static OnOffState build(Channel channel) {
        if (channel.getParam2() != null && channel.getParam2() > 0) {
            return OnOffStateImpl.hi(channel);
        } else {
            return null;
        }
    }

    @Override
    public Optional<OnOffState> findState() {
        return Optional.ofNullable(state);
    }
}
