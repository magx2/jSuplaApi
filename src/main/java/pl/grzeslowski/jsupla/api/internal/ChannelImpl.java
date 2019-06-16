package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;

@ToString
@EqualsAndHashCode
abstract class ChannelImpl implements Channel {
    private final int id;
    private final int channelNumber;
    private final String caption;
    private final boolean hidden;
    private final boolean connected;

    protected ChannelImpl(
            final int id,
            final int channelNumber,
            final String caption,
            final boolean hidden,
            final boolean connected) {
        this.id = id;
        this.channelNumber = channelNumber;
        this.caption = caption;
        this.hidden = hidden;
        this.connected = connected;
    }

    public ChannelImpl(io.swagger.client.model.Channel channel) {
        this(
                channel.getId(),
                channel.getChannelNumber(),
                channel.getCaption(),
                channel.isHidden(),
                channel.isConnected());
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
}
