package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.DeviceApi;
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.internal.generated.ApiClient;
import pl.grzeslowski.jsupla.api.internal.generated.ApiException;
import pl.grzeslowski.jsupla.api.internal.generated.api.IoDevicesApi;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

final class DeviceApiImpl implements DeviceApi {
    private static final List<String> DEFAULT_INCLUDE = asList("channels", "connected");
    private final IoDevicesApi ioDevicesApi;

    DeviceApiImpl(final ApiClient apiClient) {
        this.ioDevicesApi = new IoDevicesApi(apiClient);
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
            return ioDevicesApi.getIoDevices(DEFAULT_INCLUDE)
                           .stream()
                           .map(this::mapToDevice)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findDevices", e);
        }
    }

    private Device mapToDevice(pl.grzeslowski.jsupla.api.internal.generated.model.Device device) {
        return new DeviceImpl(device);
    }
}
