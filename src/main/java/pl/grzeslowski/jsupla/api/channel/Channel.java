package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithHidden;
import pl.grzeslowski.jsupla.api.common.WithId;

public interface Channel extends Comparable<Channel>, WithId, WithCaption, WithHidden {
    int getChannelNumber();

    boolean isConnected();

    State getState();

    /**
     * Whether the channel is output type (i.e. can take action).
     *
     * @return if channel is output
     */
    boolean isOutput();

    /**
     * Whether the channel is input (i.e. provide data).
     *
     * @return if channel is input
     */
    boolean isInput();
}
