package pl.grzeslowski.jsupla.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

public class Color {
    private static final double MAX_HUE = 360.0;

    @EqualsAndHashCode
    @ToString
    @Getter
    public static class Rgb implements Serializable {
        private static final long serialVersionUID = 1L;
        private final int red;
        private final int green;
        private final int blue;

        @SuppressWarnings("WeakerAccess")
        public static Rgb fromHsv(Hsv hsv) {
            int rgb = java.awt.Color.HSBtoRGB((float) (hsv.hue / MAX_HUE), (float) hsv.saturation, (float) hsv.value);
            int red = (rgb >> 16) & 0xFF;
            int green = (rgb >> 8) & 0xFF;
            int blue = rgb & 0xFF;
            return new Rgb(red, green, blue);
        }

        public Rgb(final int red, final int green, final int blue) {
            this.red = checkBoundaries(red, 0, 255);
            this.green = checkBoundaries(green, 0, 255);
            this.blue = checkBoundaries(blue, 0, 255);
        }

        public Rgb(final double red, final double green, final double blue) {
            this(
                    (int) (checkBoundaries(red, 0.0, 1.0) * 255.0),
                    (int) (checkBoundaries(green, 0.0, 1.0) * 255.0),
                    (int) (checkBoundaries(blue, 0.0, 1.0) * 255.0));
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
        /**
         * Hue [0, 359]
         */
        private final double hue;
        /**
         * Saturation [0, 1]
         */
        private final double saturation;
        /**
         * Value [0, 1]
         */
        private final double value;

        public static Hsv fromRgb(Rgb rgb) {
            float[] hsv = java.awt.Color.RGBtoHSB(rgb.red, rgb.green, rgb.blue, null);
            return new Hsv(hsv[0] * MAX_HUE, hsv[1], hsv[2]);
        }

        public Hsv(final double hue, final double saturation, final double value) {
            if (hue != MAX_HUE) {
                this.hue = checkBoundaries(hue, 0.0, MAX_HUE);
            } else {
                this.hue = 0.0;
            }
            this.saturation = checkBoundaries(saturation, 0.0, 1.0);
            this.value = checkBoundaries(value, 0.0, 1.0);
        }

        public Hsv setHue(final double hue) {
            return new Hsv(hue, saturation, value);
        }

        public Hsv setSaturation(final double saturation) {
            return new Hsv(hue, saturation, value);
        }

        public Hsv setValue(final double value) {
            return new Hsv(hue, saturation, value);
        }

        public Rgb toRgb() {
            return Rgb.fromHsv(this);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static double checkBoundaries(double x, double min, double max) {
        if (x < min) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be smaller than `" + min + "`!");
        }
        if (x > max) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be bigger than `" + max + "`!");
        }
        return x;
    }

    @SuppressWarnings("SameParameterValue")
    private static int checkBoundaries(int x, int min, int max) {
        if (x < min) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be smaller than `" + min + "`!");
        }
        if (x > max) {
            throw new IllegalArgumentException("Given value `" + x + "` cannot be bigger than `" + max + "`!");
        }
        return x;
    }
}
