package pl.grzeslowski.jsupla.api.channel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.HsbTypeConverter;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;

@ToString
@EqualsAndHashCode
final class ColorStateImpl implements ColorState {
    private final HsbTypeConverter.Hsv hsv;

    ColorStateImpl(final HsbTypeConverter.Hsv hsv) {
        this.hsv = hsv;
    }

    @Override
    public HsbTypeConverter.Rgb getRgb() {
        return hsv.toRgb();
    }

    @Override
    public HsbTypeConverter.Hsv getHsv() {
        return hsv;
    }
}
