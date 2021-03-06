package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class ColorAndBrightnessStateImpl implements ColorAndBrightnessState {
    private BrightnessState brightnessState;
    private ColorState colorState;

    ColorAndBrightnessStateImpl(final BrightnessState brightnessState, final ColorState colorState) {
        this.brightnessState = requireNonNull(brightnessState);
        this.colorState = requireNonNull(colorState);
    }

    @Override
    public Percentage getBrightness() {
        return brightnessState.getBrightness();
    }

    @Override
    public Color.Rgb getRgb() {
        return colorState.getRgb();
    }

    @Override
    public Color.Hsv getHsv() {
        return colorState.getHsv();
    }
}
