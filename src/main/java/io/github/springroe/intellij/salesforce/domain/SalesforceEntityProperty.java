package io.github.springroe.intellij.salesforce.domain;

import io.github.springroe.intellij.salesforce.util.Tool;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesforceEntityProperty {

    private String name;
    private String type;
    private String label;
    private String description;
    private int length = 0;
    private int precision = 0;

    private static final List<String> keywords = new ArrayList<>() {{
        add("id");
        add("type");
        add("createTime");
        add("lastModifiedTime");
        add("deleted");
    }};
    private static final Map<String, String> propertiesMap = new HashMap<>() {{
        put("Name", "sfCode");
    }};


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (type.startsWith("查找(")) {
            formatName = "sf" + formatName.substring(0, 1).toUpperCase() + formatName.substring(1);
            if (!formatName.endsWith("Id")) {
                formatName = formatName + "Id";
            }
        }
        return formatName;
    }

    public String getJavaType() {
        if (type.startsWith("选项列表")) {
            return "String";
        } else if (type.startsWith("数字")) {
            var precisionStr = StringUtils.substringAfter(type, ",");
            precisionStr = StringUtils.substringBefore(precisionStr, ")").trim();
            precision = Integer.parseInt(precisionStr);
            if (precision > 0) {
                return "Double";
            } else {
                return "Int";
            }
        } else if (type.startsWith("日期/时间")) {
            return "Date";
        } else {
            return "String";
        }
    }

    public SalesforceEntityPropertyModel toModel() {
        return new SalesforceEntityPropertyModel(label, name, getJavaName(), type, getJavaType(), length, precision, description);
    }
}
