package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Color;
import pl.grzeslowski.jsupla.api.channel.RgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class RgbLightningChannelImpl extends ChannelImpl implements RgbLightningChannel {
    private final ColorState state;

    RgbLightningChannelImpl(final Channel channel) {
        super(channel);
        final Color.Hsv hsv = HsbTypeConverter.INSTANCE.toHsv(
                channel.getState().getColor(), 100
        );
        state = new ColorStateImpl(hsv);
    }

    @Override
    public ColorState getState() {
        return state;
    }
}
