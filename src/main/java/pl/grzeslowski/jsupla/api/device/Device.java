package pl.grzeslowski.jsupla.api.device;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.common.WithEnabled;
import pl.grzeslowski.jsupla.api.common.WithId;

import java.time.ZonedDateTime;
import java.util.SortedSet;

public interface Device extends WithId, WithEnabled, Comparable<Device> {
    String getName();

    String getComment();

    ZonedDateTime getLastConnected();

    String getSoftwareVersion();

    String getGuid();

    SortedSet<Channel> getChannels();
}
