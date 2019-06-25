package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;

@ToString
@Getter
public final class SetBrightnessAndColor implements Action {
    private final SetBrightnessAction brightnessAction;
    private final SetColorAction setColorAction;

    public SetBrightnessAndColor(final int brightness, Color.Rgb rgb) {
        brightnessAction = new SetBrightnessAction(brightness);
        setColorAction = SetColorAction.setRgb(rgb);
    }

    public SetBrightnessAndColor(final int brightness, Color.Hsv hsv) {
        this(brightness, hsv.toRgb());
    }

    public int getBrightness() {
        return brightnessAction.getBrightness();
    }

    public Color.Rgb getRgb() {
        return setColorAction.getRgb();
    }
}
