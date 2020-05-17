package pl.grzeslowski.jsupla.api.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.location.Location;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableSortedSet;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class LocationImpl implements Location {
    int id;
    char[] password;
    SortedSet<Device> devices;
    String caption;

    LocationImpl(io.swagger.client.model.Location location) {
        this(location.getId(),
                location.getPassword().toCharArray(),
                unmodifiableSortedSet(
                        location.getIodevices()
                                .stream()
                                .map(DeviceImpl::new)
                                .collect(Collectors.toCollection(TreeSet::new))),
                location.getCaption());
    }

    @Override
    public int compareTo(final Location o) {
        return Integer.compare(getId(), o.getId());
    }
}
