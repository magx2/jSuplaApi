package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

public interface TemperatureChannel extends Channel {
    TemperatureState getTemperatureState();
}
