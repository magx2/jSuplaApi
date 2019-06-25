package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;

public interface DimmerAndRgbLightningChannel extends Channel {
    @Override
    ColorAndBrightnessState getState();
}
