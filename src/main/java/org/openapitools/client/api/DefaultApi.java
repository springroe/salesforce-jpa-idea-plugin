/*
 * salesforce api
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
    private ApiClient localVarApiClient;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for servicesOauth2TokenPost
     * @param grantType  (required)
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param username  (required)
     * @param password  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesOauth2TokenPostCall(String grantType, String clientId, String clientSecret, String username, String password, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/services/oauth2/token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (grantType != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("grant_type", grantType));
        }

        if (clientId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("client_id", clientId));
        }

        if (clientSecret != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("client_secret", clientSecret));
        }

        if (username != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("username", username));
        }

        if (password != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("password", password));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call servicesOauth2TokenPostValidateBeforeCall(String grantType, String clientId, String clientSecret, String username, String password, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'grantType' is set
        if (grantType == null) {
            throw new ApiException("Missing the required parameter 'grantType' when calling servicesOauth2TokenPost(Async)");
        }
        
        // verify the required parameter 'clientId' is set
        if (clientId == null) {
            throw new ApiException("Missing the required parameter 'clientId' when calling servicesOauth2TokenPost(Async)");
        }
        
        // verify the required parameter 'clientSecret' is set
        if (clientSecret == null) {
            throw new ApiException("Missing the required parameter 'clientSecret' when calling servicesOauth2TokenPost(Async)");
        }
        
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling servicesOauth2TokenPost(Async)");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling servicesOauth2TokenPost(Async)");
        }
        

        okhttp3.Call localVarCall = servicesOauth2TokenPostCall(grantType, clientId, clientSecret, username, password, _callback);
        return localVarCall;

    }

    /**
     * 登录
     * 
     * @param grantType  (required)
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param username  (required)
     * @param password  (required)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public Object servicesOauth2TokenPost(String grantType, String clientId, String clientSecret, String username, String password) throws ApiException {
        ApiResponse<Object> localVarResp = servicesOauth2TokenPostWithHttpInfo(grantType, clientId, clientSecret, username, password);
        return localVarResp.getData();
    }

    /**
     * 登录
     * 
     * @param grantType  (required)
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param username  (required)
     * @param password  (required)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Object> servicesOauth2TokenPostWithHttpInfo(String grantType, String clientId, String clientSecret, String username, String password) throws ApiException {
        okhttp3.Call localVarCall = servicesOauth2TokenPostValidateBeforeCall(grantType, clientId, clientSecret, username, password, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * 登录 (asynchronously)
     * 
     * @param grantType  (required)
     * @param clientId  (required)
     * @param clientSecret  (required)
     * @param username  (required)
     * @param password  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesOauth2TokenPostAsync(String grantType, String clientId, String clientSecret, String username, String password, final ApiCallback<Object> _callback) throws ApiException {

        okhttp3.Call localVarCall = servicesOauth2TokenPostValidateBeforeCall(grantType, clientId, clientSecret, username, password, _callback);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
