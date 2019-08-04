package pl.grzeslowski.jsupla.api.channel;

public interface OpeningChannel {
    /**
     * Opening time in ms, [500, 2000].
     *
     * @return opening time in ms
     */
    int getOpeningTimeInMs();

    /**
     * @return ID of the opening sensor
     */
    int getIdOfOpeningSensor();
}
