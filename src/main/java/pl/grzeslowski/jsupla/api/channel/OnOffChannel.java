package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

public interface OnOffChannel extends Channel {
    OnOffState getOnOffState();
}
