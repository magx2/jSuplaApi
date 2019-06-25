package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.channel.action.Action;
import pl.grzeslowski.jsupla.api.channelgroup.ChannelGroup;

import java.util.SortedSet;

public interface ChannelGroupApi {
    ChannelGroup findChannelGroup(int id);

    SortedSet<ChannelGroup> findChannelGroups();

    void updateState(ChannelGroup channelGroup, Action action);
}
