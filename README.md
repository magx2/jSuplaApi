# swagger-java-client

***

<div align="center">
    <b><em>jSupla</em></b><br>
    IoT with Java and <why href="https://supla.org">Supla</why>
</div>

<div align="center">

[![Build Status](https://travis-ci.org/magx2/jSupla.svg?branch=master)](https://travis-ci.org/magx2/jSuplaApi)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/magx2/jSuplaApi.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/magx2/jSuplaApi/alerts/)

</div>

***

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AccessIdentifiersApi;

import java.io.File;
import java.util.*;

public class AccessIdentifiersApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure OAuth2 access token for authorization: password
        OAuth password = (OAuth) defaultClient.getAuthentication("password");
        password.setAccessToken("YOUR ACCESS TOKEN");

        AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
        try {
            AccessIdentifier result = apiInstance.createAccessIdentifier();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessIdentifiersApi#createAccessIdentifier");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccessIdentifiersApi* | [**createAccessIdentifier**](docs/AccessIdentifiersApi.md#createAccessIdentifier) | **POST** /accessids | Create a new Access Identifier
*AccessIdentifiersApi* | [**deleteAccessIdentifier**](docs/AccessIdentifiersApi.md#deleteAccessIdentifier) | **DELETE** /accessids/{id} | Delete Access Identifier
*AccessIdentifiersApi* | [**getAccessIdentifier**](docs/AccessIdentifiersApi.md#getAccessIdentifier) | **GET** /accessids/{id} | Get Access Identifier
*AccessIdentifiersApi* | [**getAccessIdentifiers**](docs/AccessIdentifiersApi.md#getAccessIdentifiers) | **GET** /accessids | Get Access Identifiers list
*AccessIdentifiersApi* | [**updateAccessIdentifier**](docs/AccessIdentifiersApi.md#updateAccessIdentifier) | **PUT** /accessids/{id} | Update Access Identifier
*ChannelGroupsApi* | [**createChannelGroup**](docs/ChannelGroupsApi.md#createChannelGroup) | **POST** /channel-groups | Create a new channel group
*ChannelGroupsApi* | [**deleteChannelGroup**](docs/ChannelGroupsApi.md#deleteChannelGroup) | **DELETE** /channel-groups/{id} | Delete Channel Group
*ChannelGroupsApi* | [**executeChannelGroupAction**](docs/ChannelGroupsApi.md#executeChannelGroupAction) | **PATCH** /channel-groups/{id} | Execute action on the channel group
*ChannelGroupsApi* | [**getChannelGroup**](docs/ChannelGroupsApi.md#getChannelGroup) | **GET** /channel-groups/{id} | Get channel group by ID
*ChannelGroupsApi* | [**getChannelGroups**](docs/ChannelGroupsApi.md#getChannelGroups) | **GET** /channel-groups | Get channels list
*ChannelGroupsApi* | [**updateChannelGroup**](docs/ChannelGroupsApi.md#updateChannelGroup) | **PUT** /channel-groups/{id} | Update channel group
*ChannelsApi* | [**executeAction**](docs/ChannelsApi.md#executeAction) | **PATCH** /channels/{id} | Execute action on the channel
*ChannelsApi* | [**getChannel**](docs/ChannelsApi.md#getChannel) | **GET** /channels/{id} | Get channel by ID
*ChannelsApi* | [**getChannelMeasurementLogs**](docs/ChannelsApi.md#getChannelMeasurementLogs) | **GET** /channels/{id}/measurement-logs | Get measurement logs.
*ChannelsApi* | [**getChannelMeasurementLogsCsvFile**](docs/ChannelsApi.md#getChannelMeasurementLogsCsvFile) | **GET** /channels/{id}/measurement-logs-csv | Get measurement logs as zipped CSV file.
*ChannelsApi* | [**getChannelSchedules**](docs/ChannelsApi.md#getChannelSchedules) | **GET** /channels/{id}/schedules | Get schedules list of the channel
*ChannelsApi* | [**getChannels**](docs/ChannelsApi.md#getChannels) | **GET** /channels | Get channels list
*ChannelsApi* | [**updateChannel**](docs/ChannelsApi.md#updateChannel) | **PUT** /channels/{id} | Update channel
*ClientAppsApi* | [**deleteClientApp**](docs/ClientAppsApi.md#deleteClientApp) | **DELETE** /client-apps/{id} | Delete Client App
*ClientAppsApi* | [**getClientApps**](docs/ClientAppsApi.md#getClientApps) | **GET** /client-apps | Get client apps
*ClientAppsApi* | [**updateClientApp**](docs/ClientAppsApi.md#updateClientApp) | **PUT** /client-apps/{id} | Update client app
*IoDevicesApi* | [**deleteIoDevice**](docs/IoDevicesApi.md#deleteIoDevice) | **DELETE** /iodevices/{id} | Delete IO Device
*IoDevicesApi* | [**getIoDevice**](docs/IoDevicesApi.md#getIoDevice) | **GET** /iodevices/{id} | Get IO Device
*IoDevicesApi* | [**getIoDeviceChannels**](docs/IoDevicesApi.md#getIoDeviceChannels) | **GET** /iodevices/{id}/channels | Get Channels that belong to IO Deice
*IoDevicesApi* | [**getIoDevices**](docs/IoDevicesApi.md#getIoDevices) | **GET** /iodevices | Get IO Devices
*IoDevicesApi* | [**updateIoDevice**](docs/IoDevicesApi.md#updateIoDevice) | **PUT** /iodevices/{id} | Update IO Device
*LocationsApi* | [**createLocation**](docs/LocationsApi.md#createLocation) | **POST** /locations | Create a new location
*LocationsApi* | [**deleteLocation**](docs/LocationsApi.md#deleteLocation) | **DELETE** /locations/{id} | Delete location
*LocationsApi* | [**getLocation**](docs/LocationsApi.md#getLocation) | **GET** /locations/{id} | Get location by ID
*LocationsApi* | [**getLocations**](docs/LocationsApi.md#getLocations) | **GET** /locations | Get locations list
*LocationsApi* | [**updateLocation**](docs/LocationsApi.md#updateLocation) | **PUT** /locations/{id} | Update location
*SchedulesApi* | [**createSchedule**](docs/SchedulesApi.md#createSchedule) | **POST** /schedules | Create a new schedule
*SchedulesApi* | [**deleteSchedule**](docs/SchedulesApi.md#deleteSchedule) | **DELETE** /schedules/{id} | Delete Schedule
*SchedulesApi* | [**enableSchedules**](docs/SchedulesApi.md#enableSchedules) | **PATCH** /schedules | Enable schedules
*SchedulesApi* | [**getSchedule**](docs/SchedulesApi.md#getSchedule) | **GET** /schedules/{id} | Get Schedule
*SchedulesApi* | [**getSchedules**](docs/SchedulesApi.md#getSchedules) | **GET** /schedules | Get schedules list
*SchedulesApi* | [**updateSchedule**](docs/SchedulesApi.md#updateSchedule) | **PUT** /schedules/{id} | Update schedule
*ServerApi* | [**getServerInfo**](docs/ServerApi.md#getServerInfo) | **GET** /server-info | Get server info
*ServerApi* | [**getSuplaServerStatus**](docs/ServerApi.md#getSuplaServerStatus) | **GET** /server-status | Get the SUPLA Server status
*UsersApi* | [**getCurrentUser**](docs/UsersApi.md#getCurrentUser) | **GET** /users/current | Get current user
*UsersApi* | [**updateCurrentUser**](docs/UsersApi.md#updateCurrentUser) | **PATCH** /users/current | Update current user


## Documentation for Models

 - [AccessIdentifier](docs/AccessIdentifier.md)
 - [AccessIdentifierUpdateRequest](docs/AccessIdentifierUpdateRequest.md)
 - [Channel](docs/Channel.md)
 - [ChannelExecuteActionRequest](docs/ChannelExecuteActionRequest.md)
 - [ChannelFunction](docs/ChannelFunction.md)
 - [ChannelFunctionAction](docs/ChannelFunctionAction.md)
 - [ChannelFunctionActionEnum](docs/ChannelFunctionActionEnum.md)
 - [ChannelFunctionEnumNames](docs/ChannelFunctionEnumNames.md)
 - [ChannelGroup](docs/ChannelGroup.md)
 - [ChannelGroupRequest](docs/ChannelGroupRequest.md)
 - [ChannelMeasurementLog](docs/ChannelMeasurementLog.md)
 - [ChannelType](docs/ChannelType.md)
 - [ChannelUpdateRequest](docs/ChannelUpdateRequest.md)
 - [ClientApp](docs/ClientApp.md)
 - [ClientAppUpdateRequest](docs/ClientAppUpdateRequest.md)
 - [Device](docs/Device.md)
 - [IODeviceUpdateRequest](docs/IODeviceUpdateRequest.md)
 - [Location](docs/Location.md)
 - [LocationUpdateRequest](docs/LocationUpdateRequest.md)
 - [Schedule](docs/Schedule.md)
 - [ScheduleClosestExecutions](docs/ScheduleClosestExecutions.md)
 - [ScheduleFuture](docs/ScheduleFuture.md)
 - [SchedulePast](docs/SchedulePast.md)
 - [ScheduleRequest](docs/ScheduleRequest.md)
 - [ScheduleResult](docs/ScheduleResult.md)
 - [SchedulesEnableRequest](docs/SchedulesEnableRequest.md)
 - [UserUpdateRequest](docs/UserUpdateRequest.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### password

- **Type**: OAuth
- **Flow**: password
- **Authorization URL**: 
- **Scopes**: 
  - restapi: full API access


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



