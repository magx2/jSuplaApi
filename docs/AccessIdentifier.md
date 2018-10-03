
# AccessIdentifier

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Access Identifier identifier |  [optional]
**caption** | **String** | Location caption |  [optional]
**enabled** | **Boolean** | &#x60;true&#x60; if the location is enabled, &#x60;false&#x60; otherwise |  [optional]
**locationsIds** | **List&lt;Integer&gt;** | array containing the location idenfifiers assigned to this access ID |  [optional]
**clientAppsIds** | **List&lt;Integer&gt;** | array containing the client apps idenfifiers assigned to this access ID |  [optional]
**locations** | [**List&lt;Location&gt;**](Location.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]
**clientApps** | [**List&lt;ClientApp&gt;**](ClientApp.md) | Returned only if requested by the &#x60;include&#x60; parameter. |  [optional]



