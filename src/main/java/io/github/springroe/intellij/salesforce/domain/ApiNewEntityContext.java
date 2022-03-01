package io.github.springroe.intellij.salesforce.domain;

import java.util.ArrayList;
import java.util.List;

public class ApiNewEntityContext {

    /**
     * SalesforceEntityModel
     */

    public static SalesforceEntityModel entityModel;

    /**
     * 类名Object
     */
    public static List<SalesforceEntityPropertyModel> propertyModels;

    /**
     * 创建java类所在的包
     */
    public static String selectedPackage;

    public static void clearAllSet() {
        entityModel = null;
        propertyModels = null;
        selectedPackage = null;
    }

    public static void setData(NewEntityModel model) {
        entityModel = model.getEntityModel();
        propertyModels = model.getPropertyModels();
    }

    public static NewEntityModel copyToApiNewEntityModel() {
        NewEntityModel model = new NewEntityModel();
        model.setEntityModel(entityModel);
        model.setPropertyModels(new ArrayList<>(propertyModels));
        model.setSelectedPackage(selectedPackage);
        return model;
    }

}
