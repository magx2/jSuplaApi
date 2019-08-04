package pl.grzeslowski.jsupla.api.schedule;

import java.util.List;

public interface Execution {
    List<PastExecution> getPastExecutions();

    List<FutureExecution> getFutureExecutions();
}
