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
        calibrating = channel.getState().isIsCalibrating();
        shut = new Percentage(channel.getState().getShut());
        onOffState = buildOnOff(shut, channel);
    }

    private static OnOffState buildOnOff(Percentage shut, Channel channel) {
        if (channel.getParam2() != null && channel.getParam2() > 0) {
            return new OnOffStateImpl(channel.getState().isHi());
        } else {
            return new OnOffStateImpl(shut.compareTo(Percentage.MAX) != 0);
        }
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
