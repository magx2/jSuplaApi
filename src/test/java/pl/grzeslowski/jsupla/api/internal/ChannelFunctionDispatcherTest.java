package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelFunction;
import io.swagger.client.model.ChannelFunctionEnumNames;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ChannelFunctionDispatcherTest {
    @Mock Channel channel;
    @Mock ChannelFunctionDispatcher.FunctionSwitch<String> functionSwitch;
    @Mock ChannelFunction function;

    @ParameterizedTest(name = "should not invoke `functionSwitch.onDefault` on `{0}`")
    @MethodSource
    void neverDefault(ChannelFunctionEnumNames functionEnum) {
        // given
        given(function.getName()).willReturn(functionEnum);
        given(channel.getFunction()).willReturn(function);

        // when
        ChannelFunctionDispatcher.DISPATCHER.dispatch(channel, functionSwitch);

        // then
        verify(functionSwitch, never()).onDefault(channel);
    }

    @SuppressWarnings("unused")
    static Stream<ChannelFunctionEnumNames> neverDefault() {
        return Arrays.stream(ChannelFunctionEnumNames.values());
    }
}