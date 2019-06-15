package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.ChannelApi;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.generated.ApiClient;
import pl.grzeslowski.jsupla.api.generated.ApiException;
import pl.grzeslowski.jsupla.api.generated.api.ChannelsApi;
import pl.grzeslowski.jsupla.api.generated.api.IoDevicesApi;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ChannelApiImpl implements ChannelApi {
    public static final List<String> DEFAULT_INCLUDE = asList("connected", "state");
    private final ChannelsApi channelsApi;
    private final IoDevicesApi ioDevicesApi;

    public ChannelApiImpl(final ApiClient apiClient) {
        channelsApi = new ChannelsApi(apiClient);
        ioDevicesApi = new IoDevicesApi(apiClient);
    }

    @Override
    public Channel findChannel(final int id) {
        try {
            return mapToChannel(channelsApi.getChannel(id, DEFAULT_INCLUDE));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannel/" + id, e);
        }
    }

    @Override
    public SortedSet<Channel> findChannels() {
        try {
            return channelsApi.getChannels(DEFAULT_INCLUDE, null, null, null)
                           .stream()
                           .map(this::mapToChannel)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannels", e);
        }
    }

    @Override
    public SortedSet<Channel> findChannels(final Device device) {
        try {
            return ioDevicesApi.getIoDeviceChannels(device.getId(), DEFAULT_INCLUDE)
                           .stream()
                           .map(this::mapToChannel)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannels/" + device.getId(), e);
        }
    }

    private Channel mapToChannel(pl.grzeslowski.jsupla.api.generated.model.Channel channel) {
        return new ChannelImpl(channel);
    }
}
