package io.github.springroe.intellij.salesforce.ui;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import io.github.springroe.intellij.salesforce.domain.ApiNewEntityContext;
import io.github.springroe.intellij.salesforce.domain.NewEntityModel;
import io.github.springroe.intellij.salesforce.domain.SalesforceEntityModel;
import io.github.springroe.intellij.salesforce.domain.SalesforceEntityPropertyModel;
import io.github.springroe.intellij.salesforce.state.SalesforceAuthModelService;
import io.github.springroe.intellij.salesforce.util.Tool;
import org.openapitools.client.ApiException;
import org.openapitools.client.model.ObjectInfoSobjects;
import org.openapitools.client.model.ObjectMetaData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiNewEntityActionDialogForm extends ModuleWizardStep {
    private JPanel panel;
    private JComboBox comboObject;
    private JTextField txtSobjectLabel;
    private JTextField txtEntityName;
    private JTextField txtEntityRemark;
    private JTextField txtTableName;
    private JTextField txtSobjectApiName;
    private JTable tableProperties;
    private JTextArea txtSoql;

    private Project myProject;
    private Module myModule;

    private SalesforceAuthModelService service = SalesforceAuthModelService.getInstance();
    private List<ObjectInfoSobjects> sobjectsList = new ArrayList<>(0);
    private List<String> items = new ArrayList<>(0);
    private List<SalesforceEntityPropertyModel> propertyModels = new ArrayList<>(0);
    private ObjectInfoSobjects selectedItem = null;
    private ObjectMetaData metaData = null;

    public ApiNewEntityActionDialogForm(Project myProject, Module myModule) {
        this.myProject = myProject;
        this.myModule = myModule;
        comboObject.addItemListener(this::itemSelectHandle);
        tableProperties.getSelectionModel().addListSelectionListener(this::tableRowSelectHandle);
        txtSoql.setLineWrap(true);
    }

    @Override
    public void _init() {
        super._init();
        loadObjects();
    }

    @Override
    public JComponent getComponent() {
        return panel;
    }

    @Override
    public void updateDataModel() {
        System.out.println("updateDataModel");
    }

    @Override
    public boolean validate() throws ConfigurationException {
        var data = new SalesforceEntityModel();
        getData(data);
        if (data.getObjectName().isBlank() || data.getObjectLabel().isBlank()) {
            throw new ConfigurationException("sobject cannot be empty, please select one!", "Create Class Tips");
        }
        if (data.getEntityName().isBlank()) {
            throw new ConfigurationException("entity name cannot be empty", "Create Class Tips");
        }
        if (data.getTableName().isBlank()) {
            throw new ConfigurationException("table name cannot be empty", "Create Class Tips");
        }
        var indexes = tableProperties.getSelectedRows();
        if (indexes.length == 0) {
            throw new ConfigurationException("properties cannot be empty, please select at least one!", "Create Class Tips");
        }
        var selectedPropertyModels = getSelectedRows();
        var model = new NewEntityModel();
        model.setEntityModel(data);
        model.setPropertyModels(selectedPropertyModels);
        ApiNewEntityContext.setData(model);
        return super.validate();
    }

    private void itemSelectHandle(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            var index = items.indexOf(e.getItem());
            var object = sobjectsList.get(index);
            selectedItem = object;
            var model = new SalesforceEntityModel();
            model.setObjectLabel(object.getLabel());
            model.setObjectName(object.getName());
            model.setEntityName(object.getName());
            model.setEntityRemark(object.getLabel());
            model.setTableName("sf" + Tool.humpToLine(object.getName()));
            setData(model);
            loadObjectMetadata();
        } else {
            setData(new SalesforceEntityModel());
            tableProperties.removeAll();
        }
    }

    private void tableRowSelectHandle(ListSelectionEvent e) {
        var selectedRows = getSelectedRows();
        var soql = new StringBuilder("SELECT ");
        for (int i = 0; i < selectedRows.size(); i++) {
            soql.append(selectedRows.get(i).getName());
            if (i < selectedRows.size() - 1) soql.append(",");
        }
        soql.append(" FROM ");
        soql.append(txtSobjectApiName.getText());
        txtSoql.setText(soql.toString());
    }

    private void tableModelListenerHandle(TableModelEvent e) {
        switch (e.getType()) {
            case TableModelEvent.DELETE: {
                for (int i = e.getFirstRow(); i <= e.getLastRow(); i++) {
                    propertyModels.remove(i);
                }
                break;
            }
            case TableModelEvent.UPDATE: {
                for (int i = e.getFirstRow(); i <= e.getLastRow(); i++) {
                    var model = propertyModels.get(i);
                    DefaultTableModel source = (DefaultTableModel) e.getSource();
                    var array = model.toArray();
                    array[e.getColumn()] = source.getValueAt(i, e.getColumn());
                    propertyModels.get(i).fromArray(array);
                }
                break;
            }
            case TableModelEvent.INSERT: {
                break;
            }
        }
    }

    private List<SalesforceEntityPropertyModel> getSelectedRows() {
        var indexes = tableProperties.getSelectedRows();
        return propertyModels
                .stream()
                .filter(r -> Arrays.stream(indexes).anyMatch(i -> i == propertyModels.indexOf(r)))
                .collect(Collectors.toList());
    }

    private void loadObjects() {
        try {
            comboObject.removeAllItems();
            sobjectsList = service.loadObjects();
            items = sobjectsList.stream().map(r -> r.getName() + "(" + r.getLabel() + ")").collect(Collectors.toList());
            items.forEach(r -> comboObject.addItem(r));
        } catch (ApiException e) {
            JOptionPane.showMessageDialog(null, "登录错误" + e.getResponseBody());
            e.printStackTrace();
        }
    }

    private void loadObjectMetadata() {
        try {
            metaData = service.loadObjectMetadata(selectedItem.getName());
            String[] n = {"label", "name", "mappingName", "type", "mappingType", "length", "scale", "remark"};
            propertyModels = metaData
                    .getFields()
                    .stream()
                    .map(SalesforceEntityPropertyModel::new)
                    .collect(Collectors.toList());
            // 创建一个默认的表格模型
            var items = propertyModels.stream().map(SalesforceEntityPropertyModel::toArray)
                    .collect(Collectors.toList());
            var p = items.toArray(new Object[items.size()][]);
            var model = new DefaultTableModel(p, n);
            model.addTableModelListener(this::tableModelListenerHandle);
            tableProperties.setModel(model);
        } catch (ApiException e) {
            JOptionPane.showMessageDialog(null, "metadata查询错误" + e.getResponseBody());
            e.printStackTrace();
        }
    }

    public void setData(SalesforceEntityModel data) {
        txtSobjectLabel.setText(data.getObjectLabel());
        txtSobjectApiName.setText(data.getObjectName());
        txtEntityName.setText(data.getEntityName());
        txtEntityRemark.setText(data.getEntityRemark());
        txtTableName.setText(data.getTableName());
    }

    public void getData(SalesforceEntityModel data) {
        data.setObjectLabel(txtSobjectLabel.getText());
        data.setObjectName(txtSobjectApiName.getText());
        data.setEntityName(txtEntityName.getText());
        data.setEntityRemark(txtEntityRemark.getText());
        data.setTableName(txtTableName.getText());
        data.setSoql(txtSoql.getText());
    }

    public boolean isModified(SalesforceEntityModel data) {
        if (txtSobjectLabel.getText() != null ? !txtSobjectLabel.getText().equals(data.getObjectLabel()) : data.getObjectLabel() != null)
            return true;
        if (txtSobjectApiName.getText() != null ? !txtSobjectApiName.getText().equals(data.getObjectName()) : data.getObjectName() != null)
            return true;
        if (txtEntityName.getText() != null ? !txtEntityName.getText().equals(data.getEntityName()) : data.getEntityName() != null)
            return true;
        if (txtEntityRemark.getText() != null ? !txtEntityRemark.getText().equals(data.getEntityRemark()) : data.getEntityRemark() != null)
            return true;
        if (txtTableName.getText() != null ? !txtTableName.getText().equals(data.getTableName()) : data.getTableName() != null)
            return true;
        return false;
    }
}
