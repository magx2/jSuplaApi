package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
final class HumidityStateImpl implements HumidityState {
    @NonNull private final Percentage humidityState;
}
