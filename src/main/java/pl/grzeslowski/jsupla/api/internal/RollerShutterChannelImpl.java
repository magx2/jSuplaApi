package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.RollerShutterChannel;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class RollerShutterChannelImpl extends ChannelImpl implements RollerShutterChannel {
    private final RollerShutterState state;

    public RollerShutterChannelImpl(final Channel channel) {
        super(channel);
        state = new RollerShutterStateImpl(channel);
    }

    @Override
    public RollerShutterState getState() {
        return state;
    }
}
