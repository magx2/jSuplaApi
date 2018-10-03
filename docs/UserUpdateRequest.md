
# UserUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**action** | [**ActionEnum**](#ActionEnum) | The &#x60;change:userTimezone&#x60; requires to provide also a &#x60;timezone&#x60; value in the request. The &#x60;change:password&#x60; requires to provide also a &#x60;newPassword&#x60; and &#x60;oldPassword&#x60; in the request. |  [optional]


<a name="ActionEnum"></a>
## Enum: ActionEnum
Name | Value
---- | -----
CHANGE_CLIENTSREGISTRATIONENABLED | &quot;change:clientsRegistrationEnabled&quot;
CHANGE_IODEVICESREGISTRATIONENABLED | &quot;change:ioDevicesRegistrationEnabled&quot;
CHANGE_USERTIMEZONE | &quot;change:userTimezone&quot;
CHANGE_PASSWORD | &quot;change:password&quot;
AGREE_RULES | &quot;agree:rules&quot;
AGREE_COOKIES | &quot;agree:cookies&quot;



