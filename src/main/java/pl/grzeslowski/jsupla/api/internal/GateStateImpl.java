package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.GateState;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

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
        final OnOffState.OnOff onOffState = channel.getState().isHi() ? ON : OFF;
        OnOffState.OnOff partialState;
        if (channel.getParam3() == null) {
            partialState = OFF;
        } else {
            partialState = channel.getState().isPartialHi() ? ON : OFF;
        }
        if (onOffState == ON) {
            position = CLOSED;
        } else {
            position = partialState == OFF ? OPENED : PARTIALLY_OPENED;
        }
    }
}
