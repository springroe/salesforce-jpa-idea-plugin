package io.github.springroe.intellij.salesforce.entry.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.DumbAwareRunnable;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import io.github.springroe.intellij.salesforce.domain.ApiNewEntityContext;
import io.github.springroe.intellij.salesforce.domain.NewEntityModel;
import io.github.springroe.intellij.salesforce.domain.NewRightContext;
import io.github.springroe.intellij.salesforce.state.SalesforceAuthModelService;
import io.github.springroe.intellij.salesforce.ui.ApiNewEntityActionDialog;
import io.github.springroe.intellij.salesforce.util.IdeaUtils;
import io.github.springroe.intellij.salesforce.util.PisFileByFreeMarkerUtil;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class NewSalesforceEntityUseApiAction extends AnAction {

    SalesforceAuthModelService service = SalesforceAuthModelService.getInstance();

    @Override
    public void actionPerformed(AnActionEvent e) {

        Project project = e.getProject();
        /**
         * 从Action中得到一个虚拟文件
         */
        VirtualFile virtualFile = e.getData(LangDataKeys.VIRTUAL_FILE);
        assert virtualFile != null;
        if (!virtualFile.isDirectory()) {
            virtualFile = virtualFile.getParent();
        }
        Module module = ModuleUtil.findModuleForFile(virtualFile, project);

        // String moduleRootPath = ModuleRootManager.getInstance(module).getContentRoots()[0].getPath();
        String actionDir = virtualFile.getPath();
        String str = StringUtils.substringAfter(actionDir, "/src/main/kotlin/");
        String moduleRootPath = StringUtils.substringBefore(actionDir, "/src/main/kotlin/");
        //获取右键后的路径
        String basePackage = StringUtils.replace(str, "/", ".");
        ApiNewEntityContext.clearAllSet();
        ApiNewEntityContext.selectedPackage = basePackage;
        ApiNewEntityActionDialog dialog = new ApiNewEntityActionDialog(project, module);
        if (!dialog.showAndGet()) {
            return;
        }

        DumbService.getInstance(project).runWhenSmart((DumbAwareRunnable) () -> new WriteCommandAction(project) {
            @Override
            protected void run(@NotNull Result result) {
                createByFtl(project, moduleRootPath, "Entity.kt.ftl");
                // MavenProjectsManager manager = MavenProjectsManager.getInstance(project);
                //解决依赖
                // manager.forceUpdateAllProjectsOrFindAllAvailablePomFiles();
                //优化生成的所有Java类
                IdeaUtils.doOptimize(project);

            }
        }.execute());

    }


    /**
     * 通过ftl创建 Controller
     *
     * @param project
     * @param moduleRootPath
     */
    private void createByFtl(Project project, String moduleRootPath, String ftlName) {
        NewEntityModel apiNewEntityModel = ApiNewEntityContext.copyToApiNewEntityModel();
        try {
            PisFileByFreeMarkerUtil.createFile(project, apiNewEntityModel, moduleRootPath, ftlName);
            NewRightContext.clearAllSet();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean displayTextInToolbar() {
        return service.getState().getAuthenticated();
    }
}
