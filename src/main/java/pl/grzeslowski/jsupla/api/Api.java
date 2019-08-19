package pl.grzeslowski.jsupla.api;

import pl.grzeslowski.jsupla.api.internal.ApiImpl;

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
}
