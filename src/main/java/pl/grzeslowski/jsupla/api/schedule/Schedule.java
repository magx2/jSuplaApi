package pl.grzeslowski.jsupla.api.schedule;

import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithEnabled;
import pl.grzeslowski.jsupla.api.common.WithId;

import java.time.ZonedDateTime;
import java.util.List;

public interface Schedule extends WithId, WithEnabled, WithCaption, Comparable<Schedule> {
    String getTimeExpression();

    ScheduleMode getMode();

    ZonedDateTime getDateStart();

    ZonedDateTime getDateEnd();

    boolean isRetry();

    Channel getChannel();

    List<Execution> getClosestExecutions();

    enum ScheduleMode {
        MINUTELY, HOURLY, DAILY, ONCE
    }
}
