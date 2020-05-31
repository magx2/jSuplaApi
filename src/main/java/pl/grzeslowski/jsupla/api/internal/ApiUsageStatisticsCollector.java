package pl.grzeslowski.jsupla.api.internal;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.Api;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
final class ApiUsageStatisticsCollector {
    static final ApiUsageStatisticsCollector INSTANCE = new ApiUsageStatisticsCollector();
    private final ConcurrentMap<String, Api.ApiUsageStatistics> cache = new ConcurrentHashMap<>();

    TokenBound newTokenBound(@NonNull String token) {
        return new TokenBound(token);
    }

    void putStatistics(@NonNull String token, @NonNull Api.ApiUsageStatistics apiUsageStatistics) {
        cache.put(token, apiUsageStatistics);
    }

    Optional<Api.ApiUsageStatistics> getStatistics(@NonNull String token) {
        return Optional.ofNullable(cache.getOrDefault(token, null));
    }

    @ToString
    @RequiredArgsConstructor
    final class TokenBound implements ApiUsageStatisticsSetter {
        @NonNull private final String token;

        @Override
        public void setApiUsageStatistics(final Api.ApiUsageStatistics apiUsageStatistics) {
            putStatistics(token, apiUsageStatistics);
        }
    }
}
