package pl.grzeslowski.jsupla.api

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
}
