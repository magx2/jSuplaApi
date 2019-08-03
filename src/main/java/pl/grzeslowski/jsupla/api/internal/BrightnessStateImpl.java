package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
final class BrightnessStateImpl implements BrightnessState {
    @NonNull private final Percentage brightness;
}
