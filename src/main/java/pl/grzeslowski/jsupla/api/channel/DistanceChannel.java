package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.DistanceState;

public interface DistanceChannel extends Channel {
    DistanceState getDistanceState();
}
