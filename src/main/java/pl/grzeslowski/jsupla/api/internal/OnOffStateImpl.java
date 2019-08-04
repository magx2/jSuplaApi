package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.function.Function;

import static java.util.Objects.requireNonNull;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.OFF;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.ON;

@ToString
@EqualsAndHashCode
@Getter
final class OnOffStateImpl implements OnOffState {
    private final OnOff onOff;

    static OnOffState hi(Channel channel) {
        return new OnOffStateImpl(channel, ChannelState::isHi);
    }

    static OnOffState on(Channel channel) {
        return new OnOffStateImpl(channel, ChannelState::isOn);
    }

    private OnOffStateImpl(final OnOff onOff) {
        this.onOff = requireNonNull(onOff);
    }

    private OnOffStateImpl(final boolean booleanState) {
        this(booleanState ? ON : OFF);
    }

    private OnOffStateImpl(final Channel channel, final Function<ChannelState, Boolean> toBooleanState) {
        this(finBooleanState(channel, toBooleanState));
    }

    private static boolean finBooleanState(final Channel channel, final Function<ChannelState, Boolean> toBooleanState) {
        final Integer inverted = channel.getParam3();
        final Boolean booleanState = toBooleanState.apply(channel.getState());
        if (inverted != null) {
            if (inverted > 0) {
                return !booleanState;
            } else {
                return booleanState;
            }
        } else {
            return booleanState;
        }
    }

    @Override
    public OnOff getOnOffState() {
        return onOff;
    }
}
