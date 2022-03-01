package io.github.springroe.intellij.salesforce.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesforceAuthModel {
    private String endpoint = "";
    private String clientId = "";
    private String clientSecret = "";
    private String username = "";
    private String password = "";
    private String token = "";
    private Boolean authenticated = false;
}
