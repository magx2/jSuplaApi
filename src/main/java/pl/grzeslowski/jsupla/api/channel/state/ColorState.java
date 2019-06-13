package pl.grzeslowski.jsupla.api.channel.state;

import pl.grzeslowski.jsupla.api.HsbTypeConverter;

public interface ColorState extends State {
    HsbTypeConverter.Rgb getRgb();

    HsbTypeConverter.Hsv getHsv();
}
