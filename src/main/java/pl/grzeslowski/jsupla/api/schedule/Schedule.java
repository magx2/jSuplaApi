package pl.grzeslowski.jsupla.api.schedule;

import pl.grzeslowski.jsupla.api.common.WithCaption;
import pl.grzeslowski.jsupla.api.common.WithEnabled;

public interface Schedule extends WithEnabled, WithCaption, Comparable<Schedule> {
}
