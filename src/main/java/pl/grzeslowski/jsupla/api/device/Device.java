package pl.grzeslowski.jsupla.api.device;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.common.WithEnabled;
import pl.grzeslowski.jsupla.api.common.WithId;

import java.time.ZonedDateTime;
import java.util.SortedSet;

public interface Device extends WithId, WithEnabled {
    String getName();

    ZonedDateTime getLastConnected();

    String getSoftwareVersion();

    String getGuidString();

    SortedSet<Channel> getChannels();
}
