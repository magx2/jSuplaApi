package pl.grzeslowski.jsupla.api.device;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.common.WithConnected;
import pl.grzeslowski.jsupla.api.common.WithEnabled;
import pl.grzeslowski.jsupla.api.common.WithId;
import pl.grzeslowski.jsupla.api.location.Location;
import pl.grzeslowski.jsupla.api.schedule.Schedule;

import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.util.SortedSet;

public interface Device extends WithId, WithEnabled, WithConnected, Comparable<Device> {
    String getName();

    String getComment();

    ZonedDateTime getRegisteredDate();

    InetAddress getRegisteredIp();

    ZonedDateTime getLastConnected();

    InetAddress getLastConnectedIp();

    String getSoftwareVersion();

    String getGuid();

    Location getLocation();

    Location getOriginalLocation();

    SortedSet<Channel> getChannels();

    SortedSet<Schedule> getSchedules();
}
