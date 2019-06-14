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
    private final pl.grzeslowski.jsupla.api.generated.model.Device device;
    private final ZonedDateTime lastConnected;
    private final SortedSet<Channel> channels;

    DeviceImpl(pl.grzeslowski.jsupla.api.generated.model.Device device) {
        this.device = requireNonNull(device);
        final String format = device.getLastConnected().toZonedDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        this.lastConnected = ZonedDateTime.parse(format, ISO_OFFSET_DATE_TIME);
        this.channels = device.getChannels()
                                .stream()
                                .map(ChannelImpl::new)
                                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public int getId() {
        return device.getId();
    }

    @Override
    public boolean isEnabled() {
        return device.isEnabled();
    }

    @Override
    public String getName() {
        return device.getName();
    }

    @Override
    public ZonedDateTime getLastConnected() {
        return lastConnected;
    }

    @Override
    public String getSoftwareVersion() {
        return device.getSoftwareVersion();
    }

    @Override
    public String getGuidString() {
        return device.getGUIDString();
    }

    @Override
    public SortedSet<Channel> getChannels() {
        return channels;
    }
}
