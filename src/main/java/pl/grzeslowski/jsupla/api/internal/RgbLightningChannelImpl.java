package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.HsbTypeConverter;
import pl.grzeslowski.jsupla.api.channel.RgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class RgbLightningChannelImpl extends ChannelImpl implements RgbLightningChannel {
    private final ColorState state;

    RgbLightningChannelImpl(final Channel channel) {
        super(channel);
        final HsbTypeConverter.Hsv hsv = HsbTypeConverter.INSTANCE.toHsv(
                channel.getState().getColor(), 100
        );
        state = new ColorStateImpl(hsv);
    }

    @Override
    public ColorState getState() {
        return state;
    }
}
