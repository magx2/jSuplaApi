package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;

public interface DimmerChannel extends Channel {
    BrightnessState getBrightnessState();
}
