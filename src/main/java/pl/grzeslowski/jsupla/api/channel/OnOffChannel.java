package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.OnOffState;

import java.util.Optional;

public interface OnOffChannel extends Channel {
    @Override
    Optional<OnOffState> findState();
}
