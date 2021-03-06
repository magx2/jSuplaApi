package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.api.LocationsApi;
import pl.grzeslowski.jsupla.api.ApiException;
import pl.grzeslowski.jsupla.api.LocationApi;
import pl.grzeslowski.jsupla.api.location.Location;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toCollection;

final class LocationApiImpl implements LocationApi {
    private static final List<String> DEFAULT_INCLUDE = asList("iodevices", "password");
    private final LocationsApi locationsApi;

    LocationApiImpl(final ApiClient apiClient) {
        locationsApi = new LocationsApi(apiClient);
    }

    @Override
    public Location findLocation(final int id) {
        try {
            return mapToLocation(locationsApi.getLocation(id, DEFAULT_INCLUDE));
        } catch (io.swagger.client.ApiException e) {
            throw new ApiException("/findLocation/" + id, e);
        }
    }

    @Override
    public SortedSet<Location> findLocations() {
        try {
            return locationsApi.getLocations(DEFAULT_INCLUDE)
                           .stream()
                           .map(this::mapToLocation)
                           .collect(toCollection(TreeSet::new));
        } catch (io.swagger.client.ApiException e) {
            throw new ApiException("/findLocations", e);
        }
    }

    private Location mapToLocation(io.swagger.client.model.Location location) {
        return new LocationImpl(location);
    }
}
