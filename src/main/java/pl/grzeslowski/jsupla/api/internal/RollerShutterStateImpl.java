package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

@EqualsAndHashCode
@ToString
@Getter
final class RollerShutterStateImpl implements RollerShutterState {
    private final OnOffState onOffState;
    private final boolean calibrating;
    private final Percentage shut;

    RollerShutterStateImpl(Channel channel) {
        onOffState = OnOffStateImpl.hi(channel);
        calibrating = channel.getState().isIsCalibrating();
        shut = new Percentage(channel.getState().getShut());
    }

    @Override
    public Percentage getOpen() {
        return getShut().invert();
    }

    @Override
    public OnOff getOnOffState() {
        return onOffState.getOnOffState();
    }
}
