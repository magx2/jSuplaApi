package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import java.util.Optional;

public interface TemperatureChannel extends Channel {
    @Override
    Optional<? extends TemperatureState> findState();

    /**
     * Temperature adjustment in 0.01°C, [-1000, 1000]
     *
     * @return temperature adjustment
     */
    int getTemperatureAdjustment();
}
