package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class BigDecimalState implements DepthState, DistanceState, TemperatureState {
    private final BigDecimal bigDecimal;

    BigDecimalState(final BigDecimal bigDecimal) {
        this.bigDecimal = requireNonNull(bigDecimal);
    }

    @Override
    public BigDecimal getDepth() {
        return bigDecimal;
    }

    @Override
    public BigDecimal getDistanceState() {
        return bigDecimal;
    }

    @Override
    public BigDecimal getTemperature() {
        return bigDecimal;
    }
}
