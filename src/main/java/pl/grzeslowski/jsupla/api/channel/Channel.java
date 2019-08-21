package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithHidden;
import pl.grzeslowski.jsupla.api.common.WithId;

import java.util.Optional;

public interface Channel extends Comparable<Channel>, WithId, WithCaption, WithHidden {
    int getChannelNumber();

    boolean isConnected();

    /**
     * @return channels state
     * @deprecated use findState
     */
    @Deprecated
    default State getState() {
        return findState().orElseThrow(() -> new IllegalStateException("This channel is not connected and it has no state!"));
    }

    /**
     * Finds channels state. If channel is not connected then state is <code>empty</code>.
     *
     * @return channels state
     */
    Optional<? extends State> findState();

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
