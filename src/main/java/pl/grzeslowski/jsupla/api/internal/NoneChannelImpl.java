package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.NoneChannel;
import pl.grzeslowski.jsupla.api.channel.state.State;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.of;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
final class NoneChannelImpl extends ChannelImpl implements NoneChannel {
    private static final State STATE = new State() {
        @Override
        public String toString() {
            return "NONE_STATE";
        }
    };
    private final Map<Object, Object> properties = new LinkedHashMap<>();

    NoneChannelImpl(final Channel channel) {
        super(channel);
        properties.put("id", channel.getId());
        properties.put("channelNumber", channel.getChannelNumber());
        properties.put("caption", channel.getCaption());
        properties.put("type", channel.getType().getName());
        properties.put("function", channel.getFunction().getName());
        properties.put("param1", channel.getParam1());
        properties.put("param2", channel.getParam2());
        properties.put("param3", channel.getParam3());
        properties.put("textParam1", channel.getTextParam1());
        properties.put("textParam2", channel.getTextParam2());
        properties.put("textParam3", channel.getTextParam3());
        properties.put("hidden", channel.isHidden());
        properties.put("connected", channel.isConnected());
        if (channel.getState() != null) {
            Map<Object, Object> state = new LinkedHashMap<>();
            state.put("connected", channel.getState().isConnected());
            state.put("brightness", channel.getState().getBrightness());
            state.put("colorBrightness", channel.getState().getColorBrightness());
            state.put("color", channel.getState().getColor());
            state.put("depth", channel.getState().getDepth());
            state.put("distance", channel.getState().getDistance());
            state.put("humidity", channel.getState().getHumidity());
            state.put("on", channel.getState().isOn());
            state.put("hi", channel.getState().isHi());
            state.put("partialHi", channel.getState().isPartialHi());
            state.put("isCalibrating", channel.getState().isIsCalibrating());
            state.put("shut", channel.getState().getShut());
            state.put("temperature", channel.getState().getTemperature());
            properties.put("state", state);
        } else {
            properties.put("state", "is null...");
        }
    }

    @Override
    public Optional<State> findState() {
        return of(STATE);
    }
}
