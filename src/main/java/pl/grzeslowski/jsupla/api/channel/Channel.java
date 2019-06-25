package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithHidden;
import pl.grzeslowski.jsupla.api.common.WithId;

public interface Channel extends Comparable<Channel>, WithId, WithCaption, WithHidden {
    int getChannelNumber();

    boolean isConnected();

    State getState();
}
