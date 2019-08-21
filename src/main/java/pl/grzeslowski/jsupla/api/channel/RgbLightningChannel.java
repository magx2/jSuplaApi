package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.ColorState;

import java.util.Optional;

public interface RgbLightningChannel extends Channel {
    @Override
    Optional<ColorState> findState();
}
