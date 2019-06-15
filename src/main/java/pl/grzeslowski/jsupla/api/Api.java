package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.internal.ApiImpl;

public interface Api {
    static Api getInstance(String token) {
        return new ApiImpl(token);
    }

    DeviceApi getDeviceApi();

    ChannelApi getChannelApi();
}
