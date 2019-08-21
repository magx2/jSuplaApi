package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.DepthState;

import java.util.Optional;

public interface DepthChannel extends Channel {
    @Override
    Optional<DepthState> findState();
}
