package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.Api;
import pl.grzeslowski.jsupla.api.ChannelApi;
import pl.grzeslowski.jsupla.api.DeviceApi;
import pl.grzeslowski.jsupla.api.generated.ApiClient;

import static pl.grzeslowski.jsupla.api.internal.ApiClientFactory.INSTANCE;

public final class ApiImpl implements Api {
    private final ApiClient apiClient;

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
}
