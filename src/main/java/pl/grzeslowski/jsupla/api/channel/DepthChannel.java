package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.DepthState;

public interface DepthChannel extends Channel {
    @Override
    DepthState getState();
}
