# jSuplaApi

***

<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <b><em>jSuplaApi</em></b><br>
    IoT with Java and <why href="https://supla.org">Supla</why>
</div>

<div align="center">

[![Build Status](https://travis-ci.org/magx2/jSuplaApi.svg?branch=master)](https://travis-ci.org/magx2/jSuplaApi)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/magx2/jSuplaApi.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/magx2/jSuplaApi/alerts/)
[![Download](https://api.bintray.com/packages/big-boy/bigboy/jSuplaApi/images/download.svg) ](https://bintray.com/big-boy/bigboy/jSuplaApi/_latestVersion)

</div>

***

This library is client for [Supla Cloud](https://cloud.supla.org/).

Swagger documentation can be found here: 

* [version 2.3.0](https://app.swaggerhub.com/apis/supla/supla-cloud-api/2.3.0)

## Example Usage

```java
import pl.grzeslowski.jsupla.api.Api;

class Main {
    public static void main(String[] args) {
        final String token = "MzFhYTNiZTAwODg5M2E0NDE3OGUwNWE5ZjYzZWQ2YzllZGFiYWRmNDQwNDBlNmZhZGEzN2I3NTJiOWM2ZWEyZg" +
                             ".aHR0cDovL2xvY2FsaG9zdDo5MDkw"; // This part is base64 encoded server URL
        Api api = Api.getInstance(token);

        // Get API version
        final String apiVersion = api.getVersion();
        System.out.println("Current API version: " + apiUsageStatistics);

        // Find all Channels
        api.getChannelApi()
            .findChannels()
            .forEach(System.out::println);

        // Find all devices
        api.getDeviceApi()
            .findDevices()
            .forEach(System.out::println);
        
        // How to check API usage statistics
        final String apiUsageStatistics = api.getApiUsageStatistics()
        			.map(it -> it.toString())
        			.orElse("<none>");
        System.out.println("Your API usage statistics: " + apiUsageStatistics);
    }
}
```

## Installation

### Maven Users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>pl.grzeslowski.jsupla.api</groupId>
  <artifactId>jsupla-api</artifactId>
  <version>${jSuplaApi.version}</version>
  <type>compile</type>
</dependency>
```

### Gradle Users

Add this dependency to your project's build file:

```groovy
implementation 'pl.grzeslowski.jsupla.api:jsupla-api:$jSuplaApiVersion'
```

### Fat Jar Artifact

From version `3.8.x` you can use `jsupla-api-fat` artifact to import jSuplaApi jar with all its dependencies.

### Plain Jar

At first generate the JAR by executing:

    gradlew clean build

Then manually install the following JARs:

* build/libs/jsupla-api-\<version\>.jar

## Releases

Auto generated [**release Notes**](docs/release-notes.md).

This software is proudly released with [Shipkit](https://github.com/mockito/shipkit). 

## Recommendation

It's recommended to create an instance of `Api` per thread in a multithreaded environment to avoid any potential issues.

## Related Projects

1. [jSupla](https://github.com/magx2/jSupla) - Javas implementation of Supla protocol
2. [OpenHAB binding](https://github.com/magx2/openhab2-addons/tree/jSupla) - Binding for OpenHAB
2. [jSuplaServerMock](https://github.com/magx2/jSuplaServerMock) - Mock implementation of Supla Cloud
3. [jSuplaGui](https://github.com/magx2/jSuplaGui) - GUI for Supla Cloud

## Author(s)

**Martin Grześlowski** (github/magx2)