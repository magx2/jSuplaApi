package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.DistanceState;

import java.util.Optional;

public interface DistanceChannel extends Channel {
    @Override
    Optional<DistanceState> findState();
}
