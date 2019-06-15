package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.state.State;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class ChannelImpl implements Channel {
    private final State state;
    private Integer id;
    private Integer channelNumber;
    private String caption;
    private Boolean hidden;
    private Boolean connected;

    ChannelImpl(pl.grzeslowski.jsupla.api.internal.generated.model.Channel channel) {
        requireNonNull(channel);
        id = channel.getId();
        channelNumber = channel.getChannelNumber();
        caption = channel.getCaption();
        hidden = channel.isHidden();
        connected = channel.isConnected();
        this.state = new StateImpl(
                channel.getParam1(),
                channel.getParam2(),
                channel.getParam3(),
                channel.getFunction().getName(),
                channel.getState()
        );
    }

    @Override
    public final int compareTo(final Channel o) {
        return Integer.compare(getId(), o.getId());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getChannelNumber() {
        return channelNumber;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public State getState() {
        return state;
    }
}
