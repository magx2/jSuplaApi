package pl.grzeslowski.jsupla.api

import pl.grzeslowski.jsupla.api.internal.ApiClientFactory
import spock.lang.Specification

class ApiClientFactorySpec extends Specification {
	def "should set oAuth token"() {
		given:
		def token = "MTA1YzRhYWRiNzcyYTI0NzliNmMxZTM0MTkwNGM4NGYzYjY0YjBmZjBkYTUxZGVhNDg1NmYyODc1NDM3NDQxOA.aHR0cHM6Ly9zdnI0LnN1cGxhLm9yZw=="

		when:
		def client = ApiClientFactory.INSTANCE.newApiClient(token)

		then:
		client.getAuthentications()["BearerAuth"].accessToken == token
	}

	def "should set proper base path"() {
		given:
		def token = "MTA1YzRhYWRiNzcyYTI0NzliNmMxZTM0MTkwNGM4NGYzYjY0YjBmZjBkYTUxZGVhNDg1NmYyODc1NDM3NDQxOA.aHR0cHM6Ly9zdnI0LnN1cGxhLm9yZw=="

		when:
		def client = ApiClientFactory.INSTANCE.newApiClient(token)

		then:
		client.basePath == "https://svr4.supla.org/api/v2.3.0"
	}

	def "should throw exception when there is no dot in token"() {
		given:
		def token = "MTA1YzRhYWRiNzcyYTI0NzliNmMxZTM0MTkwNGM4NGYzYjY0YjBmZjBkYTUxZGVhNDg1NmYyODc1NDM3NDQxOA_aHR0cHM6Ly9zdnI0LnN1cGxhLm9yZw=="

		when:
		ApiClientFactory.INSTANCE.newApiClient(token)

		then:
		IllegalArgumentException ex = thrown()
		ex.message == "OAuth token does not contain '.' (dot)!"
	}

	def "should throw exception when there is too many dots in token"() {
		given:
		def token = "MTA1YzRhYWRiNzcyYTI0NzliNmMxZTM0MTkwNGM4N.GYzYjY0YjBmZjBkYTUxZGVhNDg1NmYyODc1NDM3NDQxOA.aHR0cHM6Ly9zdnI0LnN1cGxhLm9yZw=="

		when:
		ApiClientFactory.INSTANCE.newApiClient(token)

		then:
		IllegalArgumentException ex = thrown()
		ex.message.startsWith("OAuth token has too many '.' (dot) ")
	}
}
