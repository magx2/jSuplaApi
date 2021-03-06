package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;

import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
final class TemperatureAndHumidityStateImpl implements TemperatureAndHumidityState {
   @NonNull private final Percentage humidityState;
   @NonNull private final BigDecimal temperatureState;
}
