package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.ColorState;

public interface RgbLightningChannel extends Channel {
    ColorState getColorState();
}
