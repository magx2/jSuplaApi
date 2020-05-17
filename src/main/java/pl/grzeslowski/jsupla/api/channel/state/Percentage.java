package pl.grzeslowski.jsupla.api.channel.state;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Percentage implements Comparable<Percentage> {
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    public static final Percentage MAX = new Percentage(100);
    public static final Percentage MIN = new Percentage(0);

    BigDecimal percentage;

    public Percentage(final int percentage) {
        this(new BigDecimal(percentage));
    }

    public Percentage(final BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Percentage is too low! Minimum value is 0, was " + percentage);
        }
        if (percentage.compareTo(ONE_HUNDRED) > 0) {
            throw new IllegalArgumentException("Percentage is too high! Maximum value is 100, was " + percentage);
        }
        this.percentage = percentage;
    }

    public Percentage add(BigDecimal value) {
        return new Percentage(percentage.add(value));
    }

    public Percentage add(int value) {
        return new Percentage(percentage.add(new BigDecimal(value)));
    }

    public Percentage add(Percentage value) {
        return new Percentage(percentage.add(value.percentage));
    }

    public Percentage subtract(BigDecimal value) {
        return new Percentage(percentage.subtract(value));
    }

    public Percentage subtract(int value) {
        return new Percentage(percentage.subtract(new BigDecimal(value)));
    }

    @SuppressWarnings("WeakerAccess")
    public Percentage subtract(Percentage value) {
        return new Percentage(percentage.subtract(value.percentage));
    }

    public Percentage invert() {
        return MAX.subtract(this);
    }

    @Override
    public int compareTo(final Percentage o) {
        return percentage.compareTo(o.percentage);
    }
}
