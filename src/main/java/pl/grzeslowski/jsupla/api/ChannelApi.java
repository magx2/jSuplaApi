package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.SortedSet;

public interface ChannelApi {
    Channel findChannel(int id);

    SortedSet<Channel> findChannels();

    SortedSet<Channel> findChannels(Device device);
}
