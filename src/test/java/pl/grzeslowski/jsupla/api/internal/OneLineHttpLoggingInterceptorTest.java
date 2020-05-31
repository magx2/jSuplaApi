package pl.grzeslowski.jsupla.api.internal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.squareup.okhttp.MediaType.parse;
import static com.squareup.okhttp.Protocol.HTTP_1_1;
import static com.squareup.okhttp.ResponseBody.create;
import static com.squareup.okhttp.logging.HttpLoggingInterceptor.Level.BODY;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OneLineHttpLoggingInterceptorTest {
    @Mock
    HttpLoggingInterceptor.Logger logger;
    @Captor
    ArgumentCaptor<String> captor;
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
                           .body(create(parse("application/json"), "{\"foo\":\"boo\"}"))
                           .build();

        given(chain.request()).willReturn(request);
        given(chain.proceed(request)).willReturn(response);
    }

    @ParameterizedTest(name = "should mask token for type `{0}`")
    @MethodSource
    void withKnownType(String type) throws IOException {
        // given
        val interceptor = new OneLineHttpLoggingInterceptor(logger, BODY);
        setUp(ImmutableMap.of("Authorization", singletonList(type + " ToKeN")));

        // when
        interceptor.intercept(chain);

        // then
        verify(logger).log(captor.capture());
        val authorizationLine = Stream.of(captor.getValue().split("\n"))
                                        .filter(l -> l.startsWith("\tAuthorization"))
                                        .findAny();
        assertThat(authorizationLine).contains("\tAuthorization: " + type + " <SECRET>");
    }

    @Test
    @DisplayName("should hide whole value of header if there is no type")
    void onlyToken() throws IOException {
        // given
        val interceptor = new OneLineHttpLoggingInterceptor(logger, BODY);
        setUp(ImmutableMap.of("Authorization", singletonList("ToKeN")));

        // when
        interceptor.intercept(chain);

        // then
        verify(logger).log(captor.capture());
        val authorizationLine = Stream.of(captor.getValue().split("\n"))
                                        .filter(l -> l.startsWith("\tAuthorization"))
                                        .findAny();
        assertThat(authorizationLine).contains("\tAuthorization: <SECRET>");
    }

    @Test
    @DisplayName("should hide value if authorization header has multiple values")
    void multipleValues() throws IOException {
        // given
        val interceptor = new OneLineHttpLoggingInterceptor(logger, BODY);
        setUp(ImmutableMap.of("Authorization",
                ImmutableList.of("Basic token1", "Bearer token2")));

        // when
        interceptor.intercept(chain);

        // then
        verify(logger).log(captor.capture());
        val authorizationLine = Stream.of(captor.getValue().split("\n"))
                                        .filter(l -> l.startsWith("\tAuthorization"))
                                        .findAny();
        assertThat(authorizationLine).contains("\tAuthorization: Bearer <SECRET>");
    }

    @ParameterizedTest(name = "should leave type `{0}` if there is no token")
    @MethodSource("withKnownType")
    void withKnownTypeNoToken(String type) throws IOException {
        // given
        val interceptor = new OneLineHttpLoggingInterceptor(logger, BODY);
        setUp(ImmutableMap.of("Authorization", singletonList(type)));

        // when
        interceptor.intercept(chain);

        // then
        verify(logger).log(captor.capture());
        val authorizationLine = Stream.of(captor.getValue().split("\n"))
                                        .filter(l -> l.startsWith("\tAuthorization"))
                                        .findAny();
        assertThat(authorizationLine).contains("\tAuthorization: <SECRET>");
    }

    @SuppressWarnings("unused")
    static Stream<String> withKnownType() {
        return Stream.of("Basic", "Bearer", "HOBA", "Digest", "Mutual", "AWS4-HMAC-SHA256",
                "BaSiC", "BeArEr", "HoBa", "DiGeSt", "MuTuAl", "AwS4-HmAc-ShA256",
                "foo", "BoO");
    }
}
