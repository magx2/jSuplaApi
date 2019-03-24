package pl.grzeslowski.jsupla.api;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

public final class OneLineHttpLoggingInterceptor implements Interceptor {
    private final HttpLoggingInterceptor.Logger logger;
    private final HttpLoggingInterceptor.Level level;

    public OneLineHttpLoggingInterceptor(HttpLoggingInterceptor.Logger logger, HttpLoggingInterceptor.Level level) {
        this.logger = logger;
        this.level = level;
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
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
            stringBuilder.append(message).append("\n");
        }

        public String wholeMessage() {
            return stringBuilder.toString();
        }
    }
}
