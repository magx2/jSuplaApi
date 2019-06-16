package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.State;

public interface NoneChannel extends Channel {
    State getNoneState();
}
