package pl.grzeslowski.jsupla.api.schedule;

import java.time.ZonedDateTime;

public interface PastExecution {
    ZonedDateTime getPlannedTimestamp();

    ZonedDateTime getResultTimestamp();

    boolean isFailed();

    PastExecutionResult getPastExecutionResult();
}
