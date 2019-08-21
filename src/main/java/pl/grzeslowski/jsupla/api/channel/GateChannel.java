package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.GateState;

import java.util.Optional;

public interface GateChannel extends Channel, OpeningChannel {
    @Override
    Optional<GateState> findState();

    Optional<Integer> getIdOfSecondaryOpeningSensor();
}
