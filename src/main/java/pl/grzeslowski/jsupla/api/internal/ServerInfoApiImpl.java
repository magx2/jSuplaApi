package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ServerApi;
import pl.grzeslowski.jsupla.api.ServerInfoApi;
import pl.grzeslowski.jsupla.api.serverinfo.ServerInfo;

final class ServerInfoApiImpl implements ServerInfoApi {
    private final ServerApi serverApi;

    ServerInfoApiImpl(final ApiClient apiClient) {
        this.serverApi = new ServerApi(apiClient);
    }

    @Override
    public ServerInfo findServerInfo() {
        try {
            final io.swagger.client.model.ServerInfo serverInfo = serverApi.getServerInfo();
            return new ServerInfoImpl(
                    serverInfo.getAddress(),
                    serverInfo.getCloudVersion(),
                    serverInfo.getApiVersion(),
                    serverInfo.getSupportedApiVersions());
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findServerInfo", e);
        }
    }
}
