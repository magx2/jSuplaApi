package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

public interface RollerShutterChannel extends Channel {
    @Override
    RollerShutterState getState();
}
