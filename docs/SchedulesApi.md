# SchedulesApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSchedule**](SchedulesApi.md#createSchedule) | **POST** /schedules | Create a new schedule
[**deleteSchedule**](SchedulesApi.md#deleteSchedule) | **DELETE** /schedules/{id} | Delete Schedule
[**enableSchedules**](SchedulesApi.md#enableSchedules) | **PATCH** /schedules | Enable schedules
[**getSchedule**](SchedulesApi.md#getSchedule) | **GET** /schedules/{id} | Get Schedule
[**getSchedules**](SchedulesApi.md#getSchedules) | **GET** /schedules | Get schedules list
[**updateSchedule**](SchedulesApi.md#updateSchedule) | **PUT** /schedules/{id} | Update schedule


<a name="createSchedule"></a>
# **createSchedule**
> Schedule createSchedule(body)

Create a new schedule

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
ScheduleRequest body = new ScheduleRequest(); // ScheduleRequest | 
try {
    Schedule result = apiInstance.createSchedule(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#createSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ScheduleRequest**](ScheduleRequest.md)|  |

### Return type

[**Schedule**](Schedule.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSchedule"></a>
# **deleteSchedule**
> deleteSchedule(id)

Delete Schedule

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
Integer id = 56; // Integer | 
try {
    apiInstance.deleteSchedule(id);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#deleteSchedule");
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

<a name="enableSchedules"></a>
# **enableSchedules**
> enableSchedules(body)

Enable schedules

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
SchedulesEnableRequest body = new SchedulesEnableRequest(); // SchedulesEnableRequest | 
try {
    apiInstance.enableSchedules(body);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#enableSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SchedulesEnableRequest**](SchedulesEnableRequest.md)|  |

### Return type

null (empty response body)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSchedule"></a>
# **getSchedule**
> Schedule getSchedule(id, include)

Get Schedule

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Schedule result = apiInstance.getSchedule(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channel, iodevice, location, closestExecutions]

### Return type

[**Schedule**](Schedule.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSchedules"></a>
# **getSchedules**
> List&lt;Schedule&gt; getSchedules(include)

Get schedules list

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<Schedule> result = apiInstance.getSchedules(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channel, iodevice, location, closestExecutions]

### Return type

[**List&lt;Schedule&gt;**](Schedule.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSchedule"></a>
# **updateSchedule**
> Schedule updateSchedule(id, body, enable)

Update schedule

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SchedulesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

SchedulesApi apiInstance = new SchedulesApi();
Integer id = 56; // Integer | 
ScheduleRequest body = new ScheduleRequest(); // ScheduleRequest | 
Boolean enable = true; // Boolean | Set to `true` to enable the schedule after saving.
try {
    Schedule result = apiInstance.updateSchedule(id, body, enable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#updateSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ScheduleRequest**](ScheduleRequest.md)|  |
 **enable** | **Boolean**| Set to &#x60;true&#x60; to enable the schedule after saving. | [optional]

### Return type

[**Schedule**](Schedule.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

