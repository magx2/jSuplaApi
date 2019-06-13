package pl.grzeslowski.jsupla.api.channel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class TemperatureAndHumidityStateImpl implements TemperatureAndHumidityState {
    private final Percentage humidityState;
    private final BigDecimal temperatureState;

    TemperatureAndHumidityStateImpl(final Percentage humidityState, final BigDecimal temperatureState) {
        this.humidityState = requireNonNull(humidityState);
        this.temperatureState = requireNonNull(temperatureState);
    }

    @Override
    public Percentage getHumidity() {
        return humidityState;
    }

    @Override
    public BigDecimal getTemperature() {
        return temperatureState;
    }
}
