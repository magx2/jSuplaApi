# ChannelsApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**executeAction**](ChannelsApi.md#executeAction) | **PATCH** /channels/{id} | Execute action on the channel
[**getChannel**](ChannelsApi.md#getChannel) | **GET** /channels/{id} | Get channel by ID
[**getChannelMeasurementLogs**](ChannelsApi.md#getChannelMeasurementLogs) | **GET** /channels/{id}/measurement-logs | Get measurement logs.
[**getChannelMeasurementLogsCsvFile**](ChannelsApi.md#getChannelMeasurementLogsCsvFile) | **GET** /channels/{id}/measurement-logs-csv | Get measurement logs as zipped CSV file.
[**getChannelSchedules**](ChannelsApi.md#getChannelSchedules) | **GET** /channels/{id}/schedules | Get schedules list of the channel
[**getChannels**](ChannelsApi.md#getChannels) | **GET** /channels | Get channels list
[**updateChannel**](ChannelsApi.md#updateChannel) | **PUT** /channels/{id} | Update channel


<a name="executeAction"></a>
# **executeAction**
> executeAction(id, body)

Execute action on the channel

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
ChannelExecuteActionRequest body = new ChannelExecuteActionRequest(); // ChannelExecuteActionRequest | Defines an action to execute on channel. The `action` key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions).
try {
    apiInstance.executeAction(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#executeAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ChannelExecuteActionRequest**](ChannelExecuteActionRequest.md)| Defines an action to execute on channel. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). |

### Return type

null (empty response body)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannel"></a>
# **getChannel**
> Channel getChannel(id, include)

Get channel by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Channel result = apiInstance.getChannel(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#getChannel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: iodevice, location, connected, state, supportedFunctions]

### Return type

[**Channel**](Channel.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannelMeasurementLogs"></a>
# **getChannelMeasurementLogs**
> List&lt;Object&gt; getChannelMeasurementLogs(id, limit, offset)

Get measurement logs.

Supported channel functions: &#x60;THERMOMETER&#x60; and &#x60;HUMIDITYANDTEMPERATURE&#x60;. Logs ordered by date, descending.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
Integer limit = 5000; // Integer | Maximum items count in response, from 1 to 5000
Integer offset = 56; // Integer | Pagination offset
try {
    List<Object> result = apiInstance.getChannelMeasurementLogs(id, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#getChannelMeasurementLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **limit** | **Integer**| Maximum items count in response, from 1 to 5000 | [optional] [default to 5000]
 **offset** | **Integer**| Pagination offset | [optional]

### Return type

**List&lt;Object&gt;**

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannelMeasurementLogsCsvFile"></a>
# **getChannelMeasurementLogsCsvFile**
> File getChannelMeasurementLogsCsvFile(id)

Get measurement logs as zipped CSV file.

Supported channel functions: &#x60;THERMOMETER&#x60; and &#x60;HUMIDITYANDTEMPERATURE&#x60;. Logs ordered by date, descending.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
try {
    File result = apiInstance.getChannelMeasurementLogsCsvFile(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#getChannelMeasurementLogsCsvFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

[**File**](File.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/zip

<a name="getChannelSchedules"></a>
# **getChannelSchedules**
> List&lt;Schedule&gt; getChannelSchedules(id, include)

Get schedules list of the channel

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<Schedule> result = apiInstance.getChannelSchedules(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#getChannelSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channel, iodevice, location, closestExecutions]

### Return type

[**List&lt;Schedule&gt;**](Schedule.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannels"></a>
# **getChannels**
> List&lt;Channel&gt; getChannels(include, function, io, hasFunction)

Get channels list

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
List<String> function = Arrays.asList("function_example"); // List<String> | 
String io = "io_example"; // String | Return only `input` or `output` channels.
Boolean hasFunction = true; // Boolean | Return only channels with (`true`) or without (`false`) chosen functions.
try {
    List<Channel> result = apiInstance.getChannels(include, function, io, hasFunction);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#getChannels");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: iodevice, location]
 **function** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: NONE, CONTROLLINGTHEGATEWAYLOCK, CONTROLLINGTHEGATE, CONTROLLINGTHEGARAGEDOOR, THERMOMETER, HUMIDITY, HUMIDITYANDTEMPERATURE, OPENINGSENSOR_GATEWAY, OPENINGSENSOR_GATE, OPENINGSENSOR_GARAGEDOOR, NOLIQUIDSENSOR, CONTROLLINGTHEDOORLOCK, OPENINGSENSOR_DOOR, CONTROLLINGTHEROLLERSHUTTER, OPENINGSENSOR_ROLLERSHUTTER, POWERSWITCH, LIGHTSWITCH, DIMMER, RGBLIGHTING, DIMMERANDRGBLIGHTING, DEPTHSENSOR, DISTANCESENSOR, OPENINGSENSOR_WINDOW, MAILSENSOR, WINDSENSOR, PRESSURESENSOR, RAINSENSOR, WEIGHTSENSOR, WEATHER_STATION, STAIRCASETIMER]
 **io** | **String**| Return only &#x60;input&#x60; or &#x60;output&#x60; channels. | [optional] [enum: input, output]
 **hasFunction** | **Boolean**| Return only channels with (&#x60;true&#x60;) or without (&#x60;false&#x60;) chosen functions. | [optional]

### Return type

[**List&lt;Channel&gt;**](Channel.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChannel"></a>
# **updateChannel**
> Channel updateChannel(id, body)

Update channel

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelsApi apiInstance = new ChannelsApi();
Integer id = 56; // Integer | 
ChannelUpdateRequest body = new ChannelUpdateRequest(); // ChannelUpdateRequest | 
try {
    Channel result = apiInstance.updateChannel(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelsApi#updateChannel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ChannelUpdateRequest**](ChannelUpdateRequest.md)|  |

### Return type

[**Channel**](Channel.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

