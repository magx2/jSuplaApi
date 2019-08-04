package pl.grzeslowski.jsupla.api.schedule;

import java.time.ZonedDateTime;

public interface FutureExecution {
    ZonedDateTime getPlannedTimestamp();
}
