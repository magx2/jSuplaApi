
# ChannelGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Channel group identifier |  [optional]
**hidden** | **Boolean** | Whether this channel group is shown on client apps or not |  [optional]
**caption** | **String** | Channel caption |  [optional]
**function** | [**ChannelFunction**](ChannelFunction.md) |  |  [optional]
**functionId** | **Integer** |  |  [optional]
**locationId** | **Integer** |  |  [optional]
**location** | [**Location**](Location.md) |  |  [optional]
**channelIds** | **List&lt;Integer&gt;** |  |  [optional]
**channels** | [**List&lt;Channel&gt;**](Channel.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**altIcon** | **Integer** | Chosen alternative icon idenifier. Should not be greater than &#x60;funciton.maxAlternativeIconIndex&#x60; |  [optional]



