package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.HumidityState;

public interface HumidityChannel extends Channel {
    @Override
    HumidityState getState();

    /**
     * Humidity adjustment in 0.01%, [-1000, 1000]
     *
     * @return humidity adjustment
     */
    int getHumidityAdjustment();
}
