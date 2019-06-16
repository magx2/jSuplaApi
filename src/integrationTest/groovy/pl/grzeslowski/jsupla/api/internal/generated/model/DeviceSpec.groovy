package pl.grzeslowski.jsupla.api.internal.generated.model

import io.swagger.client.model.Device
import spock.lang.Specification

class DeviceSpec extends Specification {
	def "should have Long as lastIpv4"() {
		expect:
		new Device(lastIpv4: 1).lastIpv4 instanceof Long
	}

	def "should have Long as regIpv4"() {
		expect:
		new Device(regIpv4: 1).regIpv4 instanceof Long
	}
}
