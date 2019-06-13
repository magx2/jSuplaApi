package pl.grzeslowski.jsupla.api.channel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

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
