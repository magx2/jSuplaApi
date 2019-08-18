package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
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
        final ChannelState state = channel.getState();
        final OnOffState.OnOff onOffState = state.isHi() ? ON : OFF;
        OnOffState.OnOff partialState;
        if (channel.getParam3() == null) {
            partialState = OFF;
        } else {
            final Boolean partialHi = state.isPartialHi();
            partialState = partialHi != null && partialHi ? ON : OFF;
        }
        if (onOffState == ON) {
            position = CLOSED;
        } else {
            position = partialState == OFF ? OPENED : PARTIALLY_OPENED;
        }
    }
}
