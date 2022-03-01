package io.github.springroe.intellij.salesforce.ui;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.wizard.AbstractWizard;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

/**
 * 组创建
 *
 * @author ksy
 */
public class ApiNewEntityActionDialog extends AbstractWizard<ModuleWizardStep> {

    private Project myProject;
    private Module myModule;

    public ApiNewEntityActionDialog(Project project, Module module) {
        super("Create JPA Entity Use Api", project);
        myProject = project;
        myModule = module;
        ModuleWizardStep[] wizardSteps = createWizardSteps();
        for (ModuleWizardStep wizardStep : wizardSteps) {
            addStep(wizardStep);
        }
        init();
    }

    public ModuleWizardStep[] createWizardSteps() {
        return new ModuleWizardStep[]{
                new ApiNewEntityActionDialogForm(myProject, myModule)
        };
    }

    /**
     * 点击Ok,之后去生成对应的扩展点
     */
    @Override
    protected void doOKAction() {
        ModuleWizardStep step = getCurrentStepObject();
        try {
            if (step.validate()) {
                super.doOKAction();
            }
        } catch (ConfigurationException e) {
            Messages.showErrorDialog(step.getComponent(), e.getMessage(), e.getTitle());
        }
    }

    @Nullable
    @Override
    protected String getHelpID() {
        return ApiNewEntityActionDialog.class.getName();
    }


}

