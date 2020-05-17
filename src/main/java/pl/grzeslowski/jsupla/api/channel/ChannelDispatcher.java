package pl.grzeslowski.jsupla.api.channel;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChannelDispatcher {
    public static final ChannelDispatcher DISPATCHER = new ChannelDispatcher();

    public <T> T dispatch(Channel channel, FunctionSwitch<T> functionSwitch) {
        if (channel instanceof NoneChannel) {
            return functionSwitch.onNone((NoneChannel) channel);
        } else if (channel instanceof ControllingChannel) {
            return functionSwitch.onControllingChannel((ControllingChannel) channel);
        } else if (channel instanceof TemperatureAndHumidityChannel) {
            return functionSwitch.onTemperatureAndHumidityChannel((TemperatureAndHumidityChannel) channel);
        } else if (channel instanceof GateChannel) {
            return functionSwitch.onGateChannel((GateChannel) channel);
        } else if (channel instanceof TemperatureChannel) {
            return functionSwitch.onTemperatureChannel((TemperatureChannel) channel);
        } else if (channel instanceof HumidityChannel) {
            return functionSwitch.onHumidityChannel((HumidityChannel) channel);
        } else if (channel instanceof OnOffChannel) {
            return functionSwitch.onOnOffChannel((OnOffChannel) channel);
        } else if (channel instanceof RollerShutterChannel) {
            return functionSwitch.onRollerShutterChannel((RollerShutterChannel) channel);
        } else if (channel instanceof DimmerChannel) {
            return functionSwitch.onDimmerChannel((DimmerChannel) channel);
        } else if (channel instanceof RgbLightningChannel) {
            return functionSwitch.onRgbLightningChannel((RgbLightningChannel) channel);
        } else if (channel instanceof DimmerAndRgbLightningChannel) {
            return functionSwitch.onDimmerAndRgbLightningChannel((DimmerAndRgbLightningChannel) channel);
        } else if (channel instanceof DepthChannel) {
            return functionSwitch.onDepthChannel((DepthChannel) channel);
        } else if (channel instanceof DistanceChannel) {
            return functionSwitch.onDistanceChannel((DistanceChannel) channel);
        } else {
            return functionSwitch.onDefault(channel);
        }
    }

    public interface FunctionSwitch<T> {
        T onNone(NoneChannel channel);

        T onControllingChannel(ControllingChannel channel);

        T onTemperatureAndHumidityChannel(TemperatureAndHumidityChannel channel);

        T onGateChannel(GateChannel channel);

        T onTemperatureChannel(TemperatureChannel channel);

        T onHumidityChannel(HumidityChannel channel);

        T onOnOffChannel(OnOffChannel channel);

        T onRollerShutterChannel(RollerShutterChannel channel);

        T onDimmerChannel(DimmerChannel channel);

        T onRgbLightningChannel(RgbLightningChannel channel);

        T onDimmerAndRgbLightningChannel(DimmerAndRgbLightningChannel channel);

        T onDepthChannel(DepthChannel channel);

        T onDistanceChannel(DistanceChannel channel);

        T onDefault(Channel channel);
    }
}
