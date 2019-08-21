package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.HumidityState;

import java.util.Optional;

public interface HumidityChannel extends Channel {
    @Override
    Optional<? extends HumidityState> findState();

    /**
     * Humidity adjustment in 0.01%, [-1000, 1000]
     *
     * @return humidity adjustment
     */
    int getHumidityAdjustment();
}
