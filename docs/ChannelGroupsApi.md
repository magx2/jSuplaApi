# ChannelGroupsApi

All URIs are relative to *https://cloud.supla.org/api/v2.2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createChannelGroup**](ChannelGroupsApi.md#createChannelGroup) | **POST** /channel-groups | Create a new channel group
[**deleteChannelGroup**](ChannelGroupsApi.md#deleteChannelGroup) | **DELETE** /channel-groups/{id} | Delete Channel Group
[**executeChannelGroupAction**](ChannelGroupsApi.md#executeChannelGroupAction) | **PATCH** /channel-groups/{id} | Execute action on the channel group
[**getChannelGroup**](ChannelGroupsApi.md#getChannelGroup) | **GET** /channel-groups/{id} | Get channel group by ID
[**getChannelGroups**](ChannelGroupsApi.md#getChannelGroups) | **GET** /channel-groups | Get channels list
[**updateChannelGroup**](ChannelGroupsApi.md#updateChannelGroup) | **PUT** /channel-groups/{id} | Update channel group


<a name="createChannelGroup"></a>
# **createChannelGroup**
> ChannelGroup createChannelGroup(body)

Create a new channel group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
ChannelGroupRequest body = new ChannelGroupRequest(); // ChannelGroupRequest | 
try {
    ChannelGroup result = apiInstance.createChannelGroup(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#createChannelGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ChannelGroupRequest**](ChannelGroupRequest.md)|  |

### Return type

[**ChannelGroup**](ChannelGroup.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteChannelGroup"></a>
# **deleteChannelGroup**
> deleteChannelGroup(id)

Delete Channel Group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
Integer id = 56; // Integer | 
try {
    apiInstance.deleteChannelGroup(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#deleteChannelGroup");
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

<a name="executeChannelGroupAction"></a>
# **executeChannelGroupAction**
> executeChannelGroupAction(id, body)

Execute action on the channel group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
Integer id = 56; // Integer | 
ChannelExecuteActionRequest body = new ChannelExecuteActionRequest(); // ChannelExecuteActionRequest | Defines an action to execute on channel group. The `action` key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions).
try {
    apiInstance.executeChannelGroupAction(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#executeChannelGroupAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ChannelExecuteActionRequest**](ChannelExecuteActionRequest.md)| Defines an action to execute on channel group. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). |

### Return type

null (empty response body)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannelGroup"></a>
# **getChannelGroup**
> ChannelGroup getChannelGroup(id, include)

Get channel group by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
Integer id = 56; // Integer | 
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    ChannelGroup result = apiInstance.getChannelGroup(id, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#getChannelGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels, iodevice, location]

### Return type

[**ChannelGroup**](ChannelGroup.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChannelGroups"></a>
# **getChannelGroups**
> List&lt;ChannelGroup&gt; getChannelGroups(include)

Get channels list

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
List<String> include = Arrays.asList("include_example"); // List<String> | Specify what extra fields to include in the response.
try {
    List<ChannelGroup> result = apiInstance.getChannelGroups(include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#getChannelGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | [**List&lt;String&gt;**](String.md)| Specify what extra fields to include in the response. | [optional] [enum: channels]

### Return type

[**List&lt;ChannelGroup&gt;**](ChannelGroup.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChannelGroup"></a>
# **updateChannelGroup**
> ChannelGroup updateChannelGroup(id, body)

Update channel group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ChannelGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: password
OAuth password = (OAuth) defaultClient.getAuthentication("password");
password.setAccessToken("YOUR ACCESS TOKEN");

ChannelGroupsApi apiInstance = new ChannelGroupsApi();
Integer id = 56; // Integer | 
ChannelGroupRequest body = new ChannelGroupRequest(); // ChannelGroupRequest | 
try {
    ChannelGroup result = apiInstance.updateChannelGroup(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChannelGroupsApi#updateChannelGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |
 **body** | [**ChannelGroupRequest**](ChannelGroupRequest.md)|  |

### Return type

[**ChannelGroup**](ChannelGroup.md)

### Authorization

[password](../README.md#password)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

