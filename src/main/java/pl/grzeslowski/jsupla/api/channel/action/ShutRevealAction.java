package pl.grzeslowski.jsupla.api.channel.action;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public final class ShutRevealAction implements Action {
    private final int shut;

    private ShutRevealAction(final int shut) {
        if (shut > 100) {
            throw new IllegalArgumentException("Shut cannot be grater than 100!");
        }
        if (shut < 0) {
            throw new IllegalArgumentException("Shut cannot be smaller than 0!");
        }
        this.shut = shut;
    }

    public static ShutRevealAction shut(int value) {
        return new ShutRevealAction(value);
    }

    public static ShutRevealAction shut() {
        return shut(100);
    }

    public static ShutRevealAction reveal(int value) {
        return shut(100 - value);
    }

    public static ShutRevealAction reveal() {
        return reveal(100);
    }

    public int getReveal() {
        return 100 - shut;
    }
}
