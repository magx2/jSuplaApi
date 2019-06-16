package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.DepthChannel;
import pl.grzeslowski.jsupla.api.channel.DimmerAndRgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.DimmerChannel;
import pl.grzeslowski.jsupla.api.channel.DistanceChannel;
import pl.grzeslowski.jsupla.api.channel.GateChannel;
import pl.grzeslowski.jsupla.api.channel.HumidityChannel;
import pl.grzeslowski.jsupla.api.channel.NoneChannel;
import pl.grzeslowski.jsupla.api.channel.OnOffChannel;
import pl.grzeslowski.jsupla.api.channel.RgbLightningChannel;
import pl.grzeslowski.jsupla.api.channel.RollerShutterChannel;
import pl.grzeslowski.jsupla.api.channel.TemperatureAndHumidityChannel;
import pl.grzeslowski.jsupla.api.channel.TemperatureChannel;
import pl.grzeslowski.jsupla.api.channel.state.BrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorAndBrightnessState;
import pl.grzeslowski.jsupla.api.channel.state.ColorState;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;
import pl.grzeslowski.jsupla.api.channel.state.DistanceState;
import pl.grzeslowski.jsupla.api.channel.state.HumidityState;
import pl.grzeslowski.jsupla.api.channel.state.OnOffState;
import pl.grzeslowski.jsupla.api.channel.state.PartialOpenState;
import pl.grzeslowski.jsupla.api.channel.state.RollerShutterState;
import pl.grzeslowski.jsupla.api.channel.state.State;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureAndHumidityState;
import pl.grzeslowski.jsupla.api.channel.state.TemperatureState;

import static java.util.Objects.requireNonNull;

@ToString
@EqualsAndHashCode
final class ChannelImpl implements DepthChannel, DimmerAndRgbLightningChannel, DimmerChannel, DistanceChannel,
                                           GateChannel, HumidityChannel, NoneChannel, OnOffChannel, RgbLightningChannel,
                                           RollerShutterChannel, TemperatureAndHumidityChannel, TemperatureChannel {
    private final StateImpl state;
    private Integer id;
    private Integer channelNumber;
    private String caption;
    private Boolean hidden;
    private Boolean connected;

    ChannelImpl(io.swagger.client.model.Channel channel) {
        requireNonNull(channel);
        id = channel.getId();
        channelNumber = channel.getChannelNumber();
        caption = channel.getCaption();
        hidden = channel.isHidden();
        connected = channel.isConnected();
        this.state = new StateImpl(
                channel.getParam1(),
                channel.getParam2(),
                channel.getParam3(),
                channel.getFunction().getName(),
                channel.getState()
        );
    }

    @Override
    public final int compareTo(final Channel o) {
        return Integer.compare(getId(), o.getId());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getChannelNumber() {
        return channelNumber;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public DepthState getDepthStateState() {
        return state;
    }

    @Override
    public ColorAndBrightnessState getColorAndBrightnessState() {
        return state;
    }

    @Override
    public BrightnessState getBrightnessState() {
        return state;
    }

    @Override
    public DistanceState getDistanceState() {
        return state;
    }

    @Override
    public PartialOpenState getPartialOpenState() {
        return state;
    }

    @Override
    public TemperatureAndHumidityState getTemperatureAndHumidityState() {
        return state;
    }

    @Override
    public HumidityState getHumidityState() {
        return state;
    }

    @Override
    public State getNoneState() {
        return state;
    }

    @Override
    public OnOffState getOnOffState() {
        return state;
    }

    @Override
    public ColorState getColorState() {
        return state;
    }

    @Override
    public RollerShutterState getRollerShutterState() {
        return state;
    }

    @Override
    public TemperatureState getTemperatureState() {
        return state;
    }
}
