package pl.grzeslowski.jsupla.api.internal;

import lombok.NonNull;
import lombok.Value;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;

import java.math.BigDecimal;

@Value
class DistanceStateImpl implements DistanceState {
    @NonNull BigDecimal distanceState;
}
