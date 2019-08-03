package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.TemperatureChannel;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class ThermometerChannelImpl extends ChannelImpl implements TemperatureChannel {
    private final TemperatureState state;

    ThermometerChannelImpl(final Channel channel) {
        super(channel);
        this.state = new TemperatureStateImpl(findTemperature(channel));
    }

    private BigDecimal findTemperature(Channel channel) {
        final ChannelState state = channel.getState();
        final BigDecimal temperature = state.getTemperature();
        if (channel.getParam2() != null) {
            return new BigDecimal(channel.getParam2())
                           .divide(new BigDecimal(1000.0), CEILING)
                           .add(temperature);
        } else {
            return temperature;
        }
    }

    @Override
    public TemperatureState getState() {
        return state;
    }
}
