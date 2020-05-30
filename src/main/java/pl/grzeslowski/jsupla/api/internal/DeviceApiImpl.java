package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.IoDevicesApi;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import pl.grzeslowski.jsupla.api.DeviceApi;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toMap;
import static pl.grzeslowski.jsupla.api.internal.ToStringHelper.niceToString;

@Slf4j
final class DeviceApiImpl implements DeviceApi {
    private static final List<String> DEFAULT_INCLUDE = singletonList("connected");
    private final IoDevicesApi ioDevicesApi;
    private final ChannelApiImpl channelApi;

    DeviceApiImpl(final ApiClient apiClient) {
        this.ioDevicesApi = new IoDevicesApi(apiClient);
        this.channelApi = new ChannelApiImpl(apiClient);
    }

    @Override
    public Device findDevice(int id) {
        try {
            val channels = findChannels();
            return mapToDeviceWithChannels(ioDevicesApi.getIoDevice(id, DEFAULT_INCLUDE), channels);
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findDevice/" + id, e);
        }
    }

    @Override
    public SortedSet<Device> findDevices() {
        try {
            val channels = findChannels();
            return ioDevicesApi.getIoDevices(DEFAULT_INCLUDE)
                           .stream()
                           .map((io.swagger.client.model.Device device) -> mapToDeviceWithChannels(device, channels))
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findDevices", e);
        }
    }

    private SortedSet<Channel> findChannels() {
        log.debug("Loading all channels to build device");
        return channelApi.findChannels();
    }

    private Device mapToDeviceWithChannels(final io.swagger.client.model.Device device,
                                           final SortedSet<Channel> cloudChannels) {
        log.trace("Got device {}", niceToString(device));
        val channelsMap = cloudChannels.stream().collect(toMap(Channel::getId, Function.identity()));
        final SortedSet<Channel> channels = device.getChannelsIds()
                                                    .stream()
                                                    .filter(channelsMap::containsKey)
                                                    .map(channelsMap::get)
                                                    .collect(Collectors.toCollection(TreeSet::new));
        return new DeviceImpl(device, channels);
    }
}
