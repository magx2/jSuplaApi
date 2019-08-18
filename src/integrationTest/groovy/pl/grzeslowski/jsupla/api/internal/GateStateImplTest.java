package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.grzeslowski.jsupla.api.channel.state.GateState;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GateStateImplTest {
    @Mock
    Channel channel;
    @Mock
    ChannelState state;

    @Test
    @DisplayName("should build channel without extra sensor (Open)")
    void normalOpen() {
        // given
        given(channel.getState()).willReturn(state);
        given(channel.getParam3()).willReturn(null);
        given(state.isHi()).willReturn(false);

        // when
        final GateStateImpl gateState = new GateStateImpl(channel);

        // then
        assertThat(gateState.getPosition()).isEqualTo(GateState.Position.OPENED);
    }

    @Test
    @DisplayName("should build channel without extra sensor (Close)")
    void normalClose() {
        // given
        given(channel.getState()).willReturn(state);
        given(channel.getParam3()).willReturn(null);
        given(state.isHi()).willReturn(true);

        // when
        final GateStateImpl gateState = new GateStateImpl(channel);

        // then
        assertThat(gateState.getPosition()).isEqualTo(GateState.Position.CLOSED);
    }

    @Test
    @DisplayName("should build channel with extra sensor (Partially Open)")
    void normalPartiallyOpenSensor() {
        // given
        given(channel.getState()).willReturn(state);
        given(channel.getParam3()).willReturn(1);
        given(state.isHi()).willReturn(false);
        given(state.isPartialHi()).willReturn(true);

        // when
        final GateStateImpl gateState = new GateStateImpl(channel);

        // then
        assertThat(gateState.getPosition()).isEqualTo(GateState.Position.PARTIALLY_OPENED);
    }

    @Test
    @DisplayName("should build channel with extra sensor (Close)")
    void normalCloseSensor() {
        // given
        given(channel.getState()).willReturn(state);
        given(channel.getParam3()).willReturn(1);
        given(state.isHi()).willReturn(true);
        given(state.isPartialHi()).willReturn(true);

        // when
        final GateStateImpl gateState = new GateStateImpl(channel);

        // then
        assertThat(gateState.getPosition()).isEqualTo(GateState.Position.CLOSED);
    }

    @Test
    @DisplayName("should build channel with no partial hi")
    void missingPartialHi() {
        // given
        given(channel.getState()).willReturn(state);
        given(channel.getParam3()).willReturn(1);
        given(state.isHi()).willReturn(false);
        given(state.isPartialHi()).willReturn(null);

        // when
        final GateStateImpl gateState = new GateStateImpl(channel);

        // then
        assertThat(gateState.getPosition()).isEqualTo(GateState.Position.OPENED);
    }
}
