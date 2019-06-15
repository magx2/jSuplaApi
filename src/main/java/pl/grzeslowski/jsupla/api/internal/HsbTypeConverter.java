package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.Color;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

final class HsbTypeConverter {
    static final HsbTypeConverter INSTANCE = new HsbTypeConverter();
    private static final String HEX_PREFIX = "0x";

    private HsbTypeConverter() {
    }

    @SuppressWarnings("WeakerAccess")
    public String toCloudFormat(int red, int green, int blue) {
        final String redHex = toHex(red);
        final String greenHex = toHex(green);
        final String blueHex = toHex(blue);

        return format("%s%s%s%s", HEX_PREFIX, redHex, greenHex, blueHex);
    }

    public String toCloudFormat(Color.Rgb rgb) {
        return toCloudFormat(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    private String toHex(int x) {
        final double scale = x / 100.0;
        final int value = (int) (scale * 255);
        final boolean addZeroPrefix = value < 16;
        final String hex = Integer.toHexString(value).toUpperCase();
        return addZeroPrefix ? "0" + hex : hex;
    }

    public Color.Hsv toHsv(String hex, Integer brightness) {
        if (!hex.startsWith(HEX_PREFIX)) {
            throw new IllegalArgumentException("Hex should start with `" + HEX_PREFIX + "`. Was " + hex);
        }
        if (brightness == null) {
            brightness = 100;
        }
        if (brightness > 100 || brightness < 0) {
            throw new IllegalArgumentException("Brightness should be [0,100]! Was " + brightness);
        }
        final String rgb = hex.substring(2);
        final String red = rgb.substring(0, 2);
        final String green = rgb.substring(2, 4);
        final String blue = rgb.substring(4, 6);

        final Color.Rgb rgbColor = new Color.Rgb(parseInt(red, 16), parseInt(green, 16), parseInt(blue, 16));

        final Color.Hsv hsbType = Color.Hsv.fromRgb(rgbColor);
        return new Color.Hsv(
                hsbType.getHue(),
                hsbType.getSaturation(),
                brightness / 100.0);
    }


}
