package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Value;
import pl.grzeslowski.jsupla.api.Color;

@Value
public class SetBrightnessAndColor implements Action {
    SetBrightnessAction brightnessAction;
    SetColorAction setColorAction;

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
