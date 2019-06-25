package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.HumidityChannel;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class HumidityChannelImpl extends ChannelImpl implements HumidityChannel {
    private final HumidityState state;

    HumidityChannelImpl(final Channel channel) {
        super(channel);
        state = new PercentageState(findHumidity(channel));
    }

    private BigDecimal findHumidity(Channel channel) {
        final ChannelState state = channel.getState();
        final BigDecimal humidity = state.getHumidity();
        if (channel.getParam3() != null) {
            return new BigDecimal(channel.getParam3())
                           .divide(new BigDecimal(1000.0), CEILING)
                           .add(humidity);
        } else {
            return humidity;
        }

    }

    @Override
    public HumidityState getState() {
        return state;
    }
}
