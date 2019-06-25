package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;

@ToString
@EqualsAndHashCode
final class ColorStateImpl implements ColorState {
    private final Color.Hsv hsv;

    ColorStateImpl(final Color.Hsv hsv) {
        this.hsv = hsv;
    }

    @Override
    public Color.Rgb getRgb() {
        return hsv.toRgb();
    }

    @Override
    public Color.Hsv getHsv() {
        return hsv;
    }
}
