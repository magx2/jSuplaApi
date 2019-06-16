package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.auth.OAuth;

import java.util.Base64;

final class ApiClientFactory {
    public static final ApiClientFactory INSTANCE = new ApiClientFactory();
    private static final String API_VERSION = "2.3.0";

    private ApiClientFactory() {
    }

    /**
     * Creates new {@link ApiClient} with given OAuth token.
     *
     * @param oAuthToken to authorize
     * @return new {@link ApiClient} with configured authorization and base path
     */
    public ApiClient newApiClient(String oAuthToken) {
        ApiClient client = new ApiClient();
        client.setUserAgent("magx2/jSuplaApi");
        OAuth password = (OAuth) client.getAuthentication("BearerAuth");
        password.setAccessToken(oAuthToken);
        String[] split = oAuthToken.split("\\.");
        if (split.length < 2) {
            throw new IllegalArgumentException("OAuth token does not contain '.' (dot)!");
        } else if (split.length > 2) {
            throw new IllegalArgumentException("OAuth token has too many '.' (dot) " + split.length + "!");
        }
        String urlBase64 = split[1];
        String url = new String(Base64.getDecoder().decode(urlBase64));
        client.setBasePath(url + "/api/v" + API_VERSION);
        return client;
    }
}
