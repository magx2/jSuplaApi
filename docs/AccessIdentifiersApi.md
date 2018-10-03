# AccessIdentifiersApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAccessIdentifier**](AccessIdentifiersApi.md#createAccessIdentifier) | **POST** /accessids | Create a new Access Identifier
[**deleteAccessIdentifier**](AccessIdentifiersApi.md#deleteAccessIdentifier) | **DELETE** /accessids/{id} | Delete Access Identifier
[**getAccessIdentifier**](AccessIdentifiersApi.md#getAccessIdentifier) | **GET** /accessids/{id} | Get Access Identifier
[**getAccessIdentifiers**](AccessIdentifiersApi.md#getAccessIdentifiers) | **GET** /accessids | Get Access Identifiers list
[**updateAccessIdentifier**](AccessIdentifiersApi.md#updateAccessIdentifier) | **PUT** /accessids/{id} | Update Access Identifier


<a name="createAccessIdentifier"></a>
# **createAccessIdentifier**
> AccessIdentifier createAccessIdentifier()

Create a new Access Identifier

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AccessIdentifiersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
try {
    AccessIdentifier result = apiInstance.createAccessIdentifier();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessIdentifiersApi#createAccessIdentifier");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AccessIdentifier**](AccessIdentifier.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccessIdentifier"></a>
# **deleteAccessIdentifier**
> deleteAccessIdentifier(id)

Delete Access Identifier

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AccessIdentifiersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
Integer id = 56; // Integer | 
try {
    apiInstance.deleteAccessIdentifier(id);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessIdentifiersApi#deleteAccessIdentifier");
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

<a name="getAccessIdentifier"></a>
# **getAccessIdentifier**
> AccessIdentifier getAccessIdentifier(id, include)

Get Access Identifier

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AccessIdentifiersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    AccessIdentifier result = apiInstance.getAccessIdentifier(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessIdentifiersApi#getAccessIdentifier");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: locations, clientApps, password]

### Return type

[**AccessIdentifier**](AccessIdentifier.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccessIdentifiers"></a>
# **getAccessIdentifiers**
> List&lt;AccessIdentifier&gt; getAccessIdentifiers(include)

Get Access Identifiers list

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AccessIdentifiersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<AccessIdentifier> result = apiInstance.getAccessIdentifiers(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessIdentifiersApi#getAccessIdentifiers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: locations, clientApps, password]

### Return type

[**List&lt;AccessIdentifier&gt;**](AccessIdentifier.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccessIdentifier"></a>
# **updateAccessIdentifier**
> AccessIdentifier updateAccessIdentifier(id, body)

Update Access Identifier

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AccessIdentifiersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

AccessIdentifiersApi apiInstance = new AccessIdentifiersApi();
Integer id = 56; // Integer | 
AccessIdentifierUpdateRequest body = new AccessIdentifierUpdateRequest(); // AccessIdentifierUpdateRequest | 
try {
    AccessIdentifier result = apiInstance.updateAccessIdentifier(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessIdentifiersApi#updateAccessIdentifier");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**AccessIdentifierUpdateRequest**](AccessIdentifierUpdateRequest.md)|  |

### Return type

[**AccessIdentifier**](AccessIdentifier.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

