package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;
import pl.grzeslowski.jsupla.api.channel.RgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class RgbLightningChannelImpl extends ChannelImpl implements RgbLightningChannel {
    private final ColorState state;

    RgbLightningChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> {
            final Color.Hsv hsv = HsbTypeConverter.INSTANCE.toHsv(
                    channel.getState().getColor(),
                    channel.getState().getColorBrightness()
            );
            return new ColorStateImpl(hsv);
        });
    }

    @Override
    public Optional<ColorState> findState() {
        return Optional.ofNullable(state);
    }
}
