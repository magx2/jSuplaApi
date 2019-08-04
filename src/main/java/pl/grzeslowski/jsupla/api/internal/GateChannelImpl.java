package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.GateChannel;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
final class GateChannelImpl extends ChannelImpl implements GateChannel {
    private final PartialOpenState state;
    private int openingTimeInMs;
    private int idOfOpeningSensor;
    private Integer idOfSecondaryOpeningSensor;

    GateChannelImpl(final Channel channel) {
        super(channel);
        state = new PartialOpenStateImpl(channel);
        openingTimeInMs = channel.getParam1();
        idOfOpeningSensor = channel.getParam2();
        idOfSecondaryOpeningSensor = channel.getParam3();
    }

    @Override
    public Optional<Integer> getIdOfSecondaryOpeningSensor() {
        return ofNullable(idOfSecondaryOpeningSensor);
    }
}
