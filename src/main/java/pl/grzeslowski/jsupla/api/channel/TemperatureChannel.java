package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

public interface TemperatureChannel extends Channel {
    @Override
    TemperatureState getState();

    /**
     * Temperature adjustment in 0.01°C, [-1000, 1000]
     *
     * @return temperature adjustment
     */
    int getTemperatureAdjustment();
}
