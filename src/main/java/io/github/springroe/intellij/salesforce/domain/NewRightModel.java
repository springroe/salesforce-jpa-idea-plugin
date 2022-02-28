package io.github.springroe.intellij.salesforce.domain;

import java.util.List;

public class NewRightModel {

    /**
     * 类名
     */
    private String className;

    /**
     * 类名Object
     */
    private String classObjectName;


    /**
     * 类名Object
     */
    private String tableName;

    /**
     * 类说明
     */
    private String classDescription;
    /**
     * 所选择的类的类型
     */
    private String classType;

    /**
     * 创建java类所在的包
     */
    private String selectedPackage;

    /**
     * 类成员
     */
    private List<SalesforceEntityProperty> propertyList;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassObjectName() {
        return classObjectName;
    }

    public void setClassObjectName(String classObjectName) {
        this.classObjectName = classObjectName;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSelectedPackage() {
        return selectedPackage;
    }

    public void setSelectedPackage(String selectedPackage) {
        this.selectedPackage = selectedPackage;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public List<SalesforceEntityProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<SalesforceEntityProperty> propertyList) {
        this.propertyList = propertyList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
