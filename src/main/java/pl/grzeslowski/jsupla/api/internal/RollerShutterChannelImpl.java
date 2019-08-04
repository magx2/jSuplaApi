package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.RollerShutterChannel;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
final class RollerShutterChannelImpl extends ChannelImpl implements RollerShutterChannel {
    private final RollerShutterState state;
    private final int openingTimeInMs;
    private final int idOfOpeningSensor;

    RollerShutterChannelImpl(final Channel channel) {
        super(channel);
        state = new RollerShutterStateImpl(channel);
        openingTimeInMs = channel.getParam1();
        idOfOpeningSensor = channel.getParam2();
    }

    @Override
    public RollerShutterState getState() {
        return state;
    }
}
