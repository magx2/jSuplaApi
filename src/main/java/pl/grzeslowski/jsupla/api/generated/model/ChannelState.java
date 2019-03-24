package pl.grzeslowski.jsupla.api.generated.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * See for more info
 */
public class ChannelState {
    @SerializedName("hi")
    private Boolean hi;
    @SerializedName("partial_hi")
    private Boolean partialHi;
    @SerializedName("temperature")
    private BigDecimal temperature;
    @SerializedName("humidity")
    private BigDecimal humidity;
    @SerializedName("is_calibrating")
    private Boolean isCalibrating;
    @SerializedName("shut")
    private Integer shut;
    @SerializedName("on")
    private Boolean on;
    @SerializedName("brightness")
    private Integer brightness;
    @SerializedName("color")
    private Integer color;
    @SerializedName("color_brightness")
    private Integer colorBrightness;
    @SerializedName("depth")
    private BigDecimal depth;
    @SerializedName("distance")
    private BigDecimal distance;

    public ChannelState() {
    }

    public Boolean getHi() {
        return hi;
    }

    public ChannelState setHi(final Boolean hi) {
        this.hi = hi;
        return this;
    }

    public Boolean getPartialHi() {
        return partialHi;
    }

    public ChannelState setPartialHi(final Boolean partialHi) {
        this.partialHi = partialHi;
        return this;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public ChannelState setTemperature(final BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public ChannelState setHumidity(final BigDecimal humidity) {
        this.humidity = humidity;
        return this;
    }

    public Boolean getCalibrating() {
        return isCalibrating;
    }

    public ChannelState setCalibrating(final Boolean calibrating) {
        isCalibrating = calibrating;
        return this;
    }

    public Integer getShut() {
        return shut;
    }

    public ChannelState setShut(final Integer shut) {
        this.shut = shut;
        return this;
    }

    public Boolean getOn() {
        return on;
    }

    public ChannelState setOn(final Boolean on) {
        this.on = on;
        return this;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public ChannelState setBrightness(final Integer brightness) {
        this.brightness = brightness;
        return this;
    }

    public Integer getColor() {
        return color;
    }

    public ChannelState setColor(final Integer color) {
        this.color = color;
        return this;
    }

    public Integer getColorBrightness() {
        return colorBrightness;
    }

    public ChannelState setColorBrightness(final Integer colorBrightness) {
        this.colorBrightness = colorBrightness;
        return this;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public ChannelState setDepth(final BigDecimal depth) {
        this.depth = depth;
        return this;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public ChannelState setDistance(final BigDecimal distance) {
        this.distance = distance;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ChannelState that = (ChannelState) o;
        return Objects.equals(hi, that.hi) &&
                       Objects.equals(partialHi, that.partialHi) &&
                       Objects.equals(temperature, that.temperature) &&
                       Objects.equals(humidity, that.humidity) &&
                       Objects.equals(isCalibrating, that.isCalibrating) &&
                       Objects.equals(shut, that.shut) &&
                       Objects.equals(on, that.on) &&
                       Objects.equals(brightness, that.brightness) &&
                       Objects.equals(color, that.color) &&
                       Objects.equals(colorBrightness, that.colorBrightness) &&
                       Objects.equals(depth, that.depth) &&
                       Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hi, partialHi, temperature, humidity, isCalibrating, shut, on, brightness, color, colorBrightness, depth, distance);
    }

    @Override
    public String toString() {
        return "ChannelState{" +
                       "hi=" + hi +
                       ", partialHi=" + partialHi +
                       ", temperature=" + temperature +
                       ", humidity=" + humidity +
                       ", isCalibrating=" + isCalibrating +
                       ", shut=" + shut +
                       ", on=" + on +
                       ", brightness=" + brightness +
                       ", color=" + color +
                       ", colorBrightness=" + colorBrightness +
                       ", depth=" + depth +
                       ", distance=" + distance +
                       '}';
    }
}
