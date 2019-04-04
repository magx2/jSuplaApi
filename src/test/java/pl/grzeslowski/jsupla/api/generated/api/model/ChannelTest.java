package pl.grzeslowski.jsupla.api.generated.api.model;

import org.junit.Test;
import pl.grzeslowski.jsupla.api.generated.model.Channel;
import pl.grzeslowski.jsupla.api.generated.model.ChannelState;

import static org.assertj.core.api.Assertions.assertThat;

public class ChannelTest {
    @Test
    public void shouldHaveStateOfTypeChannelState() {

        // given
        ChannelState cs = new ChannelState();

        // when
        final Channel channel = new Channel().state(cs);

        // then
        // if it's not compiling change Channel.state to ChannelState class
        ChannelState channelState = channel.getState();
        assertThat(channelState).isEqualTo(cs);
    }
}
