package io.github.springroe.intellij.salesforce.state;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import io.github.springroe.intellij.salesforce.domain.SalesforceAuthModel;
import org.jetbrains.annotations.NotNull;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.api.ObjectApi;
import org.openapitools.client.model.ObjectInfo;
import org.openapitools.client.model.ObjectInfoSobjects;
import org.openapitools.client.model.ObjectMetaData;

import java.util.List;

@Service
@State(name = "SalesforceAuthSetting", storages = {@Storage("$APP_CONFIG$/salesforceAuthSetting.xml")})
public final class SalesforceAuthModelService implements PersistentStateComponent<SalesforceAuthModel> {

    static final ApiClient client = Configuration.getDefaultApiClient();
    static final DefaultApi defaultApi = new DefaultApi();
    static final ObjectApi objectApi = new ObjectApi();

    public static SalesforceAuthModelService getInstance() {
        var service = ApplicationManager.getApplication().getService(SalesforceAuthModelService.class);
        var data = service.getState();
        client.setBasePath(data.getEndpoint());
        if (!data.getToken().isBlank()) client.addDefaultHeader("Authorization", "Bearer " + data.getToken());
        return service;
    }

    private SalesforceAuthModel state = new SalesforceAuthModel();

    @Override
    public @NotNull SalesforceAuthModel getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull SalesforceAuthModel state) {
        this.state = state;
    }

    public List<ObjectInfoSobjects> loadObjects() throws ApiException {
        try {
            ObjectInfo result = objectApi.servicesDataV540SobjectsGet();
            return result.getSobjects();
        } catch (ApiException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ObjectMetaData loadObjectMetadata(String object) throws ApiException {
        try {
            return objectApi.servicesDataV510SobjectsObjectDescribeGet(object);
        } catch (ApiException e) {
            e.printStackTrace();
            throw e;
        }
    }
}