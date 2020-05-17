package pl.grzeslowski.jsupla.api.internal;

import lombok.NonNull;
import lombok.Value;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

@Value
class HumidityStateImpl implements HumidityState {
    @NonNull Percentage humidityState;
}
