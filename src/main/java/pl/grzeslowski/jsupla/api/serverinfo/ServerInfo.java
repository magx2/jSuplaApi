package pl.grzeslowski.jsupla.api.serverinfo;

import java.util.List;

public interface ServerInfo {
    String getAddress();

    String getCloudVersion();

    String getApiVersion();

    List<String> getSupportedVersions();
}
