package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.device.Device;

import java.util.SortedSet;

public interface DeviceApi {
    Device findDevice(int id);

    SortedSet<Device> findDevices();
}
