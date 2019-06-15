package pl.grzeslowski.jsupla.api.internal.generated

import spock.lang.Specification

class ApiClientSpec extends Specification {

	@SuppressWarnings("GroovyAccessibility")
	def "should have proper user agent"() {
		given:
		def client = new ApiClient()

		when:
		def userAgent = client.defaultHeaderMap["User-Agent"]

		then:
		userAgent == 'magx2/jSuplaApi'
	}
}
