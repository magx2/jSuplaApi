package pl.grzeslowski.jsupla.api.internal;

import lombok.Value;
import pl.grzeslowski.jsupla.api.serverinfo.ServerInfo;

import java.util.List;

@Value
final class ServerInfoImpl implements ServerInfo {
    private final String address;
    private final String cloudVersion;
    private final String apiVersion;
    private final List<String> supportedVersions;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCloudVersion() {
        return cloudVersion;
    }

    @Override
    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public List<String> getSupportedVersions() {
        return supportedVersions;
    }
}
