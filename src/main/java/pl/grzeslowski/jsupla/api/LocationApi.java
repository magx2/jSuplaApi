package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.location.Location;

import java.util.SortedSet;

public interface LocationApi {
    Location findLocation(int id);

    SortedSet<Location> findLocations();
}
