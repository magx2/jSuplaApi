package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.location.Location;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
final class LocationImpl implements Location {
    private final int id;
    private final char[] password;
    private final SortedSet<Device> devices;
    private final String caption;

    LocationImpl(pl.grzeslowski.jsupla.api.generated.model.Location location) {
        id = location.getId();
        password = location.getPassword().toCharArray();
        devices = location.getIodevices()
                          .stream()
                          .map(DeviceImpl::new)
                          .collect(Collectors.toCollection(TreeSet::new));
        caption = location.getCaption();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public SortedSet<Device> getDevices() {
        return devices;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public int compareTo(final Location o) {
        return Integer.compare(getId(), o.getId());
    }
}
