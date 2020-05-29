package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.internal.ApiImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

public interface Api {
    static Api getInstance(String token) {
        return new ApiImpl(token);
    }

    static Api getInstance(String token, String url) {
        return new ApiImpl(token, url);
    }

    DeviceApi getDeviceApi();

    ChannelApi getChannelApi();

    ChannelGroupApi getChannelGroupApi();

    LocationApi getLocationApi();

    ServerInfoApi getServerInfoApi();

    String getApiVersion();

    Optional<ApiUsageStatistics> getApiUsageStatistics();

    interface ApiUsageStatistics {
        ZonedDateTime getLastUpdateDate();

        int getLimit();

        int getRemainingLimit();

        ZonedDateTime getResetDate();
    }
}
