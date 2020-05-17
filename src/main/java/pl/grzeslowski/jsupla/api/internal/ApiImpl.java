package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import pl.grzeslowski.jsupla.api.Api;
import pl.grzeslowski.jsupla.api.ChannelApi;
import pl.grzeslowski.jsupla.api.ChannelGroupApi;
import pl.grzeslowski.jsupla.api.DeviceApi;
import pl.grzeslowski.jsupla.api.LocationApi;
import pl.grzeslowski.jsupla.api.ServerInfoApi;

import static pl.grzeslowski.jsupla.api.internal.ApiClientFactory.INSTANCE;

public final class ApiImpl implements Api {
    private final ApiClient apiClient;

    public ApiImpl(String token, String url) {
        this.apiClient = INSTANCE.newApiClient(token, url);
    }

    public ApiImpl(String token) {
        this.apiClient = INSTANCE.newApiClient(token);
    }

    @Override
    public DeviceApi getDeviceApi() {
        return new DeviceApiImpl(apiClient);
    }

    @Override
    public ChannelApi getChannelApi() {
        return new ChannelApiImpl(apiClient);
    }

    @Override
    public ChannelGroupApi getChannelGroupApi() {
        return new ChannelApiImpl(apiClient);
    }

    @Override
    public LocationApi getLocationApi() {
        return new LocationApiImpl(apiClient);
    }

    @Override
    public ServerInfoApi getServerInfoApi() {
        return new ServerInfoApiImpl(apiClient);
    }

    @Override
    public String getApiVersion() {
        return ApiClientFactory.getApiVersion();
    }
}
