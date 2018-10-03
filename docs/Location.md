
# Location

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Location identifier |  [optional]
**caption** | **String** | Location caption |  [optional]
**enabled** | **Boolean** | &#x60;true&#x60; if the location is enabled, &#x60;false&#x60; otherwise |  [optional]
**iodevicesIds** | **List&lt;Integer&gt;** | array containing the IO Devices identifiers assigned to this location |  [optional]
**channelGroupsIds** | **List&lt;Integer&gt;** | array containing the Channel groups identifiers assigned to this location |  [optional]
**channelsIds** | **List&lt;Integer&gt;** | array containing the Channels identifiers expicitely assigned to this location |  [optional]
**accessIdsIds** | **List&lt;Integer&gt;** | array containing the Access Identifiers identifiers assigned to this location |  [optional]
**password** | **String** | Location password (plain text). Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**iodevices** | [**List&lt;Device&gt;**](Device.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**channelGroups** | [**List&lt;ChannelGroup&gt;**](ChannelGroup.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**accessIds** | [**List&lt;AccessIdentifier&gt;**](AccessIdentifier.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**channels** | [**List&lt;Channel&gt;**](Channel.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]



