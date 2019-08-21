package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;

import java.util.Optional;

public interface DimmerAndRgbLightningChannel extends Channel {
    @Override
    Optional<ColorAndBrightnessState> findState();
}
