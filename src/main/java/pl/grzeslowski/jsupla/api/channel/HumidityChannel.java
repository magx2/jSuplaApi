package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.HumidityState;

public interface HumidityChannel extends Channel {
    @Override
    HumidityState getState();
}
