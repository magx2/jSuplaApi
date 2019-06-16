package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class PercentageState implements BrightnessState, HumidityState {
    private final Percentage percentage;

    private PercentageState(final Percentage percentage) {
        this.percentage = requireNonNull(percentage);
    }

    PercentageState(final int percentage) {
        this(new Percentage(percentage));
    }

    PercentageState(final BigDecimal percentage) {
        this(new Percentage(percentage));
    }

    @Override
    public Percentage getBrightness() {
        return percentage;
    }

    @Override
    public Percentage getHumidity() {
        return percentage;
    }
}
