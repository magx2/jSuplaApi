package pl.grzeslowski.jsupla.api.internal;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import lombok.val;

import java.io.IOException;

final class OneLineHttpLoggingInterceptor implements Interceptor {
    private final HttpLoggingInterceptor.Logger logger;
    private final HttpLoggingInterceptor.Level level;

    OneLineHttpLoggingInterceptor(HttpLoggingInterceptor.Logger logger, HttpLoggingInterceptor.Level level) {
        this.logger = logger;
        this.level = level;
    }

    @Override
    public Response intercept(final Interceptor.Chain chain) throws IOException {
        final StringBuilderLogger stringBuilderLogger = new StringBuilderLogger();
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(stringBuilderLogger);
        interceptor.setLevel(level);
        final Response response = interceptor.intercept(chain);
        this.logger.log(stringBuilderLogger.wholeMessage());
        return response;
    }

    private static final class StringBuilderLogger implements HttpLoggingInterceptor.Logger {
        private final StringBuilder stringBuilder = new StringBuilder("Log for request:\n");

        @Override
        public void log(final String message) {
            final String parsedMessage;
            if (message.startsWith("Authorization")) {
                val noAuth = message.substring(15);
                val space = noAuth.indexOf(" ");
                if (space > -1) {
                    val type = noAuth.substring(0, space);
                    parsedMessage = "Authorization: " + type + " <SECRET>";
                } else {
                    parsedMessage = "Authorization: <SECRET>";
                }
            } else {
                parsedMessage = message;
            }
            stringBuilder.append("\t").append(parsedMessage).append("\n");
        }

        String wholeMessage() {
            return stringBuilder.toString();
        }
    }
}