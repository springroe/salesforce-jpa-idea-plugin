package io.github.springroe.intellij.salesforce.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesforceEntityModel {
    private String objectName = "";
    private String objectLabel = "";
    private String entityName = "";
    private String entityRemark = "";
    private String tableName = "";
}
