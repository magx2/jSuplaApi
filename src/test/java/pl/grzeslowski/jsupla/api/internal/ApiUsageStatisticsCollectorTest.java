package pl.grzeslowski.jsupla.api.internal;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.grzeslowski.jsupla.api.Api;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static pl.grzeslowski.jsupla.api.internal.ApiUsageStatisticsCollector.INSTANCE;

class ApiUsageStatisticsCollectorTest {
    @Test
    @DisplayName("should find statistics for token")
    void basicFind() {
        // given
        val statistics = mock(Api.ApiUsageStatistics.class);
        INSTANCE.putStatistics("t1", statistics);

        // when
        final Optional<Api.ApiUsageStatistics> result = INSTANCE.getStatistics("t1");

        // then
        assertThat(result).contains(statistics);
    }

    @Test
    @DisplayName("should not find statistics for token")
    void noStatistics() {
        // when
        final Optional<Api.ApiUsageStatistics> result = INSTANCE.getStatistics("t2");

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("should find statistics for token that is bound to `TokenBound`")
    void tokenBoundFind() {
        // given
        val statistics = mock(Api.ApiUsageStatistics.class);
        val tokenBound = INSTANCE.newTokenBound("t3");

        // when
        tokenBound.setApiUsageStatistics(statistics);

        // then
        assertThat(INSTANCE.getStatistics("t3")).contains(statistics);
    }
}
