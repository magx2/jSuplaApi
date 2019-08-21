package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;

import java.util.Optional;

public interface DimmerChannel extends Channel {
    @Override
    Optional<BrightnessState> findState();
}
