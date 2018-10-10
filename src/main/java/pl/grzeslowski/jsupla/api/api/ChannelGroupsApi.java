/*
 * SUPLA Cloud API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package pl.grzeslowski.jsupla.api.api;

import pl.grzeslowski.jsupla.api.ApiCallback;
import pl.grzeslowski.jsupla.api.ApiClient;
import pl.grzeslowski.jsupla.api.ApiException;
import pl.grzeslowski.jsupla.api.ApiResponse;
import pl.grzeslowski.jsupla.api.Configuration;
import pl.grzeslowski.jsupla.api.Pair;
import pl.grzeslowski.jsupla.api.ProgressRequestBody;
import pl.grzeslowski.jsupla.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import pl.grzeslowski.jsupla.api.model.ChannelExecuteActionRequest;
import pl.grzeslowski.jsupla.api.model.ChannelGroup;
import pl.grzeslowski.jsupla.api.model.ChannelGroupRequest;
import pl.grzeslowski.jsupla.api.model.ERRORUNKNOWN;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelGroupsApi {
    private ApiClient apiClient;

    public ChannelGroupsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ChannelGroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createChannelGroup
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createChannelGroupCall(ChannelGroupRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/channel-groups";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createChannelGroupValidateBeforeCall(ChannelGroupRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling createChannelGroup(Async)");
        }
        

        com.squareup.okhttp.Call call = createChannelGroupCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new channel group
     * 
     * @param body  (required)
     * @return ChannelGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChannelGroup createChannelGroup(ChannelGroupRequest body) throws ApiException {
        ApiResponse<ChannelGroup> resp = createChannelGroupWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a new channel group
     * 
     * @param body  (required)
     * @return ApiResponse&lt;ChannelGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChannelGroup> createChannelGroupWithHttpInfo(ChannelGroupRequest body) throws ApiException {
        com.squareup.okhttp.Call call = createChannelGroupValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new channel group (asynchronously)
     * 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createChannelGroupAsync(ChannelGroupRequest body, final ApiCallback<ChannelGroup> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createChannelGroupValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteChannelGroup
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteChannelGroupCall(Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/channel-groups/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteChannelGroupValidateBeforeCall(Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteChannelGroup(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteChannelGroupCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete Channel Group
     * 
     * @param id  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteChannelGroup(Integer id) throws ApiException {
        deleteChannelGroupWithHttpInfo(id);
    }

    /**
     * Delete Channel Group
     * 
     * @param id  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteChannelGroupWithHttpInfo(Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteChannelGroupValidateBeforeCall(id, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete Channel Group (asynchronously)
     * 
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteChannelGroupAsync(Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteChannelGroupValidateBeforeCall(id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for executeChannelGroupAction
     * @param id  (required)
     * @param body Defines an action to execute on channel group. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call executeChannelGroupActionCall(Integer id, ChannelExecuteActionRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/channel-groups/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call executeChannelGroupActionValidateBeforeCall(Integer id, ChannelExecuteActionRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling executeChannelGroupAction(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling executeChannelGroupAction(Async)");
        }
        

        com.squareup.okhttp.Call call = executeChannelGroupActionCall(id, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Execute action on the channel group
     * 
     * @param id  (required)
     * @param body Defines an action to execute on channel group. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void executeChannelGroupAction(Integer id, ChannelExecuteActionRequest body) throws ApiException {
        executeChannelGroupActionWithHttpInfo(id, body);
    }

    /**
     * Execute action on the channel group
     * 
     * @param id  (required)
     * @param body Defines an action to execute on channel group. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> executeChannelGroupActionWithHttpInfo(Integer id, ChannelExecuteActionRequest body) throws ApiException {
        com.squareup.okhttp.Call call = executeChannelGroupActionValidateBeforeCall(id, body, null, null);
        return apiClient.execute(call);
    }

    /**
     * Execute action on the channel group (asynchronously)
     * 
     * @param id  (required)
     * @param body Defines an action to execute on channel group. The &#x60;action&#x60; key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call executeChannelGroupActionAsync(Integer id, ChannelExecuteActionRequest body, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = executeChannelGroupActionValidateBeforeCall(id, body, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getChannelGroup
     * @param id  (required)
     * @param include Specify what extra fields to include in the response. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getChannelGroupCall(Integer id, List<String> include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/channel-groups/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (include != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "include", include));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getChannelGroupValidateBeforeCall(Integer id, List<String> include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getChannelGroup(Async)");
        }
        

        com.squareup.okhttp.Call call = getChannelGroupCall(id, include, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get channel group by ID
     * 
     * @param id  (required)
     * @param include Specify what extra fields to include in the response. (optional)
     * @return ChannelGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChannelGroup getChannelGroup(Integer id, List<String> include) throws ApiException {
        ApiResponse<ChannelGroup> resp = getChannelGroupWithHttpInfo(id, include);
        return resp.getData();
    }

    /**
     * Get channel group by ID
     * 
     * @param id  (required)
     * @param include Specify what extra fields to include in the response. (optional)
     * @return ApiResponse&lt;ChannelGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChannelGroup> getChannelGroupWithHttpInfo(Integer id, List<String> include) throws ApiException {
        com.squareup.okhttp.Call call = getChannelGroupValidateBeforeCall(id, include, null, null);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get channel group by ID (asynchronously)
     * 
     * @param id  (required)
     * @param include Specify what extra fields to include in the response. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getChannelGroupAsync(Integer id, List<String> include, final ApiCallback<ChannelGroup> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getChannelGroupValidateBeforeCall(id, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getChannelGroups
     * @param include Specify what extra fields to include in the response. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getChannelGroupsCall(List<String> include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/channel-groups";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (include != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "include", include));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getChannelGroupsValidateBeforeCall(List<String> include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getChannelGroupsCall(include, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get channels list
     * 
     * @param include Specify what extra fields to include in the response. (optional)
     * @return List&lt;ChannelGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ChannelGroup> getChannelGroups(List<String> include) throws ApiException {
        ApiResponse<List<ChannelGroup>> resp = getChannelGroupsWithHttpInfo(include);
        return resp.getData();
    }

    /**
     * Get channels list
     * 
     * @param include Specify what extra fields to include in the response. (optional)
     * @return ApiResponse&lt;List&lt;ChannelGroup&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ChannelGroup>> getChannelGroupsWithHttpInfo(List<String> include) throws ApiException {
        com.squareup.okhttp.Call call = getChannelGroupsValidateBeforeCall(include, null, null);
        Type localVarReturnType = new TypeToken<List<ChannelGroup>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get channels list (asynchronously)
     * 
     * @param include Specify what extra fields to include in the response. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getChannelGroupsAsync(List<String> include, final ApiCallback<List<ChannelGroup>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getChannelGroupsValidateBeforeCall(include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ChannelGroup>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateChannelGroup
     * @param id  (required)
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateChannelGroupCall(Integer id, ChannelGroupRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/channel-groups/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "password" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateChannelGroupValidateBeforeCall(Integer id, ChannelGroupRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateChannelGroup(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateChannelGroup(Async)");
        }
        

        com.squareup.okhttp.Call call = updateChannelGroupCall(id, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update channel group
     * 
     * @param id  (required)
     * @param body  (required)
     * @return ChannelGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChannelGroup updateChannelGroup(Integer id, ChannelGroupRequest body) throws ApiException {
        ApiResponse<ChannelGroup> resp = updateChannelGroupWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Update channel group
     * 
     * @param id  (required)
     * @param body  (required)
     * @return ApiResponse&lt;ChannelGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChannelGroup> updateChannelGroupWithHttpInfo(Integer id, ChannelGroupRequest body) throws ApiException {
        com.squareup.okhttp.Call call = updateChannelGroupValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update channel group (asynchronously)
     * 
     * @param id  (required)
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateChannelGroupAsync(Integer id, ChannelGroupRequest body, final ApiCallback<ChannelGroup> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateChannelGroupValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChannelGroup>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}