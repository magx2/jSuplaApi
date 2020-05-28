package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.ElectricityMeterState;

import java.util.Optional;

public interface ElectricityMeterChannel extends Channel {
    @Override
    Optional<ElectricityMeterState> findState();
}
