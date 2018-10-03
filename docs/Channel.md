
# Channel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Channel identifier |  [optional]
**channelNumber** | **Integer** | Channel ordinal number in its IO Device |  [optional]
**caption** | **String** | Channel caption |  [optional]
**type** | [**ChannelType**](ChannelType.md) |  |  [optional]
**function** | [**ChannelFunction**](ChannelFunction.md) |  |  [optional]
**param1** | **Integer** |  |  [optional]
**param2** | **Integer** |  |  [optional]
**param3** | **Integer** |  |  [optional]
**altIcon** | **Integer** | Chosen alternative icon idenifier. Should not be greater than &#x60;funciton.maxAlternativeIconIndex&#x60; |  [optional]
**hidden** | **Boolean** | Whether this channel is shown on client apps or not |  [optional]
**inheritedLocation** | **Boolean** | Whether this channel inherits its IO Device&#39;s location (&#x60;true&#x60;) or not (&#x60;false&#x60;) |  [optional]
**iodeviceId** | **Integer** |  |  [optional]
**locationId** | **Integer** |  |  [optional]
**functionId** | **Integer** |  |  [optional]
**typeId** | **Integer** |  |  [optional]
**iodevice** | [**Device**](Device.md) |  |  [optional]
**location** | [**Location**](Location.md) |  |  [optional]
**connected** | **Boolean** |  |  [optional]
**state** | [**ERRORUNKNOWN**](ERRORUNKNOWN.md) | The channel&#39;s state. The value and the format is dependend on the channel&#39;s function. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-states). |  [optional]
**supportedFunctions** | [**List&lt;ChannelFunction&gt;**](ChannelFunction.md) |  |  [optional]



