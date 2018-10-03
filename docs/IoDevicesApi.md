# IoDevicesApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteIoDevice**](IoDevicesApi.md#deleteIoDevice) | **DELETE** /iodevices/{id} | Delete IO Device
[**getIoDevice**](IoDevicesApi.md#getIoDevice) | **GET** /iodevices/{id} | Get IO Device
[**getIoDeviceChannels**](IoDevicesApi.md#getIoDeviceChannels) | **GET** /iodevices/{id}/channels | Get Channels that belong to IO Deice
[**getIoDevices**](IoDevicesApi.md#getIoDevices) | **GET** /iodevices | Get IO Devices
[**updateIoDevice**](IoDevicesApi.md#updateIoDevice) | **PUT** /iodevices/{id} | Update IO Device


<a name="deleteIoDevice"></a>
# **deleteIoDevice**
> deleteIoDevice(id)

Delete IO Device

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IoDevicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

IoDevicesApi apiInstance = new IoDevicesApi();
Integer id = 56; // Integer | 
try {
    apiInstance.deleteIoDevice(id);
} catch (ApiException e) {
    System.err.println("Exception when calling IoDevicesApi#deleteIoDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getIoDevice"></a>
# **getIoDevice**
> Device getIoDevice(id, include)

Get IO Device

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IoDevicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

IoDevicesApi apiInstance = new IoDevicesApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Device result = apiInstance.getIoDevice(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IoDevicesApi#getIoDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, location, originalLocation, connected, schedules, accessids]

### Return type

[**Device**](Device.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getIoDeviceChannels"></a>
# **getIoDeviceChannels**
> Channel getIoDeviceChannels(id, include)

Get Channels that belong to IO Deice

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IoDevicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

IoDevicesApi apiInstance = new IoDevicesApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Channel result = apiInstance.getIoDeviceChannels(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IoDevicesApi#getIoDeviceChannels");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: iodevice, location]

### Return type

[**Channel**](Channel.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getIoDevices"></a>
# **getIoDevices**
> List&lt;Device&gt; getIoDevices(include)

Get IO Devices

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IoDevicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

IoDevicesApi apiInstance = new IoDevicesApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<Device> result = apiInstance.getIoDevices(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IoDevicesApi#getIoDevices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, location, originalLocation, connected, schedules]

### Return type

[**List&lt;Device&gt;**](Device.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateIoDevice"></a>
# **updateIoDevice**
> Device updateIoDevice(id, body)

Update IO Device

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IoDevicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

IoDevicesApi apiInstance = new IoDevicesApi();
Integer id = 56; // Integer | 
IODeviceUpdateRequest body = new IODeviceUpdateRequest(); // IODeviceUpdateRequest | 
try {
    Device result = apiInstance.updateIoDevice(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IoDevicesApi#updateIoDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**IODeviceUpdateRequest**](IODeviceUpdateRequest.md)|  |

### Return type

[**Device**](Device.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

