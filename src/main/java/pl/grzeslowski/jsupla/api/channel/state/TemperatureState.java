package pl.grzeslowski.jsupla.api.channel.state;

import java.math.BigDecimal;

public interface TemperatureState extends State {
    BigDecimal getTemperature();
}
