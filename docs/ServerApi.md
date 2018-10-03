# ServerApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getServerInfo**](ServerApi.md#getServerInfo) | **GET** /server-info | Get server info
[**getSuplaServerStatus**](ServerApi.md#getSuplaServerStatus) | **GET** /server-status | Get the SUPLA Server status


<a name="getServerInfo"></a>
# **getServerInfo**
> ERRORUNKNOWN getServerInfo()

Get server info

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServerApi;


ServerApi apiInstance = new ServerApi();
try {
    ERRORUNKNOWN result = apiInstance.getServerInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerApi#getServerInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ERRORUNKNOWN**](ERRORUNKNOWN.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSuplaServerStatus"></a>
# **getSuplaServerStatus**
> getSuplaServerStatus()

Get the SUPLA Server status

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServerApi;


ServerApi apiInstance = new ServerApi();
try {
    apiInstance.getSuplaServerStatus();
} catch (ApiException e) {
    System.err.println("Exception when calling ServerApi#getSuplaServerStatus");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

