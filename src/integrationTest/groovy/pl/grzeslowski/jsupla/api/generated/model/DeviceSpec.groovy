package pl.grzeslowski.jsupla.api.generated.model

import spock.lang.Specification

class DeviceSpec extends Specification {
	def "should have String as lastIpv4"() {
		expect:
		new Device(lastIpv4: 1).lastIpv4 instanceof String
	}

	def "should have String as regIpv4"() {
		expect:
		new Device(regIpv4: 1).regIpv4 instanceof String
	}
}
