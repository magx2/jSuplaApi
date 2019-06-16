package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.OFF;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.ON;

@ToString
@EqualsAndHashCode
final class PartialOpenStateImpl implements PartialOpenState {
    private final OnOff onOffState;
    private final OnOff partialState;

    PartialOpenStateImpl(final Channel channel) {
        onOffState = OnOffStateImpl.hi(channel).getOnfOff();
        if (channel.getParam3() == null) {
            partialState = null;
        } else {
            partialState = channel.getState().getPartialHi() ? ON : OFF;
        }
    }

    @Override
    public OnOff getOnfOff() {
        return onOffState;
    }

    @Override
    public Optional<OnOff> partialState() {
        return ofNullable(partialState);
    }
}
