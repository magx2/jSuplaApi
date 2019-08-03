package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.IoDevicesApi;
import pl.grzeslowski.jsupla.api.DeviceApi;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

final class DeviceApiImpl implements DeviceApi {
    private static final List<String> DEFAULT_INCLUDE = asList("channels", "connected");
    private final IoDevicesApi ioDevicesApi;
    private final ChannelApiImpl channelApi;

    DeviceApiImpl(final ApiClient apiClient) {
        this.ioDevicesApi = new IoDevicesApi(apiClient);
        this.channelApi = new ChannelApiImpl(apiClient);
    }

    @Override
    public Device findDevice(int id) {
        try {
            return mapToDevice(ioDevicesApi.getIoDevice(id, DEFAULT_INCLUDE));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findDevice/" + id, e);
        }
    }

    @Override
    public SortedSet<Device> findDevices() {
        try {
            return ioDevicesApi.getIoDevices(singletonList("connected"))
                           .stream()
                           .map(this::mapToDeviceWithChannels)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findDevices", e);
        }
    }

    private Device mapToDeviceWithChannels(final io.swagger.client.model.Device device) {
        final SortedSet<Channel> channels = device.getChannelsIds()
                                                    .stream()
                                                    .map(channelApi::findChannel)
                                                    .collect(Collectors.toCollection(TreeSet::new));
        return new DeviceImpl(device, channels);
    }

    private Device mapToDevice(io.swagger.client.model.Device device) {
        return new DeviceImpl(device);
    }
}
