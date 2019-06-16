package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DimmerChannel;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DimmerChannelImpl extends ChannelImpl implements DimmerChannel {
    private final BrightnessState state;

    DimmerChannelImpl(final Channel channel) {
        super(channel);
        state = new PercentageState(channel.getState().getBrightness());
    }

    @Override
    public BrightnessState getState() {
        return state;
    }
}
