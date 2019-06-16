package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;

public interface TemperatureAndHumidityChannel extends TemperatureChannel, HumidityChannel {
    TemperatureAndHumidityState getTemperatureAndHumidityState();
}
