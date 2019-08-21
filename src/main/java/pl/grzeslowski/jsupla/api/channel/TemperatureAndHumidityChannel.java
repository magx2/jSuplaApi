package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;

import java.util.Optional;

public interface TemperatureAndHumidityChannel extends TemperatureChannel, HumidityChannel {
    @Override
    Optional<TemperatureAndHumidityState> findState();
}
