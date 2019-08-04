package pl.grzeslowski.jsupla.api

import pl.grzeslowski.jsupla.api.Color.Hsv
import spock.lang.Specification
import spock.lang.Unroll

import static pl.grzeslowski.jsupla.api.Color.Rgb
import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

class ColorSpecification extends Specification {
	@Unroll
	def "HSV to RGB to HSV"(h, s, v) {
		given:
		def hsv1 = new Hsv(h, s, v)

		when:
		def rgb1 = hsv1.toRgb()
		def hsv2 = rgb1.toHsv()
		def rgb2 = hsv2.toRgb()

		then:
		println(hsv1)
		println(rgb1)
		println(hsv2)
		that hsv1.hue, closeTo(hsv2.hue, 0.1)
		that hsv1.saturation, closeTo(hsv2.saturation, 0.1)
		that hsv1.value, closeTo(hsv2.value, 0.1)
		rgb1 == rgb2

		where:
		h   | s    | v
		0   | 0    | 0
		0   | 0    | 1
		0   | 1    | 1
		359 | 1    | 1
		60  | 1    | 1
		86  | 0.67 | 1
	}

	@Unroll
	def "RGB to HSV to RGB"(r, g, b) {
		given:
		def rgb1 = new Rgb(r, g, b)

		when:
		def hsv1 = rgb1.toHsv()
		def rgb2 = hsv1.toRgb()
		def hsv2 = rgb2.toHsv()

		then:
		rgb1 == rgb2
		that hsv1.hue, closeTo(hsv2.hue, 0.1)
		that hsv1.saturation, closeTo(hsv2.saturation, 0.1)
		that hsv1.value, closeTo(hsv2.value, 0.1)

		where:
		r   | g   | b
		0   | 0   | 0
		255 | 0   | 0
		0   | 255 | 0
		0   | 0   | 255
		123 | 87  | 230
		30  | 1   | 120
		250 | 60  | 3
	}
}
