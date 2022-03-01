package io.github.springroe.intellij.salesforce.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewEntityModel {

    /**
     * SalesforceEntityModel
     */
    private SalesforceEntityModel entityModel;

    /**
     * 类名Object
     */
    private List<SalesforceEntityPropertyModel> propertyModels;

    /**
     * 创建java类所在的包
     */
    private String selectedPackage;

}
