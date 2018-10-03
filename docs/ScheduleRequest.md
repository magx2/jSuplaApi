
# ScheduleRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**channelId** | **Integer** |  | 
**actionId** | **Integer** |  | 
**mode** | [**ModeEnum**](#ModeEnum) |  | 
**timeExpression** | **String** | Schedule time expression in crontab notation (with some custom additions). | 
**actionParam** | [**ERRORUNKNOWN**](ERRORUNKNOWN.md) |  |  [optional]
**dateStart** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**dateEnd** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**caption** | **String** |  |  [optional]
**retry** | **Boolean** |  |  [optional]


<a name="ModeEnum"></a>
## Enum: ModeEnum
Name | Value
---- | -----
ONCE | &quot;once&quot;
MINUTELY | &quot;minutely&quot;
DAILY | &quot;daily&quot;
HOURLY | &quot;hourly&quot;



