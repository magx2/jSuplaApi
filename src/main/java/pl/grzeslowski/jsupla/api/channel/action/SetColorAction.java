package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Value;
import pl.grzeslowski.jsupla.api.Color;

import static java.util.Objects.requireNonNull;

@Value
public class SetColorAction implements Action {
    Color.Rgb rgb;

    public static SetColorAction setRgb(Color.Rgb rgb) {
        return new SetColorAction(rgb);
    }

    public static SetColorAction setHsv(Color.Hsv hsv) {
        return new SetColorAction(hsv.toRgb());
    }

    private SetColorAction(final Color.Rgb rgb) {
        this.rgb = requireNonNull(rgb);
    }
}
