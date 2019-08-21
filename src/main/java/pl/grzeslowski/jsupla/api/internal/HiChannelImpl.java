package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.OnOffChannel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class HiChannelImpl extends ChannelImpl implements OnOffChannel {
    private final OnOffState state;

    static HiChannelImpl createWithParam2(Channel channel) {
        return new HiChannelImpl(
                channel,
                findState(
                        channel,
                        () -> {
                            if (channel.getParam2() != null && channel.getParam2() > 0) {
                                if (channel.getState().isHi() != null) {
                                    return OnOffStateImpl.hi(channel);
                                } else {
                                    return null;
                                }
                            } else {
                                return null;
                            }
                        }
                )
        );
    }

    static HiChannelImpl createWithoutParam2(Channel channel) {
        return new HiChannelImpl(
                channel,
                findState(
                        channel,
                        () -> {
                            if (channel.getState().isHi() != null) {
                                return OnOffStateImpl.hi(channel);
                            } else {
                                return null;
                            }
                        }
                )
        );
    }

    private HiChannelImpl(final Channel channel, OnOffState onOffState) {
        super(channel);
        state = onOffState;
    }

    @Override
    public Optional<OnOffState> findState() {
        return Optional.ofNullable(state);
    }
}
