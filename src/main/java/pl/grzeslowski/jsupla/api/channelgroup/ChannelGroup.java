package pl.grzeslowski.jsupla.api.channelgroup;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithHidden;
import pl.grzeslowski.jsupla.api.common.WithId;

import java.util.SortedSet;

public interface ChannelGroup extends Comparable<Channel>, WithId, WithCaption, WithHidden {
    SortedSet<Channel> getChannels();
}
