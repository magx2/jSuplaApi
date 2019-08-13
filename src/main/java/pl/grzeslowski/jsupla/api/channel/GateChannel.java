package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.GateState;

import java.util.Optional;

public interface GateChannel extends Channel, OpeningChannel {
    @Override
    GateState getState();

    Optional<Integer> getIdOfSecondaryOpeningSensor();
}
