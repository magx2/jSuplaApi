package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;

public interface GateChannel extends Channel {
    PartialOpenState getPartialOpenState();
}
