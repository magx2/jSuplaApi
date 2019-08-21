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
        state = findState(channel, () -> OnOffStateImpl.hi(channel));
        openingTimeInMs = channel.getParam1();
        idOfOpeningSensor = channel.getParam2();
    }

    @Override
    public Optional<OnOffState> findState() {
        return Optional.ofNullable(state);
    }
}
