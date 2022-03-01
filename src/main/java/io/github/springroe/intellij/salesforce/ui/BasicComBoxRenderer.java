package io.github.springroe.intellij.salesforce.ui;


import io.github.springroe.intellij.salesforce.PluginConstant;
import io.github.springroe.intellij.salesforce.domain.SelectedTypeModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉列表渲染
 */
public class BasicComBoxRenderer extends DefaultListCellRenderer {
    private Map<String, ImageIcon> iconMap = new HashMap<>();
    private Color background = new Color(0, 100, 255, 15);
    private Color defaultBackground = (Color) UIManager.get("List.background");

    public BasicComBoxRenderer() {
        iconMap.put(PluginConstant.COMBOX_CONTROLLER, new ImageIcon(getClass().getResource("/icons/right/controller.png")));
        iconMap.put(PluginConstant.COMBOX_ENTITY, new ImageIcon(getClass().getResource("/icons/right/controller.png")));
    }

    public static List<SelectedTypeModel> getSelectedList() {
        List<SelectedTypeModel> list = new ArrayList<SelectedTypeModel>();
        SelectedTypeModel blank = new SelectedTypeModel();
        blank.setName("");
        blank.setValue(PluginConstant.COMBOX_BLANK);
        list.add(blank);

        SelectedTypeModel mapper = new SelectedTypeModel();
        mapper.setName("Entity");
        mapper.setValue(PluginConstant.COMBOX_ENTITY);
        list.add(mapper);

        SelectedTypeModel controller = new SelectedTypeModel();
        controller.setName("Controller");
        controller.setValue(PluginConstant.COMBOX_CONTROLLER);
        // list.add(controller);


        return list;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        SelectedTypeModel emp = (SelectedTypeModel) value;
        this.setText(emp.getName());
        this.setIcon(iconMap.get(emp.getValue()));
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        return this;
    }
}