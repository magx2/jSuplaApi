package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;

public interface RollerShutterChannel extends Channel {
    @Override
    RollerShutterState getState();

    /**
     * Opening time in 0.1s, [0, 3000]
     *
     * @return opening time in [ms]
     */
    int getOpeningTimeInMs();

    int getIdOfOpeningSensor();
}
