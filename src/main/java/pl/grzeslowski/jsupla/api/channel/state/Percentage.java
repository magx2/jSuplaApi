package pl.grzeslowski.jsupla.api.channel.state;

import java.util.Objects;

public final class Percentage implements Comparable<Percentage> {
    public static final Percentage MAX = new Percentage(100);
    public static final Percentage MIN = new Percentage(0);
    private final int percentage;

    @SuppressWarnings("WeakerAccess")
    public Percentage(final int percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage is too low! Minimum value is 0, was " + percentage);
        }
        if (percentage > 100) {
            throw new IllegalArgumentException("Percentage is too high! Maximum value is 100, was " + percentage);
        }
        this.percentage = percentage;
    }

    public Percentage add(int value) {
        return new Percentage(percentage + value);
    }

    public Percentage add(Percentage value) {
        return new Percentage(percentage + value.percentage);
    }

    public Percentage minus(int value) {
        return new Percentage(percentage - value);
    }

    public Percentage minus(Percentage value) {
        return new Percentage(percentage - value.percentage);
    }

    @Override
    public int compareTo(final Percentage o) {
        if (o == null) {
            return -1;
        }
        return percentage - o.percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Percentage that = (Percentage) o;
        return percentage == that.percentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }

    @Override
    public String toString() {
        return "Percentage{" +
                       "percentage=" + percentage +
                       '}';
    }
}
