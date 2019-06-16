package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.OnOffChannel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class HiChannelImpl extends ChannelImpl implements OnOffChannel {
    private final OnOffState state;

    HiChannelImpl(final Channel channel) {
        super(channel);
        state = OnOffStateImpl.hi(channel);
    }

    @Override
    public OnOffState getState() {
        return state;
    }
}
