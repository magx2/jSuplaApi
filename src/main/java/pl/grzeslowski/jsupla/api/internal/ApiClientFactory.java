package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.auth.OAuth;

import java.util.Base64;

import static com.squareup.okhttp.logging.HttpLoggingInterceptor.Level.BODY;

final class ApiClientFactory {
    public static final ApiClientFactory INSTANCE = new ApiClientFactory();
    private static final String API_VERSION = "2.3.0";

    public static String getApiVersion() {
        return API_VERSION;
    }

    private ApiClientFactory() {
    }

    /**
     * Creates new {@link ApiClient} with given OAuth token and server URL.
     *
     * @param oAuthToken to authorize
     * @param url        server base URL
     * @return new {@link ApiClient} with configured authorization and base path
     */
    public ApiClient newApiClient(String oAuthToken, String url) {
        ApiClient client = new ApiClient();
        client.setUserAgent("magx2/jSuplaApi");
        OAuth password = (OAuth) client.getAuthentication("BearerAuth");
        password.setAccessToken(oAuthToken);
        client.setBasePath(url + "/api/v" + API_VERSION);
        if (ApiImpl.getLog().isTraceEnabled()) {
            client.getHttpClient().interceptors().add(
                    new OneLineHttpLoggingInterceptor(ApiImpl.getLog()::trace, BODY));
        }
        return client;
    }

    /**
     * Creates new {@link ApiClient} with given OAuth token.
     *
     * @param oAuthToken to authorize
     * @return new {@link ApiClient} with configured authorization and base path
     */
    public ApiClient newApiClient(String oAuthToken) {
        String[] split = oAuthToken.split("\\.");
        if (split.length < 2) {
            throw new IllegalArgumentException("OAuth token does not contain '.' (dot)! Token: " + oAuthToken);
        } else if (split.length > 2) {
            throw new IllegalArgumentException("OAuth token has too many '.' (dot) " + split.length + "! Token: " + oAuthToken);
        }
        String urlBase64 = split[1];
        String url = new String(Base64.getDecoder().decode(urlBase64));
        return newApiClient(oAuthToken, url);
    }
}
