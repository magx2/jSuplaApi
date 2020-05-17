package pl.grzeslowski.jsupla.api.channel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static pl.grzeslowski.jsupla.api.channel.ChannelDispatcher.DISPATCHER;

@ExtendWith(MockitoExtension.class)
class ChannelDispatcherTest {
    @Mock
    ChannelDispatcher.FunctionSwitch<Object> functionSwitch;

    @Test
    @DisplayName("should invoke `onNone` on `NoneChannel`")
    void onNone() {
        // given
        final NoneChannel channel = mock(NoneChannel.class);
        given(functionSwitch.onNone(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onNone(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onControllingChannel` on `ControllingChannel`")
    void onControllingChannel() {
        // given
        final ControllingChannel channel = mock(ControllingChannel.class);
        given(functionSwitch.onControllingChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onControllingChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onTemperatureAndHumidityChannel` on `TemperatureAndHumidityChannel`")
    void onTemperatureAndHumidityChannel() {
        // given
        final TemperatureAndHumidityChannel channel = mock(TemperatureAndHumidityChannel.class);
        given(functionSwitch.onTemperatureAndHumidityChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onTemperatureAndHumidityChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onGateChannel` on `GateChannel`")
    void onGateChannel() {
        // given
        final GateChannel channel = mock(GateChannel.class);
        given(functionSwitch.onGateChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onGateChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onTemperatureChannel` on `TemperatureChannel`")
    void onTemperatureChannel() {
        // given
        final TemperatureChannel channel = mock(TemperatureChannel.class);
        given(functionSwitch.onTemperatureChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onTemperatureChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onHumidityChannel` on `HumidityChannel`")
    void onHumidityChannel() {
        // given
        final HumidityChannel channel = mock(HumidityChannel.class);
        given(functionSwitch.onHumidityChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onHumidityChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onOnOffChannel` on `OnOffChannel`")
    void onOnOffChannel() {
        // given
        final OnOffChannel channel = mock(OnOffChannel.class);
        given(functionSwitch.onOnOffChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onOnOffChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onRollerShutterChannel` on `RollerShutterChannel`")
    void onRollerShutterChannel() {
        // given
        final RollerShutterChannel channel = mock(RollerShutterChannel.class);
        given(functionSwitch.onRollerShutterChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onRollerShutterChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onDimmerChannel` on `DimmerChannel`")
    void onDimmerChannel() {
        // given
        final DimmerChannel channel = mock(DimmerChannel.class);
        given(functionSwitch.onDimmerChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onDimmerChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onRgbLightningChannel` on `RgbLightningChannel`")
    void onRgbLightningChannel() {
        // given
        final RgbLightningChannel channel = mock(RgbLightningChannel.class);
        given(functionSwitch.onRgbLightningChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onRgbLightningChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onDimmerAndRgbLightningChannel` on `DimmerAndRgbLightningChannel`")
    void onDimmerAndRgbLightningChannel() {
        // given
        final DimmerAndRgbLightningChannel channel = mock(DimmerAndRgbLightningChannel.class);
        given(functionSwitch.onDimmerAndRgbLightningChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onDimmerAndRgbLightningChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onDepthChannel` on `DepthChannel`")
    void onDepthChannel() {
        // given
        final DepthChannel channel = mock(DepthChannel.class);
        given(functionSwitch.onDepthChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onDepthChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onDistanceChannel` on `DistanceChannel`")
    void onDistanceChannel() {
        // given
        final DistanceChannel channel = mock(DistanceChannel.class);
        given(functionSwitch.onDistanceChannel(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onDistanceChannel(channel);
        verifyNoMoreInteractions(functionSwitch);
    }

    @Test
    @DisplayName("should invoke `onDefault` on `Channel`")
    void onDefault() {
        // given
        final Channel channel = mock(Channel.class);
        given(functionSwitch.onDefault(channel)).willReturn("return");

        // when
        final Object dispatch = DISPATCHER.dispatch(channel, functionSwitch);

        // then
        assertThat(dispatch).isEqualTo("return");
        verify(functionSwitch).onDefault(channel);
        verifyNoMoreInteractions(functionSwitch);
    }
}
