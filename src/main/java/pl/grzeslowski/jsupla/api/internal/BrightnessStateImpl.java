package pl.grzeslowski.jsupla.api.internal;

import lombok.NonNull;
import lombok.Value;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

@Value
class BrightnessStateImpl implements BrightnessState {
    @NonNull Percentage brightness;
}
