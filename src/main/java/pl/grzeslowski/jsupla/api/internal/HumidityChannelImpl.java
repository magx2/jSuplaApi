package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.HumidityChannel;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
final class HumidityChannelImpl extends ChannelImpl implements HumidityChannel {
    private final int humidityAdjustment;
    private final HumidityState state;

    HumidityChannelImpl(final Channel channel) {
        super(channel);
        humidityAdjustment = channel.getParam3() != null ? channel.getParam3() : 0;
        state = new HumidityStateImpl(new Percentage(findHumidity(channel)));
    }

    private BigDecimal findHumidity(Channel channel) {
        final ChannelState state = channel.getState();
        final BigDecimal humidity = state.getHumidity();
        return new BigDecimal(humidityAdjustment)
                       .divide(new BigDecimal(100.0), CEILING)
                       .add(humidity);
    }
}
