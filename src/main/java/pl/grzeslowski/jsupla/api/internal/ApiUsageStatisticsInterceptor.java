package pl.grzeslowski.jsupla.api.internal;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import pl.grzeslowski.jsupla.api.Api;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Slf4j
@RequiredArgsConstructor
final class ApiUsageStatisticsInterceptor implements Interceptor {
    private static final String LIMIT_HEADER = "X-RateLimit-Limit";
    private static final String REMAINING_LIMIT_HEADER = "X-RateLimit-Remaining";
    private static final String RESET_DATE_HEADER = "X-RateLimit-Reset";

    @NonNull private final ApiUsageStatisticsSetter apiUsageStatisticsSetter;

    @Override
    public Response intercept(final Chain chain) throws IOException {
        val request = chain.request();
        val response = chain.proceed(request);
        val headers = response.headers();
        try {
            buildApiUsageStatistics(headers, request.urlString()).ifPresent(apiUsageStatisticsSetter::setApiUsageStatistics);
        } catch (Exception e) {
            log.warn("Cannot get ApiUsageStatistics from response `{}`, headers `{}`", response, response.headers(), e);
        }
        return response;
    }

    private Optional<Api.ApiUsageStatistics> buildApiUsageStatistics(final Headers headers, final String url) {
        final Optional<Integer> limit = parseIntFromHeader(headers, url, LIMIT_HEADER);
        final Optional<Integer> remainingLimit = parseIntFromHeader(headers, url, REMAINING_LIMIT_HEADER);
        final Optional<ZonedDateTime> resetDate = parseResetDate(headers, url);

        if (limit.isPresent() && remainingLimit.isPresent() && resetDate.isPresent()) {
            return of(new ApiImpl.ApiUsageStatisticsImpl(
                    ZonedDateTime.now(ZoneId.of("UTC")),
                    limit.get(),
                    remainingLimit.get(),
                    resetDate.get()));
        } else {
            return empty();
        }
    }

    private Optional<ZonedDateTime> parseResetDate(final Headers headers, final String url) {
        final List<String> resetDates = headers.values(RESET_DATE_HEADER);
        if (resetDates == null || resetDates.isEmpty()) {
            log.trace("There are no headers called `{}` in URL `{}`", REMAINING_LIMIT_HEADER, url);
            return Optional.empty();
        }
        try {
            final long timestamp = Long.parseLong(resetDates.get(0));
            final LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
            return of(ZonedDateTime.of(localDateTime, ZoneId.of("UTC")));
        } catch (NumberFormatException e) {
            log.warn("Cannot parse `{}` in URL `{}`", resetDates.get(0), url, e);
            return Optional.empty();
        } catch (DateTimeException e) {
            log.warn("Cannot parse date from timestamp`{}` in URL `{}`", resetDates.get(0), url, e);
            return Optional.empty();
        }
    }

    private Optional<Integer> parseIntFromHeader(final Headers headers, final String url, final String headerName) {
        final List<String> values = headers.values(headerName);
        if (values == null || values.isEmpty()) {
            log.trace("There are no headers called `{}` in URL `{}`", headerName, url);
            return Optional.empty();
        }
        try {
            return of(Integer.parseInt(values.get(0)));
        } catch (NumberFormatException e) {
            log.warn("Cannot parse `{}` in URL `{}`", values.get(0), url, e);
            return Optional.empty();
        }
    }
}
