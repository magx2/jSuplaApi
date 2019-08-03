package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;

import java.util.Optional;

public interface GateChannel extends Channel, OpeningChannel {
    @Override
    PartialOpenState getState();

    Optional<Integer> getIdOfSecondaryOpeningSensor();
}
