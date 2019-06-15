package pl.grzeslowski.jsupla.api

import org.springframework.boot.loader.JarLauncher
import spock.lang.Ignore
import spock.lang.Specification

class MainSpecification extends Specification {
	static TOKEN = "MzFhYTNiZTAwODg5M2E0NDE3OGUwNWE5ZjYzZWQ2YzllZGFiYWRmNDQwNDBlNmZhZGEzN2I3NTJiOWM2ZWEyZg.aHR0cDovL2xvY2FsaG9zdDo5MDkw"
	Api api

	void setupSpec() {
		JarLauncher.main()
	}

	void setup() {
		api = Api.getInstance(TOKEN)
	}

	def "should find all devices"() {
		expect:
		api.deviceApi.findDevices()
	}

	def "should find device"() {
		given:
		def device = api.deviceApi.findDevices().first()

		when:
		def findDevice = api.deviceApi.findDevice(device.id)

		then:
		findDevice == device
	}

	def "should find all channels"() {
		expect:
		api.channelApi.findChannels()
	}

	@Ignore("Not implemented on server side!")
	def "should find channels for device"() {
		given:
		def device = api.deviceApi.findDevices().first()

		when:
		def channels = api.channelApi.findChannels(device)

		then:
		channels == device.channels
	}
}
