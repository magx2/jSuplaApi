
# Device

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Device identifier |  [optional]
**name** | **String** |  |  [optional]
**enabled** | **Boolean** |  |  [optional]
**comment** | **String** |  |  [optional]
**regDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**regIpv4** | **Integer** |  |  [optional]
**lastConnected** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**lastIpv4** | **Integer** |  |  [optional]
**softwareVersion** | **String** |  |  [optional]
**gUIDString** | **String** |  |  [optional]
**locationId** | **Integer** |  |  [optional]
**originalLocationId** | **Integer** |  |  [optional]
**channelsIds** | **List&lt;Integer&gt;** |  |  [optional]
**connected** | **Boolean** |  |  [optional]
**location** | [**Location**](Location.md) |  |  [optional]
**originalLocation** | [**Location**](Location.md) |  |  [optional]
**channels** | [**List&lt;Channel&gt;**](Channel.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**schedules** | [**List&lt;Schedule&gt;**](Schedule.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]



