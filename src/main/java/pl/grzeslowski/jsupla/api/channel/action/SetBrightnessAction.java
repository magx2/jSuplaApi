package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SetBrightnessAction implements Action {
    private final int brightness;

    public SetBrightnessAction(final int brightness) {
        if (brightness > 100) {
            throw new IllegalArgumentException("Brightness cannot be grater than 100!");
        }
        if (brightness < 0) {
            throw new IllegalArgumentException("Brightness cannot be smaller than 0!");
        }
        this.brightness = brightness;
    }
}
