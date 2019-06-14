package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.state.State;

@ToString
@EqualsAndHashCode
final class ChannelImpl implements Channel {
    private final pl.grzeslowski.jsupla.api.generated.model.Channel channel;

    ChannelImpl(pl.grzeslowski.jsupla.api.generated.model.Channel channel) {
        this.channel = channel;
    }

    @Override
    public final int compareTo(final Channel o) {
        return Integer.compare(getId(), o.getId());
    }

    @Override
    public int getId() {
        return channel.getId();
    }

    @Override
    public int getChannelNumber() {
        return channel.getChannelNumber();
    }

    @Override
    public String getCaption() {
        return channel.getCaption();
    }

    @Override
    public boolean isHidden() {
        return channel.isHidden();
    }

    @Override
    public boolean isConnected() {
        return channel.isConnected();
    }

    @Override
    public State getState() {
        return null; // TODO
    }
}
