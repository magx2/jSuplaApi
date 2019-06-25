package pl.grzeslowski.jsupla.api.location;

import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithId;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.SortedSet;

public interface Location extends WithId, WithCaption, Comparable<Location> {
    char[] getPassword();

    SortedSet<Device> getDevices();
}
