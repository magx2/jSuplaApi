package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channelgroup.ChannelGroup;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static pl.grzeslowski.jsupla.api.internal.ChannelDispatcher.INSTANCE;

@ToString
@EqualsAndHashCode
@Getter
final class ChannelGroupImpl implements ChannelGroup {
    private final int id;
    private final String caption;
    private final boolean hidden;
    private final SortedSet<Channel> channels;

    ChannelGroupImpl(io.swagger.client.model.ChannelGroup channelGroup) {
        this.id = channelGroup.getId();
        this.caption = channelGroup.getCaption();
        this.hidden = channelGroup.isHidden();
        this.channels = channelGroup.getChannels()
                                .stream()
                                .map(channel -> ChannelFunctionDispatcher.DISPATCHER.dispatch(channel, INSTANCE))
                                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public int compareTo(final Channel o) {
        return Integer.compare(getId(), o.getId());
    }
}
