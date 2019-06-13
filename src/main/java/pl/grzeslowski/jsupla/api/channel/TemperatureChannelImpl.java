package pl.grzeslowski.jsupla.api.channel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;
import pl.grzeslowski.jsupla.api.generated.model.Channel;
import pl.grzeslowski.jsupla.api.generated.model.ChannelState;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TemperatureChannelImpl extends ChannelImpl implements TemperatureChannel {
    private final TemperatureState state;

    TemperatureChannelImpl(final Channel channel) {
        super(channel);
        this.state = new BigDecimalState(findTemperature(channel));
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
