package pl.grzeslowski.jsupla.api.internal;

import com.squareup.okhttp.Interceptor;
import io.swagger.client.ApiClient;
import io.swagger.client.auth.OAuth;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

import static com.squareup.okhttp.logging.HttpLoggingInterceptor.Level.BODY;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ApiClientFactory {
    public static final ApiClientFactory INSTANCE = new ApiClientFactory();
    private static final String API_VERSION = "2.3.0";

    public static String getApiVersion() {
        return API_VERSION;
    }

    /**
     * Creates new {@link ApiClient} with given OAuth token and server URL.
     *
     * @param oAuthToken to authorize
     * @param url        server base URL
     * @return new {@link ApiClient} with configured authorization and base path
     */
    private ApiClient newApiClient(String oAuthToken, String url) {
        ApiClient client = new ApiClient();
        client.setUserAgent("magx2/jSuplaApi");
        OAuth password = (OAuth) client.getAuthentication("BearerAuth");
        password.setAccessToken(oAuthToken);
        client.setBasePath(url + "/api/v" + API_VERSION);
        final List<Interceptor> interceptors = client.getHttpClient().interceptors();
        interceptors.add(new OneLineHttpLoggingInterceptor(ApiImpl.getLog()::trace, BODY));
        interceptors.add(new ApiUsageStatisticsInterceptor(ApiUsageStatisticsCollector.INSTANCE.newTokenBound(oAuthToken)));
        if (Boolean.getBoolean("jSuplaApi.noVerifyingSsl")) {
            client.setVerifyingSsl(false);
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
