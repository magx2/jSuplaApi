# LocationsApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createLocation**](LocationsApi.md#createLocation) | **POST** /locations | Create a new location
[**deleteLocation**](LocationsApi.md#deleteLocation) | **DELETE** /locations/{id} | Delete location
[**getLocation**](LocationsApi.md#getLocation) | **GET** /locations/{id} | Get location by ID
[**getLocations**](LocationsApi.md#getLocations) | **GET** /locations | Get locations list
[**updateLocation**](LocationsApi.md#updateLocation) | **PUT** /locations/{id} | Update location


<a name="createLocation"></a>
# **createLocation**
> Location createLocation()

Create a new location

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

LocationsApi apiInstance = new LocationsApi();
try {
    Location result = apiInstance.createLocation();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#createLocation");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Location**](Location.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteLocation"></a>
# **deleteLocation**
> deleteLocation(id, include)

Delete location

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

LocationsApi apiInstance = new LocationsApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    apiInstance.deleteLocation(id, include);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#deleteLocation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, iodevices, accessids, channelGroups, password]

### Return type

null (empty response body)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLocation"></a>
# **getLocation**
> Location getLocation(id, include)

Get location by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

LocationsApi apiInstance = new LocationsApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Location result = apiInstance.getLocation(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getLocation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, iodevices, accessids, channelGroups, password]

### Return type

[**Location**](Location.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLocations"></a>
# **getLocations**
> List&lt;Location&gt; getLocations(include)

Get locations list

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

LocationsApi apiInstance = new LocationsApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<Location> result = apiInstance.getLocations(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getLocations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, iodevices, accessids, channelGroups, password]

### Return type

[**List&lt;Location&gt;**](Location.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateLocation"></a>
# **updateLocation**
> Location updateLocation(id, body, include)

Update location

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

LocationsApi apiInstance = new LocationsApi();
Integer id = 56; // Integer | 
LocationUpdateRequest body = new LocationUpdateRequest(); // LocationUpdateRequest | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    Location result = apiInstance.updateLocation(id, body, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#updateLocation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**LocationUpdateRequest**](LocationUpdateRequest.md)|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, iodevices, accessids, channelGroups, password]

### Return type

[**Location**](Location.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

