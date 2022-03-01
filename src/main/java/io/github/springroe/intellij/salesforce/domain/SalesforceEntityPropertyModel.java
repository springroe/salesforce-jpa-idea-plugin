package io.github.springroe.intellij.salesforce.domain;

import io.github.springroe.intellij.salesforce.util.Tool;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.client.model.ObjectMetaDataFields;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SalesforceEntityPropertyModel {
    private String label;
    private String name;
    private String mappingName;
    private String type;
    private String mappingType;
    private int length;
    private int scale;
    private String description;

    public SalesforceEntityPropertyModel(String label, String name, String type, int length, int scale, String description) {
        this.label = label;
        this.name = name;
        this.type = type;
        this.length = length;
        this.scale = scale;
        this.description = description;
        this.mappingName = getJavaName();
        this.mappingType = getKotlinType();
    }

    public SalesforceEntityPropertyModel(ObjectMetaDataFields fields) {
        this(fields.getLabel(), fields.getName(), fields.getType(), fields.getLength(), fields.getScale(), fields.getInlineHelpText());
    }

    private static final List<String> keywords = new ArrayList<>();
    private static final Map<String, String> propertiesMap = new HashMap<>();
    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        keywords.add("id");
        keywords.add("type");
        keywords.add("createTime");
        keywords.add("lastModifiedTime");
        keywords.add("deleted");

        propertiesMap.put("Name", "sfName");
        propertiesMap.put("id__c", "sfOutId");

        typeMap.put("id", "String");
        typeMap.put("double", "Double");
        typeMap.put("currency", "Double");
        typeMap.put("string", "String");
        typeMap.put("boolean", "Boolean");
        typeMap.put("textarea", "String");
        typeMap.put("picklist", "String");
        typeMap.put("datetime", "Date");
        typeMap.put("url", "String");
    }

    public Object[] toArray() {
        return new Object[]{label, name, mappingName, type, mappingType, length, scale, description};
    }

    public void fromArray(Object[] array) {
        this.label = (String) array[0];
        this.name = (String) array[1];
        this.mappingName = (String) array[2];
        this.type = (String) array[3];
        this.mappingType = (String) array[4];
        this.length = (int) array[5];
        this.scale = (int) array[6];
        this.description = (String) array[7];
    }

    public String getJavaName() {
        if (propertiesMap.containsKey(name)) {
            return propertiesMap.get(name);
        }
        var formatName = name.replace("__c", "");
        formatName = formatName.substring(0, 1).toLowerCase() + formatName.substring(1);
        formatName = Tool.lineToHump(formatName);
        if (keywords.contains(formatName)) {
            formatName = "sf" + formatName.substring(0, 1).toUpperCase() + formatName.substring(1);
        }
        if ("reference" .equals(type)) {
            formatName = "sf" + formatName.substring(0, 1).toUpperCase() + formatName.substring(1);
            if (!formatName.endsWith("Id")) {
                formatName = formatName + "Id";
            }
        }
        return formatName;
    }

    public String getKotlinType() {
        String javaType = "String";
        if (typeMap.containsKey(type)) {
            javaType = typeMap.get(type);
            if (javaType.equals("Double") && scale == 0) {
                javaType = "Int";
            }
        }
        return javaType;
    }
}
