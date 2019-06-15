package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.action.Action;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.SortedSet;
import java.util.function.Supplier;

public interface ChannelApi {
    Channel findChannel(int id);

    SortedSet<Channel> findChannels();

    SortedSet<Channel> findChannels(Device device);

    Supplier<Channel> updateState(Channel channel, Action action);
}
