package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.grzeslowski.jsupla.api.channel.state.Percentage;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.OFF;
import static pl.grzeslowski.jsupla.api.channel.state.OnOffState.OnOff.ON;

class RollerShutterStateImplTest {
    @Test
    @DisplayName("should create open roller shutter with opening sensor")
    void openWithOpeningSensor() {
        // given
        ChannelState state = new ChannelState()
                                     .shut(87)
                                     .isCalibrating(false)
                                     .hi(true);
        Channel channel = new Channel()
                                  .state(state)
                                  .param2(1);

        // when
        RollerShutterStateImpl rollerShutterState = new RollerShutterStateImpl(channel);

        // then
        assertThat(rollerShutterState.getShut()).isEqualTo(new Percentage(87));
        assertThat(rollerShutterState.getOpen()).isEqualTo(new Percentage(13));
        assertThat(rollerShutterState.getOnOffState()).isEqualTo(ON);
    }

    @Test
    @DisplayName("should create close roller shutter with opening sensor")
    void closeWithOpeningSensor() {
        // given
        ChannelState state = new ChannelState()
                                     .shut(100)
                                     .isCalibrating(false)
                                     .hi(false);
        Channel channel = new Channel()
                                  .state(state)
                                  .param2(1);

        // when
        RollerShutterStateImpl rollerShutterState = new RollerShutterStateImpl(channel);

        // then
        assertThat(rollerShutterState.getShut()).isEqualTo(new Percentage(100));
        assertThat(rollerShutterState.getOpen()).isEqualTo(new Percentage(0));
        assertThat(rollerShutterState.getOnOffState()).isEqualTo(OFF);
    }

    @Test
    @DisplayName("should create open roller shutter without opening sensor")
    void openWithoutOpeningSensor() {
        // given
        ChannelState state = new ChannelState()
                                     .shut(87)
                                     .isCalibrating(false);
        Channel channel = new Channel().state(state);

        // when
        RollerShutterStateImpl rollerShutterState = new RollerShutterStateImpl(channel);

        // then
        assertThat(rollerShutterState.getShut()).isEqualTo(new Percentage(87));
        assertThat(rollerShutterState.getOpen()).isEqualTo(new Percentage(13));
        assertThat(rollerShutterState.getOnOffState()).isEqualTo(ON);
    }

    @Test
    @DisplayName("should create close roller shutter without opening sensor")
    void closeWithoutOpeningSensor() {
        // given
        ChannelState state = new ChannelState()
                                     .shut(100)
                                     .isCalibrating(false);
        Channel channel = new Channel().state(state);

        // when
        RollerShutterStateImpl rollerShutterState = new RollerShutterStateImpl(channel);

        // then
        assertThat(rollerShutterState.getShut()).isEqualTo(new Percentage(100));
        assertThat(rollerShutterState.getOpen()).isEqualTo(new Percentage(0));
        assertThat(rollerShutterState.getOnOffState()).isEqualTo(OFF);
    }
}
