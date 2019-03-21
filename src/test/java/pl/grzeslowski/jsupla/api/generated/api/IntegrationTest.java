package pl.grzeslowski.jsupla.api.generated.api;

import pl.grzeslowski.jsupla.api.generated.ApiClient;
import pl.grzeslowski.jsupla.api.generated.ApiException;
import pl.grzeslowski.jsupla.api.generated.Configuration;
import pl.grzeslowski.jsupla.api.generated.model.Device;

import java.util.Arrays;
import java.util.List;

public class IntegrationTest {
    public static void main(String... args) throws ApiException {
        String username = args[0];
        String password = args[1];
        String server = args[2];

        ApiClient apiClient = new ApiClient();
//        apiClient.setUsername(username);
//        apiClient.setPassword(password);
        apiClient.setBasePath("https://" + server + "/api/v2.2.0");
        apiClient.setDebugging(true);
        Configuration.setDefaultApiClient(apiClient);

//        ServerApi serverApi = new ServerApi();
//        ServerInfo serverInfo = serverApi.getServerInfo();
//        System.out.println(serverInfo);

        IoDevicesApi ioDevicesApi = new IoDevicesApi();
        List<Device> ioDevices = ioDevicesApi.getIoDevices(Arrays.asList("channels", "connected"));
        ioDevices.forEach(System.out::println);
    }
}
