package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.location.Location;
import pl.grzeslowski.jsupla.api.schedule.Schedule;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static java.util.Objects.requireNonNull;
import static pl.grzeslowski.jsupla.api.internal.ChannelDispatcher.INSTANCE;

@ToString
@EqualsAndHashCode
final class DeviceImpl implements Device {
    private final Integer id;
    private final Boolean enabled;
    private final String name;
    private final String comment;
    private final ZonedDateTime registeredDate;
    private final InetAddress registeredIp;
    private final ZonedDateTime lastConnected;
    private final InetAddress lastConnectedIp;
    private final String softwareVersion;
    private final String guid;
    private final boolean connected;
    private final Location location;
    private final Location originalLocation;
    private final SortedSet<Channel> channels;
    private final SortedSet<Schedule> schedules;

    DeviceImpl(io.swagger.client.model.Device device) {
        requireNonNull(device);
        this.id = device.getId();
        this.enabled = device.isEnabled();
        this.name = device.getName();
        this.comment = device.getComment();
        this.registeredDate = parseZonedDateTime(device.getRegDate());
        this.registeredIp = parseInetAddress(device.getRegIpv4());
        this.lastConnected = parseZonedDateTime(device.getLastConnected());
        this.lastConnectedIp = parseInetAddress(device.getLastIpv4());
        this.softwareVersion = device.getSoftwareVersion();
        this.guid = device.getGUIDString();
        this.connected = device.isConnected();
        this.location = parseLocation(device.getLocation());
        this.originalLocation = parseLocation(device.getOriginalLocation());
        this.channels = device.getChannels()
                                .stream()
                                .map(channel -> ChannelFunctionDispatcher.DISPATCHER.dispatch(channel, INSTANCE))
                                .collect(Collectors.toCollection(TreeSet::new));
        this.schedules = parseSchedules(device.getSchedules());
    }

    private SortedSet<Schedule> parseSchedules(final List<io.swagger.client.model.Schedule> schedules) {
        if (schedules == null) {
            return new TreeSet<>();
        }
        return schedules.stream()
                       .map(ScheduleImpl::new)
                       .collect(Collectors.toCollection(TreeSet::new));
    }

    private Location parseLocation(final io.swagger.client.model.Location location) {
        if (location == null) {
            return null;
        }
        return new LocationImpl(location);
    }

    private InetAddress parseInetAddress(final Long inetAddressAsLong) {
        try {
            return InetAddress.getByName(String.valueOf(inetAddressAsLong));
        } catch (UnknownHostException e) {
            return null;
        }
    }

    private ZonedDateTime parseZonedDateTime(OffsetDateTime offsetDateTime) {
        String format = offsetDateTime.toZonedDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return ZonedDateTime.parse(format, ISO_OFFSET_DATE_TIME);
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
    public String getComment() {
        return comment;
    }

    @Override
    public ZonedDateTime getRegisteredDate() {
        return null;
    }

    @Override
    public InetAddress getRegisteredIp() {
        return null;
    }

    @Override
    public ZonedDateTime getLastConnected() {
        return lastConnected;
    }

    @Override
    public InetAddress getLastConnectedIp() {
        return null;
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
    public boolean isConnected() {
        return connected;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public Location getOriginalLocation() {
        return originalLocation;
    }

    @Override
    public SortedSet<Channel> getChannels() {
        return channels;
    }

    @Override
    public SortedSet<Schedule> getSchedules() {
        return schedules;
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
