package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DimmerAndRgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DimmerAndRgbLightningChannelImpl extends ChannelImpl implements DimmerAndRgbLightningChannel {
    private final ColorAndBrightnessState state;

    DimmerAndRgbLightningChannelImpl(final Channel channel) {
        super(channel);
        final BrightnessState brightnessState = new DimmerChannelImpl(channel).getState();
        final ColorState colorState = new RgbLightningChannelImpl(channel).getState();
        this.state = new ColorAndBrightnessStateImpl(brightnessState, colorState);
    }

    @Override
    public ColorAndBrightnessState getState() {
        return state;
    }
}
