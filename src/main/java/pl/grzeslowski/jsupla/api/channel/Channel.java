package pl.grzeslowski.jsupla.api.channel;

import pl.grzeslowski.jsupla.api.channel.state.State;

public interface Channel extends Comparable<Channel> {
    int getId();

    int getChannelNumber();

    String getCaption();

    boolean isHidden();

    boolean isConnected();

    State getState();
}
