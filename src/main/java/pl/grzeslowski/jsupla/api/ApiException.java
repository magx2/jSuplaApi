package pl.grzeslowski.jsupla.api;

import lombok.ToString;

import java.util.stream.Collectors;

@ToString
public class ApiException extends RuntimeException {
    private final String path;
    private final io.swagger.client.ApiException apiException;

    public ApiException(final String path,
                        final io.swagger.client.ApiException apiException) {
        super(buildMessage(path, apiException), apiException);
        this.path = path;
        this.apiException = apiException;
    }

    private static String buildMessage(final String path, final io.swagger.client.ApiException apiException) {
        final StringBuilder sb = new StringBuilder("Got error while executing `").append(path).append("` API call!");
        if (apiException.getCode() > 0) {
            sb.append(" Error code: ").append(apiException.getCode());
        }
        if (apiException.getResponseHeaders() != null) {
            sb.append(". Headers: ");
            if (!apiException.getResponseHeaders().isEmpty()) {
                final String headers = apiException.getResponseHeaders()
                                               .entrySet()
                                               .stream()
                                               .map(entry -> entry.getKey() + "=" + entry.getValue())
                                               .collect(Collectors.joining(", ", "[", "]"));
                sb.append(headers);
            } else {
                sb.append("<empty>");
            }
        }
        if (apiException.getResponseBody() != null) {
            sb.append(". Response body: ");
            if (!apiException.getResponseBody().isEmpty()) {
                sb.append(apiException.getResponseBody());
            } else {
                sb.append("<empty>");
            }
        }
        sb.append(".");
        return sb.toString();
    }

    public String getPath() {
        return path;
    }
}
