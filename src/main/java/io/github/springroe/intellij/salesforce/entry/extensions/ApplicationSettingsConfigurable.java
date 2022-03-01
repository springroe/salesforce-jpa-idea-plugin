package io.github.springroe.intellij.salesforce.entry.extensions;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import io.github.springroe.intellij.salesforce.domain.SalesforceAuthModel;
import io.github.springroe.intellij.salesforce.state.SalesforceAuthModelService;
import io.github.springroe.intellij.salesforce.ui.ApplicationSettingForm;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApplicationSettingsConfigurable implements Configurable {

    ApplicationSettingForm form = new ApplicationSettingForm();
    SalesforceAuthModelService service = SalesforceAuthModelService.getInstance();

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Salesforce";
    }

    @Override
    public @Nullable JComponent createComponent() {
        form.setData(getState());
        return form.getPanel();
    }

    @Override
    public boolean isModified() {
        return form.isModified(SalesforceAuthModelService.getInstance().getState());
    }

    @Override
    public void apply() {
        var state = getState();
        form.getData(state);
        SalesforceAuthModelService.getInstance().loadState(state);
    }

    public SalesforceAuthModel getState() {
        return service.getState();
    }

    @Override
    public void reset() {
        Configurable.super.reset();
        form.setData(getState());
    }
}
