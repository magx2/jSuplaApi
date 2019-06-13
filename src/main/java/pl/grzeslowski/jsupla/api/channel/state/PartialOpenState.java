package pl.grzeslowski.jsupla.api.channel.state;

import java.util.Optional;

public interface PartialOpenState extends OnOffState {
    Optional<OnOff> partialState();
}
