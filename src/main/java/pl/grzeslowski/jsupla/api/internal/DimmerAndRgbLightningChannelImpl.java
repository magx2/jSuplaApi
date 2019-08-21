package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DimmerAndRgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DimmerAndRgbLightningChannelImpl extends ChannelImpl implements DimmerAndRgbLightningChannel {
    private final ColorAndBrightnessState state;

    DimmerAndRgbLightningChannelImpl(final Channel channel) {
        super(channel);
        this.state = findState(channel, () -> {
            final BrightnessState brightnessState = new DimmerChannelImpl(channel).findState().get();
            final ColorState colorState = new RgbLightningChannelImpl(channel).findState().get();
            return new ColorAndBrightnessStateImpl(brightnessState, colorState);
        });
    }

    @Override
    public Optional<ColorAndBrightnessState> findState() {
        return Optional.ofNullable(state);
    }
}
