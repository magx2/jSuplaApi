package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.GateState;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static pl.grzeslowski.jsupla.api.channel.state.GateState.Position.CLOSED;
import static pl.grzeslowski.jsupla.api.channel.state.GateState.Position.OPENED;
import static pl.grzeslowski.jsupla.api.channel.state.GateState.Position.PARTIALLY_OPENED;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.OFF;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.ON;

@ToString
@EqualsAndHashCode
@Getter
final class GateStateImpl implements GateState {
    private final Position position;

    GateStateImpl(final Channel channel) {
        final OnOffState.OnOff onOffState = OnOffStateImpl.hi(channel).getOnOffState();
        Optional<OnOffState.OnOff> partialState;
        if (channel.getParam3() == null) {
            partialState = empty();
        } else {
            partialState = of(channel.getState().isPartialHi() ? ON : OFF);
        }
        if (onOffState == ON) {
            position = CLOSED;
        } else {
            position = partialState.map(onOff -> onOff == ON ? PARTIALLY_OPENED : CLOSED)
                               .orElse(OPENED);
        }
    }
}
