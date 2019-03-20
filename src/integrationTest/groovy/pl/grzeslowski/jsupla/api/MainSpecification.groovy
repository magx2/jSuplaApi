package pl.grzeslowski.jsupla.api

import pl.grzeslowski.jsupla.api.generated.ApiClient
import pl.grzeslowski.jsupla.api.generated.api.*
import spock.lang.Requires
import spock.lang.Shared
import spock.lang.Specification

@Requires({ System.getenv(JSUPLA_API_TOKEN_RO) })
class MainSpecification extends Specification {
	static final String JSUPLA_API_TOKEN_RO = "JSUPLA_API_TOKEN_RO"
	@Shared
	static ApiClient client = new ApiClient()

	void setupSpec() {
		def token = System.getenv(JSUPLA_API_TOKEN_RO)
		client = ApiClientFactory.INSTANCE.newApiClient(token)
	}

	def "ServerApi"() {
		given:
		def serverApi = new ServerApi(client)

		when:
		def info = serverApi.getServerInfo()

		then:
		info
		info.address
		info.apiVersion
		info.cloudVersion
		info.supportedApiVersions
		info.time
		info.timezone
	}

	def "AccessIdentifiersApi"() {
		given:
		def accessIdentifiersApi = new AccessIdentifiersApi(client)

		when:
		def identifier = accessIdentifiersApi.createAccessIdentifier()

		then:
		identifier
		identifier.id
	}

	def "ChannelGroupsApi"() {
		given:
		def channelGroupsApi = new ChannelGroupsApi(client)

		when:
		def channelGroups = channelGroupsApi.getChannelGroups([])

		then:
		channelGroups != null
	}

	def "ChannelsApi"() {
		given:
		def channelsApi = new ChannelsApi(client)

		when:
		def channels = channelsApi.getChannels([], [], null, true)

		then:
		channels != null
	}

	def "IoDevicesApi"() {
		given:
		def ioDevicesApi = new IoDevicesApi(client)

		when:
		def ioDevices = ioDevicesApi.getIoDevices(["channels", "location"])

		println(ioDevices*.regIpv4)

		then:
		ioDevices != null
	}

	def "UsersApi"() {
		given:
		def usersApi = new UsersApi(client)

		when:
		def user = usersApi.currentUser

		then:
		user
		user.email
	}
}
