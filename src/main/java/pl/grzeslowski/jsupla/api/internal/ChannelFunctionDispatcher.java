package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.ChannelFunctionEnumNames;

final class ChannelFunctionDispatcher {
    static final ChannelFunctionDispatcher DISPATCHER = new ChannelFunctionDispatcher();

    /**
     * Do not create instance of this class. Use DISPATCHER
     */
    private ChannelFunctionDispatcher() {

    }

    <T> T dispatch(final ChannelFunctionEnumNames name, FunctionSwitch<T> functionSwitch) {
        switch (name) {
            case NONE:
                return functionSwitch.onNone(name);
            case CONTROLLINGTHEGATEWAYLOCK:
                return functionSwitch.onControllingTheGatewayLock(name);
            case CONTROLLINGTHEGATE:
                return functionSwitch.onControllingTheGate(name);
            case CONTROLLINGTHEGARAGEDOOR:
                return functionSwitch.onControllingTheGarageDoor(name);
            case THERMOMETER:
                return functionSwitch.onThermometer(name);
            case HUMIDITY:
                return functionSwitch.onHumidity(name);
            case HUMIDITYANDTEMPERATURE:
                return functionSwitch.onHumidityAndTemperature(name);
            case OPENINGSENSOR_GATEWAY:
                return functionSwitch.onOpeningSensorGateway(name);
            case OPENINGSENSOR_GATE:
                return functionSwitch.onOpeningSensorGate(name);
            case OPENINGSENSOR_GARAGEDOOR:
                return functionSwitch.onOpeningSensorGarageDoor(name);
            case NOLIQUIDSENSOR:
                return functionSwitch.onNoLiquidSensor(name);
            case CONTROLLINGTHEDOORLOCK:
                return functionSwitch.onControllingTheDoorLock(name);
            case OPENINGSENSOR_DOOR:
                return functionSwitch.onOpeningSensorDoor(name);
            case CONTROLLINGTHEROLLERSHUTTER:
                return functionSwitch.onControllingTheRollerShutter(name);
            case OPENINGSENSOR_ROLLERSHUTTER:
                return functionSwitch.onOpeningSensorRollerShutter(name);
            case POWERSWITCH:
                return functionSwitch.onPowerSwitch(name);
            case LIGHTSWITCH:
                return functionSwitch.onLightSwitch(name);
            case DIMMER:
                return functionSwitch.onDimmer(name);
            case RGBLIGHTING:
                return functionSwitch.onRgbLighting(name);
            case DIMMERANDRGBLIGHTING:
                return functionSwitch.onDimmerAndRgbLightning(name);
            case DEPTHSENSOR:
                return functionSwitch.onDepthSensor(name);
            case DISTANCESENSOR:
                return functionSwitch.onDistanceSensor(name);
            case OPENINGSENSOR_WINDOW:
                return functionSwitch.onOpeningSensorWindow(name);
            case MAILSENSOR:
                return functionSwitch.onMailSensor(name);
            case WINDSENSOR:
                return functionSwitch.onWindSensor(name);
            case PRESSURESENSOR:
                return functionSwitch.onPressureSensor(name);
            case RAINSENSOR:
                return functionSwitch.onRainSensor(name);
            case WEIGHTSENSOR:
                return functionSwitch.onWeightSensor(name);
            case WEATHER_STATION:
                return functionSwitch.onWeatherStation(name);
            case STAIRCASETIMER:
                return functionSwitch.onStaircaseTimer(name);
            default:
                return functionSwitch.onDefault(name);
        }
    }

    public interface FunctionSwitch<T> {
        T onNone(ChannelFunctionEnumNames name);

        T onControllingTheGatewayLock(ChannelFunctionEnumNames name);

        T onControllingTheGate(ChannelFunctionEnumNames name);

        T onControllingTheGarageDoor(ChannelFunctionEnumNames name);

        T onThermometer(ChannelFunctionEnumNames name);

        T onHumidity(ChannelFunctionEnumNames name);

        T onHumidityAndTemperature(ChannelFunctionEnumNames name);

        T onOpeningSensorGateway(ChannelFunctionEnumNames name);

        T onOpeningSensorGate(ChannelFunctionEnumNames name);

        T onOpeningSensorGarageDoor(ChannelFunctionEnumNames name);

        T onNoLiquidSensor(ChannelFunctionEnumNames name);

        T onControllingTheDoorLock(ChannelFunctionEnumNames name);

        T onOpeningSensorDoor(ChannelFunctionEnumNames name);

        T onControllingTheRollerShutter(ChannelFunctionEnumNames name);

        T onOpeningSensorRollerShutter(ChannelFunctionEnumNames name);

        T onPowerSwitch(ChannelFunctionEnumNames name);

        T onLightSwitch(ChannelFunctionEnumNames name);

        T onDimmer(ChannelFunctionEnumNames name);

        T onRgbLighting(ChannelFunctionEnumNames name);

        T onDimmerAndRgbLightning(ChannelFunctionEnumNames name);

        T onDepthSensor(ChannelFunctionEnumNames name);

        T onDistanceSensor(ChannelFunctionEnumNames name);

        T onOpeningSensorWindow(ChannelFunctionEnumNames name);

        T onMailSensor(ChannelFunctionEnumNames name);

        T onWindSensor(ChannelFunctionEnumNames name);

        T onPressureSensor(ChannelFunctionEnumNames name);

        T onRainSensor(ChannelFunctionEnumNames name);

        T onWeightSensor(ChannelFunctionEnumNames name);

        T onWeatherStation(ChannelFunctionEnumNames name);

        T onStaircaseTimer(ChannelFunctionEnumNames name);

        T onDefault(ChannelFunctionEnumNames name);
    }
}
