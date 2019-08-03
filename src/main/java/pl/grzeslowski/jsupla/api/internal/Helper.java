package pl.grzeslowski.jsupla.api.internal;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import pl.grzeslowski.jsupla.api.channel.Channel;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static pl.grzeslowski.jsupla.api.internal.ChannelDispatcher.INSTANCE;

final class Helper {
    static ZonedDateTime parseZonedDateTime(OffsetDateTime offsetDateTime) {
        String format = offsetDateTime.toZonedDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return ZonedDateTime.parse(format, ISO_OFFSET_DATE_TIME);
    }

    static Channel parseChannel(io.swagger.client.model.Channel channel) {
        if (channel == null) {
            return null;
        }
        return ChannelFunctionDispatcher.DISPATCHER.dispatch(channel, INSTANCE);
    }

    static Set<Channel> parseChannels(final io.swagger.client.model.Device device) {
        if (device.getChannels() == null) {
            return new TreeSet<>();
        }
        return device.getChannels()
                       .stream()
                       .map(Helper::parseChannel)
                       .collect(Collectors.toCollection(TreeSet::new));
    }

    private Helper() {
        // do not create this class
    }
}
