package pl.grzeslowski.jsupla.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

import static java.lang.Math.floor;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Color {

    @EqualsAndHashCode
    @ToString
    @Getter
    public static class Rgb implements Serializable {
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
    }

    @EqualsAndHashCode
    @ToString
    @Getter
    public static class Hsv implements Serializable {
        private static final long serialVersionUID = 1L;
        private final double hue;
        private final double saturation;
        private final double value;

        // https://stackoverflow.com/a/6930407/1819402
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
}
