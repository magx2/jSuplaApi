package pl.grzeslowski.jsupla.api.internal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.grzeslowski.jsupla.api.channel.Channel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ChannelDispatcher implements ChannelFunctionDispatcher.FunctionSwitch<Channel> {
    static final ChannelDispatcher INSTANCE = new ChannelDispatcher();

    @Override
    public Channel onNone(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onControllingTheGatewayLock(final io.swagger.client.model.Channel channel) {
        return new ControllingChannelImpl(channel);
    }

    @Override
    public Channel onControllingTheGate(final io.swagger.client.model.Channel channel) {
        return new GateChannelImpl(channel);
    }

    @Override
    public Channel onControllingTheGarageDoor(final io.swagger.client.model.Channel channel) {
        return new ControllingChannelImpl(channel);
    }

    @Override
    public Channel onThermometer(final io.swagger.client.model.Channel channel) {
        return new ThermometerChannelImpl(channel);
    }

    @Override
    public Channel onHumidity(final io.swagger.client.model.Channel channel) {
        return new HumidityChannelImpl(channel);
    }

    @Override
    public Channel onHumidityAndTemperature(final io.swagger.client.model.Channel channel) {
        return new TemperatureAndHumidityChannelImpl(channel);
    }

    @Override
    public Channel onOpeningSensorGateway(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onOpeningSensorGate(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onOpeningSensorGarageDoor(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onNoLiquidSensor(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onControllingTheDoorLock(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onOpeningSensorDoor(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onControllingTheRollerShutter(final io.swagger.client.model.Channel channel) {
        return new RollerShutterChannelImpl(channel);
    }

    @Override
    public Channel onOpeningSensorRollerShutter(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onPowerSwitch(final io.swagger.client.model.Channel channel) {
        return new OnChannelImpl(channel);
    }

    @Override
    public Channel onLightSwitch(final io.swagger.client.model.Channel channel) {
        return new OnChannelImpl(channel);
    }

    @Override
    public Channel onDimmer(final io.swagger.client.model.Channel channel) {
        return new DimmerChannelImpl(channel);
    }

    @Override
    public Channel onRgbLighting(final io.swagger.client.model.Channel channel) {
        return new RgbLightningChannelImpl(channel);
    }

    @Override
    public Channel onDimmerAndRgbLightning(final io.swagger.client.model.Channel channel) {
        return new DimmerAndRgbLightningChannelImpl(channel);
    }

    @Override
    public Channel onDepthSensor(final io.swagger.client.model.Channel channel) {
        return new DepthChannelImpl(channel);
    }

    @Override
    public Channel onDistanceSensor(final io.swagger.client.model.Channel channel) {
        return new DistanceChannelImpl(channel);
    }

    @Override
    public Channel onOpeningSensorWindow(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onMailSensor(final io.swagger.client.model.Channel channel) {
        return HiChannelImpl.createWithoutParam2(channel);
    }

    @Override
    public Channel onWindSensor(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onPressureSensor(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onRainSensor(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onWeightSensor(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onWeatherStation(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }

    @Override
    public Channel onStaircaseTimer(final io.swagger.client.model.Channel channel) {
        return new OnChannelImpl(channel);
    }

    @Override
    public Channel onElectricMeter(final io.swagger.client.model.Channel channel) {
        return new ElectricityMeterChannelImpl(channel);
    }

    @Override
    public Channel onDefault(final io.swagger.client.model.Channel channel) {
        return new NoneChannelImpl(channel);
    }
}
