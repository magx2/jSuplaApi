package pl.grzeslowski.jsupla.api.channel.state;

import pl.grzeslowski.jsupla.api.Color;

public interface ColorState extends State {
    Color.Rgb getRgb();

    Color.Hsv getHsv();
}
