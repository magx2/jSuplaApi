package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.ControllingChannel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
final class ControllingChannelImpl extends ChannelImpl implements ControllingChannel {
    private final OnOffState state;
    private final int openingTimeInMs;
    private final int idOfOpeningSensor;

    ControllingChannelImpl(final Channel channel) {
        super(channel);
        state = OnOffStateImpl.hi(channel);
        openingTimeInMs = channel.getParam1();
        idOfOpeningSensor = channel.getParam2();
    }
}
