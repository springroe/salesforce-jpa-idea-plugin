package io.github.springroe.intellij.salesforce.ui;

import io.github.springroe.intellij.salesforce.domain.SalesforceAuthModel;
import lombok.Getter;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class ApplicationSettingForm {
    @Getter
    private JPanel panel;
    private JTextField txtEndpoint;
    private JTextField txtClientId;
    private JTextField txtClientSecret;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField textToken;
    private JButton btnLogin;
    private boolean authenticated = false;


    public ApplicationSettingForm() {
        btnLogin.addActionListener(this::btnLoginHandle);
    }

    private void btnLoginHandle(ActionEvent e) {
        if (authenticated) {
            handleLogoff();
        } else {
            handleLogin();
        }
        refreshBtnLoginState();
    }

    private void handleLogin() {
        var data = new SalesforceAuthModel();
        this.getData(data);
        if (data.getEndpoint().isEmpty()) {
            return;
        }
        var client = Configuration.getDefaultApiClient();
        client.setBasePath(data.getEndpoint());
        var api = new DefaultApi();
        try {
            var result = (Map<String, String>) api.servicesOauth2TokenPost("password", data.getClientId(), data.getClientSecret(), data.getUsername(), data.getPassword());
            var token = result.get("access_token");
            JOptionPane.showMessageDialog(null, "登录成功");
            textToken.setText(token);
            authenticated = true;
        } catch (ApiException e) {
            JOptionPane.showMessageDialog(null, "登录错误" + e.getResponseBody());
            e.printStackTrace();
        }
    }

    private void handleLogoff() {
        textToken.setText("");
        authenticated = false;
        JOptionPane.showMessageDialog(null, "注销成功");
    }

    private void refreshBtnLoginState() {
        btnLogin.setText(authenticated ? "注销" : "登录");
    }

    public void setData(SalesforceAuthModel data) {
        txtEndpoint.setText(data.getEndpoint());
        txtClientSecret.setText(data.getClientSecret());
        txtUsername.setText(data.getUsername());
        txtPassword.setText(data.getPassword());
        textToken.setText(data.getToken());
        txtClientId.setText(data.getClientId());
        authenticated = data.getAuthenticated();
        refreshBtnLoginState();
    }

    public void getData(SalesforceAuthModel data) {
        data.setEndpoint(txtEndpoint.getText());
        data.setClientSecret(txtClientSecret.getText());
        data.setUsername(txtUsername.getText());
        data.setPassword(txtPassword.getText());
        data.setToken(textToken.getText());
        data.setClientId(txtClientId.getText());
        data.setAuthenticated(authenticated);
    }

    public boolean isModified(SalesforceAuthModel data) {
        if (txtEndpoint.getText() != null ? !txtEndpoint.getText().equals(data.getEndpoint()) : data.getEndpoint() != null)
            return true;
        if (txtClientSecret.getText() != null ? !txtClientSecret.getText().equals(data.getClientSecret()) : data.getClientSecret() != null)
            return true;
        if (txtUsername.getText() != null ? !txtUsername.getText().equals(data.getUsername()) : data.getUsername() != null)
            return true;
        if (txtPassword.getText() != null ? !txtPassword.getText().equals(data.getPassword()) : data.getPassword() != null)
            return true;
        if (textToken.getText() != null ? !textToken.getText().equals(data.getToken()) : data.getToken() != null)
            return true;
        if (txtClientId.getText() != null ? !txtClientId.getText().equals(data.getClientId()) : data.getClientId() != null)
            return true;
        return false;
    }
}
