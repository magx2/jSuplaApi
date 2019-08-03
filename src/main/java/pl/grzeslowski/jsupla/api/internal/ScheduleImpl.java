package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.ScheduleClosestExecutions;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.schedule.Execution;
import pl.grzeslowski.jsupla.api.schedule.FutureExecution;
import pl.grzeslowski.jsupla.api.schedule.PastExecution;
import pl.grzeslowski.jsupla.api.schedule.PastExecutionResult;
import pl.grzeslowski.jsupla.api.schedule.Schedule;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.grzeslowski.jsupla.api.internal.Helper.parseChannel;
import static pl.grzeslowski.jsupla.api.internal.Helper.parseZonedDateTime;

@EqualsAndHashCode
@ToString
class ScheduleImpl implements Schedule {
    private final int id;
    private final String timeExpression;
    private final ScheduleMode mode;
    private final ZonedDateTime dateStart;
    private final ZonedDateTime dateEnded;
    private final boolean retry;
    private final Channel channel;
    private final List<Execution> closestExecutions;
    private final String caption;
    private final boolean enabled;

    ScheduleImpl(io.swagger.client.model.Schedule schedule) {
        id = schedule.getId();
        timeExpression = schedule.getTimeExpression();
        mode = parseMode(schedule.getMode());
        dateStart = parseZonedDateTime(schedule.getDateStart());
        dateEnded = parseZonedDateTime(schedule.getDateEnd());
        retry = schedule.isRetry();
        channel = parseChannel(schedule.getChannel());
        closestExecutions = parseClosestExecution(schedule.getClosestExecutions());
        caption = schedule.getCaption();
        enabled = schedule.isEnabled();
    }

    private List<Execution> parseClosestExecution(final List<ScheduleClosestExecutions> closestExecutions) {
        if (closestExecutions == null) {
            return new ArrayList<>(0);
        }
        return closestExecutions.stream()
                       .map(this::parseExecution)
                       .collect(Collectors.toList());
    }

    private Execution parseExecution(final ScheduleClosestExecutions scheduleClosestExecutions) {
        final List<PastExecution> pastExecutions;
        if (scheduleClosestExecutions.getPast() == null) {
            pastExecutions = new ArrayList<>(0);
        } else {
            pastExecutions = scheduleClosestExecutions.getPast()
                                     .stream()
                                     .map(past -> new PastExecutionImpl(
                                             parseZonedDateTime(past.getPlannedTimestamp()),
                                             parseZonedDateTime(past.getResultTimestamp()),
                                             past.isFailed(),
                                             new PastExecutionResultImpl(past.getResult().getCaption())
                                     ))
                                     .collect(Collectors.toList());
        }
        final List<FutureExecution> futureExecutions;
        if (scheduleClosestExecutions.getFuture() == null) {
            futureExecutions = new ArrayList<>(0);
        } else {
            futureExecutions = scheduleClosestExecutions.getFuture()
                                       .stream()
                                       .map(future -> new FutureExecutionImpl(parseZonedDateTime(future.getPlannedTimestamp())))
                                       .collect(Collectors.toList());
        }
        return new ExecutionImpl(pastExecutions, futureExecutions);
    }

    private ScheduleMode parseMode(final io.swagger.client.model.Schedule.ModeEnum mode) {
        switch (mode) {
            case MINUTELY:
                return ScheduleMode.MINUTELY;
            case HOURLY:
                return ScheduleMode.HOURLY;
            case DAILY:
                return ScheduleMode.DAILY;
            case ONCE:
                return ScheduleMode.ONCE;
            default:
                throw new IllegalStateException("Cannot parse `" + mode + "`! Should never happen!");
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTimeExpression() {
        return timeExpression;
    }

    @Override
    public ScheduleMode getMode() {
        return mode;
    }

    @Override
    public ZonedDateTime getDateStart() {
        return dateStart;
    }

    @Override
    public ZonedDateTime getDateEnd() {
        return dateEnded;
    }

    @Override
    public boolean isRetry() {
        return retry;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public List<Execution> getClosestExecutions() {
        return closestExecutions;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public int compareTo(final Schedule o) {
        final int compareCaption = caption.compareTo(o.getCaption());
        if (compareCaption != 0) {
            return compareCaption;
        }
        return Integer.compare(getId(), o.getId());
    }

    @Value
    private static class ExecutionImpl implements Execution {
        private final List<PastExecution> pastExecutions;
        private final List<FutureExecution> futureExecutions;
    }

    @Value
    private static class PastExecutionImpl implements PastExecution {
        private final ZonedDateTime plannedTimestamp;
        private final ZonedDateTime resultTimestamp;
        private final boolean failed;
        private final PastExecutionResultImpl pastExecutionResult;
    }

    @Value
    private static class PastExecutionResultImpl implements PastExecutionResult {
        private final String caption;
    }

    @Value
    private static class FutureExecutionImpl implements FutureExecution {
        private final ZonedDateTime plannedTimestamp;
    }
}
