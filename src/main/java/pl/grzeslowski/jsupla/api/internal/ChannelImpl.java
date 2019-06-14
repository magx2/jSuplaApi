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
    private final boolean isHidden;
    private final boolean isConnected;

    protected ChannelImpl(
            final int id,
            final int channelNumber,
            final String caption,
            final boolean isHidden,
            final boolean isConnected) {
        this.id = id;
        this.channelNumber = channelNumber;
        this.caption = caption;
        this.isHidden = isHidden;
        this.isConnected = isConnected;
    }

    protected ChannelImpl(pl.grzeslowski.jsupla.api.generated.model.Channel channel) {
        this(
                channel.getId(),
                channel.getChannelNumber(),
                channel.getCaption(),
                channel.isHidden(),
                channel.isConnected());
    }

    @Override
    public final int compareTo(final Channel o) {
        if (o == null) {
            return -1;
        }
        return id - o.getId();
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
        return isHidden;
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }
}
