package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.TemperatureChannel;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.RoundingMode.CEILING;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
final class ThermometerChannelImpl extends ChannelImpl implements TemperatureChannel {
    private final int temperatureAdjustment;
    private final TemperatureState state;

    ThermometerChannelImpl(final Channel channel) {
        super(channel);
        temperatureAdjustment = channel.getParam2() != null ? channel.getParam2() : 0;
        this.state = findState(channel, () -> new TemperatureStateImpl(findTemperature(channel)));
    }

    private BigDecimal findTemperature(Channel channel) {
        final ChannelState state = channel.getState();
        final BigDecimal temperature = state.getTemperature();
        return new BigDecimal(temperatureAdjustment)
                       .divide(new BigDecimal(100.0), CEILING)
                       .add(temperature);
    }

    @Override
    public Optional<? extends TemperatureState> findState() {
        return Optional.ofNullable(state);
    }
}
