package io.github.springroe.intellij.salesforce.domain;

import io.github.springroe.intellij.salesforce.util.Tool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewRightContext {

    /**
     * 类名
     */
    private static String className;

    /**
     * 类名Object
     */
    private static String classObjectName;

    /**
     * 类说明
     */
    private static String classDescription;

    /**
     * 所选择的类的类型
     */
    private static String classType;

    /**
     * 创建java类所在的包
     */
    private static String selectedPackage;


    /**
     * 创建java类所在的包
     */
    private static String dataText;

    private static List<SalesforceEntityProperty> propertyList;


    public static String getClassType() {
        return classType;
    }

    public static void setClassType(String classType) {
        NewRightContext.classType = classType;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        NewRightContext.className = className;
    }

    public static String getClassObjectName() {
        return classObjectName;
    }

    public static void setClassObjectName(String classObjectName) {
        NewRightContext.classObjectName = classObjectName;
    }

    public static String getClassDescription() {
        return classDescription;
    }

    public static void setClassDescription(String classDescription) {
        NewRightContext.classDescription = classDescription;
    }

    public static String getSelectedPackage() {
        return selectedPackage;
    }

    public static void setSelectedPackage(String selectedPackage) {
        NewRightContext.selectedPackage = selectedPackage;
    }

    public static String getDataText() {
        return dataText;
    }

    public static void setDataText(String dataText) {
        NewRightContext.dataText = dataText;
        var lines = dataText.split("\\n");
        propertyList = Arrays.stream(lines).map((String line) -> {
            var cells = line.split("\\t");
            var property = new SalesforceEntityProperty();
            property.setLabel(cells[0]);
            property.setName(cells[1]);
            property.setType(cells[2]);
            return property;
        }).collect(Collectors.toList());
    }

    public static List<SalesforceEntityProperty> getPropertyList() {
        return propertyList;
    }

    public static void clearAllSet() {
        classType = null;
        className = null;
        selectedPackage = null;
        dataText = null;
    }

    public static NewRightModel copyToNewRightModel() {
        NewRightModel newRightModel = new NewRightModel();
        newRightModel.setClassName(className);
        newRightModel.setClassDescription(classDescription);
        newRightModel.setClassType(classType);
        newRightModel.setSelectedPackage(selectedPackage);
        newRightModel.setPropertyList(propertyList);
        newRightModel.setClassObjectName(classObjectName);
        newRightModel.setTableName("sf" + Tool.humpToLine(className));
        return newRightModel;
    }

}
