package pl.grzeslowski.jsupla.api.channel.action;

import lombok.Value;

@Value
public class SetBrightnessAction implements Action {
    int brightness;

    public SetBrightnessAction(final int brightness) {
        if (brightness > 100) {
            throw new IllegalArgumentException("Brightness cannot be grater than 100! Was `" + brightness + "`.");
        }
        if (brightness < 0) {
            throw new IllegalArgumentException("Brightness cannot be smaller than 0! Was `" + brightness + "`.");
        }
        this.brightness = brightness;
    }
}
