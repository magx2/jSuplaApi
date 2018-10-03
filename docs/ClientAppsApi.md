# ClientAppsApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteClientApp**](ClientAppsApi.md#deleteClientApp) | **DELETE** /client-apps/{id} | Delete Client App
[**getClientApps**](ClientAppsApi.md#getClientApps) | **GET** /client-apps | Get client apps
[**updateClientApp**](ClientAppsApi.md#updateClientApp) | **PUT** /client-apps/{id} | Update client app


<a name="deleteClientApp"></a>
# **deleteClientApp**
> deleteClientApp(id)

Delete Client App

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ClientAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ClientAppsApi apiInstance = new ClientAppsApi();
Integer id = 56; // Integer | 
try {
    apiInstance.deleteClientApp(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientAppsApi#deleteClientApp");
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

<a name="getClientApps"></a>
# **getClientApps**
> List&lt;ClientApp&gt; getClientApps(include)

Get client apps

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ClientAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ClientAppsApi apiInstance = new ClientAppsApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<ClientApp> result = apiInstance.getClientApps(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientAppsApi#getClientApps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: accessId, connected]

### Return type

[**List&lt;ClientApp&gt;**](ClientApp.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateClientApp"></a>
# **updateClientApp**
> ClientApp updateClientApp(id, body)

Update client app

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ClientAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ClientAppsApi apiInstance = new ClientAppsApi();
Integer id = 56; // Integer | 
ClientAppUpdateRequest body = new ClientAppUpdateRequest(); // ClientAppUpdateRequest | 
try {
    ClientApp result = apiInstance.updateClientApp(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientAppsApi#updateClientApp");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ClientAppUpdateRequest**](ClientAppUpdateRequest.md)|  |

### Return type

[**ClientApp**](ClientApp.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

