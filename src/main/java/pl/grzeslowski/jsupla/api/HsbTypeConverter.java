package pl.grzeslowski.jsupla.api;

import java.io.Serializable;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.Math.floor;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.String.format;

public final class HsbTypeConverter {
    public static final HsbTypeConverter INSTANCE = new HsbTypeConverter();
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

    public String toCloudFormat(Rgb rgb) {
        return toCloudFormat(rgb.red, rgb.green, rgb.blue);
    }

    private String toHex(int x) {
        final double scale = x / 100.0;
        final int value = (int) (scale * 255);
        final boolean addZeroPrefix = value < 16;
        final String hex = Integer.toHexString(value).toUpperCase();
        return addZeroPrefix ? "0" + hex : hex;
    }

    public Hsv toHsv(String hex, int brightness) {
        if (!hex.startsWith(HEX_PREFIX)) {
            throw new IllegalArgumentException("Hex should start with `" + HEX_PREFIX + "`. Was " + hex);
        }
        if (brightness > 100 || brightness < 0) {
            throw new IllegalArgumentException("Brightness should be [0,100]! Was " + brightness);
        }
        final String rgb = hex.substring(2);
        final String red = rgb.substring(0, 2);
        final String green = rgb.substring(2, 4);
        final String blue = rgb.substring(4, 6);

        final Rgb rgbColor = new Rgb(parseInt(red, 16), parseInt(green, 16), parseInt(blue, 16));

        final Hsv hsbType = Hsv.fromRgb(rgbColor);
        return new Hsv(
                hsbType.getHue(),
                hsbType.getSaturation(),
                brightness / 100.0);
    }

    private static double checkBoundaries(double x, double max) {
        if (x > max) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be bigger than `" + max + "`!");
        }
        return x;
    }

    private static int checkBoundaries(int x, int max) {
        if (x > max) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be bigger than `" + max + "`!");
        }
        return x;
    }

    public static final class Hsv implements Serializable {
        private static final long serialVersionUID = 1L;
        private final double hue;
        private final double saturation;
        private final double value;

        /**
         * https://stackoverflow.com/a/6930407/1819402
         */
        public static Hsv fromRgb(Rgb rgb) {
            final double red = rgb.red / 255.0;
            final double green = rgb.green / 255.0;
            final double blue = rgb.blue / 255.0;

            final double colorMax = max(red, max(green, blue));
            final double colorMin = min(red, min(green, blue));
            final double delta = colorMax - colorMin;

            final double hue;
            final double saturation;
            if (delta == 0.0) {
                hue = 0;
                saturation = 0;
            } else if (colorMax > 0.0) {
                saturation = delta / colorMax;
                if (red >= colorMax) {
                    hue = (green - blue) / delta * 60;
                } else if (green >= colorMax) {
                    hue = 2.0 + (blue - red) / delta * 60;
                } else if (blue >= colorMax) {
                    hue = 4.0 + (red - green) / delta * 60;
                } else {
                    throw new RuntimeException("Cannot find HSV hue for RGB `" + rgb + "`!");
                }
            } else {
                throw new RuntimeException("Cannot find HSV for RGB `" + rgb + "`!");
            }

            return new Hsv(hue, saturation, colorMax);
        }

        public Hsv(final double hue, final double saturation, final double value) {
            this.hue = checkBoundaries(hue, 359.0);
            this.saturation = checkBoundaries(saturation, 1.0);
            this.value = checkBoundaries(value, 1.0);
        }

        public Rgb toRgb() {
            return Rgb.fromHsv(this);
        }

        public double getHue() {
            return hue;
        }

        public double getSaturation() {
            return saturation;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Hsv)) return false;
            final Hsv hsv = (Hsv) o;
            return Double.compare(hsv.hue, hue) == 0 &&
                           Double.compare(hsv.saturation, saturation) == 0 &&
                           Double.compare(hsv.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hue, saturation, value);
        }

        @Override
        public String toString() {
            return "Hsv{" +
                           "hue=" + hue +
                           ", saturation=" + saturation +
                           ", value=" + value +
                           '}';
        }
    }

    public static final class Rgb implements Serializable {
        private static final long serialVersionUID = 1L;
        private final int red;
        private final int green;
        private final int blue;

        public static Rgb fromHsv(Hsv hsv) {
            if (hsv.value == 0.0) {
                return new Rgb(0, 0, 0);
            } else {
                final int i = (int) floor(hsv.hue / 60.0);
                final double f = hsv.hue - i;
                final double p = hsv.value * (1.0 - hsv.saturation);
                final double q = hsv.value * (1.0 - (hsv.saturation * f));
                final double t = hsv.value * (1.0 - (hsv.saturation * (1.0 - f)));
                switch (i) {
                    case 0:
                        return new Rgb((int) hsv.value, (int) t, (int) p);
                    case 1:
                        return new Rgb((int) q, (int) hsv.value, (int) p);
                    case 2:
                        return new Rgb((int) p, (int) hsv.value, (int) t);
                    case 3:
                        return new Rgb((int) p, (int) q, (int) hsv.value);
                    case 4:
                        return new Rgb((int) t, (int) p, (int) hsv.value);
                    case 5:
                        return new Rgb((int) hsv.value, (int) p, (int) q);
                    default:
                        throw new RuntimeException("Cannot find RGB for HSV `" + hsv + "`!");
                }
            }
        }

        public Rgb(final int red, final int green, final int blue) {
            this.red = checkBoundaries(red, 255);
            this.green = checkBoundaries(green, 255);
            this.blue = checkBoundaries(blue, 255);
        }

        public Hsv toHsv() {
            return Hsv.fromRgb(this);
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Rgb)) return false;
            final Rgb rgb = (Rgb) o;
            return red == rgb.red &&
                           green == rgb.green &&
                           blue == rgb.blue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(red, green, blue);
        }

        @Override
        public String toString() {
            return "Rgb{" +
                           "red=" + red +
                           ", green=" + green +
                           ", blue=" + blue +
                           '}';
        }
    }
}
