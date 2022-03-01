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


import org.openapitools.client.model.ObjectInfo;
import org.openapitools.client.model.ObjectMetaData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectApi {
    private ApiClient localVarApiClient;

    public ObjectApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ObjectApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for servicesDataV510SobjectsObjectDescribeGet
     * @param _object  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesDataV510SobjectsObjectDescribeGetCall(String _object, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/services/data/v51.0/sobjects/{object}/describe/"
            .replaceAll("\\{" + "object" + "\\}", localVarApiClient.escapeString(_object.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call servicesDataV510SobjectsObjectDescribeGetValidateBeforeCall(String _object, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter '_object' is set
        if (_object == null) {
            throw new ApiException("Missing the required parameter '_object' when calling servicesDataV510SobjectsObjectDescribeGet(Async)");
        }
        

        okhttp3.Call localVarCall = servicesDataV510SobjectsObjectDescribeGetCall(_object, _callback);
        return localVarCall;

    }

    /**
     * Object Metadata
     * 
     * @param _object  (required)
     * @return ObjectMetaData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public ObjectMetaData servicesDataV510SobjectsObjectDescribeGet(String _object) throws ApiException {
        ApiResponse<ObjectMetaData> localVarResp = servicesDataV510SobjectsObjectDescribeGetWithHttpInfo(_object);
        return localVarResp.getData();
    }

    /**
     * Object Metadata
     * 
     * @param _object  (required)
     * @return ApiResponse&lt;ObjectMetaData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ObjectMetaData> servicesDataV510SobjectsObjectDescribeGetWithHttpInfo(String _object) throws ApiException {
        okhttp3.Call localVarCall = servicesDataV510SobjectsObjectDescribeGetValidateBeforeCall(_object, null);
        Type localVarReturnType = new TypeToken<ObjectMetaData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Object Metadata (asynchronously)
     * 
     * @param _object  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesDataV510SobjectsObjectDescribeGetAsync(String _object, final ApiCallback<ObjectMetaData> _callback) throws ApiException {

        okhttp3.Call localVarCall = servicesDataV510SobjectsObjectDescribeGetValidateBeforeCall(_object, _callback);
        Type localVarReturnType = new TypeToken<ObjectMetaData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for servicesDataV540SobjectsGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesDataV540SobjectsGetCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/services/data/v54.0/sobjects/";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call servicesDataV540SobjectsGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = servicesDataV540SobjectsGetCall(_callback);
        return localVarCall;

    }

    /**
     * Get a List of Objects
     * 
     * @return ObjectInfo
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public ObjectInfo servicesDataV540SobjectsGet() throws ApiException {
        ApiResponse<ObjectInfo> localVarResp = servicesDataV540SobjectsGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get a List of Objects
     * 
     * @return ApiResponse&lt;ObjectInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ObjectInfo> servicesDataV540SobjectsGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = servicesDataV540SobjectsGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ObjectInfo>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a List of Objects (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> 成功 </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call servicesDataV540SobjectsGetAsync(final ApiCallback<ObjectInfo> _callback) throws ApiException {

        okhttp3.Call localVarCall = servicesDataV540SobjectsGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ObjectInfo>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}