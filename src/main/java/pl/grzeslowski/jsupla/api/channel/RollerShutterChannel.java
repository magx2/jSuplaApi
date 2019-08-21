package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

import java.util.Optional;

public interface RollerShutterChannel extends Channel {
    @Override
    Optional<RollerShutterState> findState();

    /**
     * Opening time in 0.1s, [0, 3000]
     *
     * @return opening time in [ms]
     */
    int getOpeningTimeInMs();

    int getIdOfOpeningSensor();
}
