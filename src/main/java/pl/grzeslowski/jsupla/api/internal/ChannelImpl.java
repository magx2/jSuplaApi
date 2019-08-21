package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;

import java.util.function.Supplier;

@ToString
@EqualsAndHashCode
abstract class ChannelImpl implements Channel {
    private final int id;
    private final int channelNumber;
    private final String caption;
    private final boolean hidden;
    private final boolean connected;
    private final boolean output;

    protected static <StateT> StateT findState(io.swagger.client.model.Channel channel, Supplier<StateT> mapper) {
        if (channel.isConnected()) {
            return mapper.get();
        } else {
            return null;
        }
    }

    protected ChannelImpl(
            final int id,
            final int channelNumber,
            final String caption,
            final boolean hidden,
            final boolean connected,
            final Boolean output) {
        this.id = id;
        this.channelNumber = channelNumber;
        this.caption = caption;
        this.hidden = hidden;
        this.connected = connected;
        this.output = output != null && output;
    }

    public ChannelImpl(io.swagger.client.model.Channel channel) {
        this(
                channel.getId(),
                channel.getChannelNumber(),
                channel.getCaption(),
                channel.isHidden(),
                channel.isConnected(),
                channel.getType().isOutput());
    }

    @Override
    public final int compareTo(final Channel o) {
        final int compareChannelNumber = Integer.compare(channelNumber, o.getChannelNumber());
        if (compareChannelNumber != 0) {
            return compareChannelNumber;
        }
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
    public boolean isOutput() {
        return output;
    }

    @Override
    public boolean isInput() {
        return !isOutput();
    }
}
