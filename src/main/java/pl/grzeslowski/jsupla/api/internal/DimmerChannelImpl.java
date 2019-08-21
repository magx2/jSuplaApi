package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.DimmerChannel;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class DimmerChannelImpl extends ChannelImpl implements DimmerChannel {
    private final BrightnessState state;

    DimmerChannelImpl(final Channel channel) {
        super(channel);
        state = findState(channel, () -> new BrightnessStateImpl(new Percentage(channel.getState().getBrightness())));
    }

    @Override
    public Optional<BrightnessState> findState() {
        return Optional.ofNullable(state);
    }
}
