package pl.grzeslowski.jsupla.api.internal;

import com.google.common.collect.ImmutableMap;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.grzeslowski.jsupla.api.Api;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static com.squareup.okhttp.Protocol.HTTP_1_1;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@ExtendWith(MockitoExtension.class)
class ApiUsageStatisticsInterceptorTest {
    @InjectMocks
    ApiUsageStatisticsInterceptor interceptor;
    @Mock
    ApiUsageStatisticsSetter apiUsageStatisticsSetter;
    @Captor
    ArgumentCaptor<Api.ApiUsageStatistics> apiUsageStatisticsCaptor;
    @Mock
    Interceptor.Chain chain;
    Request request;
    Response response;
    Headers headers;

    void setUp(Map<String, List<String>> headers) throws IOException {
        request = new Request.Builder()
                          .url("https://github.com/magx2/jSuplaApi")
                          .build();
        final Response.Builder responseBuilder = new Response.Builder();
        headers.forEach((name, values) ->
                                values.forEach(value -> responseBuilder.header(name, value)));
        response = responseBuilder
                           .request(request)
                           .protocol(HTTP_1_1)
                           .code(200)
                           .build();

        given(chain.request()).willReturn(request);
        given(chain.proceed(request)).willReturn(response);
    }

    @Test
    @DisplayName("should set ApiUsageStatistics")
    void basic() throws IOException {
        // given
        final ZonedDateTime before = ZonedDateTime.now();
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Remaining", singletonList("102"),
                "X-RateLimit-Reset", singletonList("1590700117")));

        // when
        interceptor.intercept(chain);
        final ZonedDateTime after = ZonedDateTime.now();

        // then
        verify(apiUsageStatisticsSetter).setApiUsageStatistics(apiUsageStatisticsCaptor.capture());
        final Api.ApiUsageStatistics result = apiUsageStatisticsCaptor.getValue();
        assertThat(result.getLimit()).isEqualTo(101);
        assertThat(result.getRemainingLimit()).isEqualTo(102);
        assertThat(result.getResetDate()).isEqualTo(ZonedDateTime.parse("2020-05-28T21:08:37Z[UTC]"));
        assertThat(result.getLastUpdateDate()).isAfterOrEqualTo(before);
        assertThat(result.getLastUpdateDate()).isBeforeOrEqualTo(after);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of non parsable `limit`")
    void noParseLimit() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("abc"),
                "X-RateLimit-Remaining", singletonList("102"),
                "X-RateLimit-Reset", singletonList("1590700117")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of missing `limit`")
    void noLimit() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Remaining", singletonList("102"),
                "X-RateLimit-Reset", singletonList("1590700117")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of non parsable `remainingLimit`")
    void noParseRemainingLimit() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Remaining", singletonList("abc"),
                "X-RateLimit-Reset", singletonList("1590700117")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of missing `remainingLimit`")
    void noRemainingLimit() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Reset", singletonList("1590700117")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of non parsable `limitReset`")
    void noParseLimitReset() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Remaining", singletonList("102"),
                "X-RateLimit-Reset", singletonList("abc")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should not parse ApiUsageStatistics because of missing `limitReset`")
    void noLimitReset() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Remaining", singletonList("102")));

        // when
        interceptor.intercept(chain);

        // then
        verifyZeroInteractions(apiUsageStatisticsSetter);
    }

    @Test
    @DisplayName("should return response even when there was exception")
    void should() throws IOException {
        // given
        setUp(ImmutableMap.of(
                "X-RateLimit-Limit", singletonList("101"),
                "X-RateLimit-Remaining", singletonList("102"),
                "X-RateLimit-Reset", singletonList("1590700117")));
        doThrow(new RuntimeException())
                .when(apiUsageStatisticsSetter)
                .setApiUsageStatistics(any());

        // when
        final Response response = interceptor.intercept(chain);

        // then
        assertThat(response).isEqualTo(this.response);
    }
}
