package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;

import static java.util.Objects.requireNonNull;

@Getter
@ToString
public final class SetColorAction implements Action {
    private final Color.Rgb rgb;

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
