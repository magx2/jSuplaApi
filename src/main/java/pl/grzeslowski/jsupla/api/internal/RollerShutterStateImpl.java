package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

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
    public boolean isCalibrating() {
        return calibrating;
    }

    @Override
    public Percentage getShut() {
        return shut;
    }

    @Override
    public Percentage getOpen() {
        return getShut().invert();
    }

    @Override
    public OnOff getOnfOff() {
        return onOffState.getOnfOff();
    }
}
