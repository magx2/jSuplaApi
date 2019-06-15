package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.threeten.bp.format.DateTimeFormatter;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;

import java.time.ZonedDateTime;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class DeviceImpl implements Device {
    private final Integer id;
    private final Boolean enabled;
    private final String name;
    private final String softwareVersion;
    private final ZonedDateTime lastConnected;
    private final String guid;
    private final SortedSet<Channel> channels;

    DeviceImpl(pl.grzeslowski.jsupla.api.generated.model.Device device) {
        requireNonNull(device);
        final String format = device.getLastConnected().toZonedDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        this.id = device.getId();
        this.enabled = device.isEnabled();
        this.name = device.getName();
        this.lastConnected = ZonedDateTime.parse(format, ISO_OFFSET_DATE_TIME);
        this.softwareVersion = device.getSoftwareVersion();
        this.guid = device.getGUIDString();
        this.channels = device.getChannels()
                                .stream()
                                .map(ChannelImpl::new)
                                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ZonedDateTime getLastConnected() {
        return lastConnected;
    }

    @Override
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    @Override
    public String getGuid() {
        return guid;
    }

    @Override
    public SortedSet<Channel> getChannels() {
        return channels;
    }

    @Override
    public int compareTo(final Device o) {
        final int nameCompare = getName().compareTo(o.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(getId(), o.getId());
    }
}
