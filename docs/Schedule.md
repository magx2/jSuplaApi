
# Schedule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Schedule identifier |  [optional]
**timeExpression** | **String** | Schedule time expression in crontab notation (with some custom additions). |  [optional]
**action** | [**ChannelFunctionAction**](ChannelFunctionAction.md) |  |  [optional]
**actionParam** | [**ERRORUNKNOWN**](ERRORUNKNOWN.md) | Depends on the action. |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  |  [optional]
**dateStart** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**dateEnd** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**enabled** | **Boolean** |  |  [optional]
**caption** | **String** |  |  [optional]
**retry** | **Boolean** |  |  [optional]
**channelId** | **Integer** |  |  [optional]
**actionId** | **Integer** |  |  [optional]
**channel** | [**Channel**](Channel.md) |  |  [optional]
**closestExecutions** | [**List&lt;ScheduleClosestExecutions&gt;**](ScheduleClosestExecutions.md) | Returned only if requested by the &#x60;include&#x60; parameter. Contains two arrays of maximum 3 closest past and future executions. |  [optional]


<a name="ModeEnum"></a>
## Enum: ModeEnum
Name | Value
---- | -----
MINUTELY | &quot;minutely&quot;
HOURLY | &quot;hourly&quot;
DAILY | &quot;daily&quot;
ONCE | &quot;once&quot;



