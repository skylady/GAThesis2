package ga.thesis.gui.table.impl;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.common.components.AbstractComboBoxEditor;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorker;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

public class GroupDataTable extends AbstractDataTable<Group, GroupTableModel> {

    public GroupDataTable(JFrame parent) {
        super(parent);
    }

    public static AbstractRenderer<GroupCode> renderer = new GroupCodeRenderer();

    @Override
    protected void init() {
        super.init();
        TableColumn column = dataTable.getColumnModel().getColumn(2);
        column.setCellEditor(new AbstractComboBoxEditor<GroupCode>() {

            @Override
            protected ComboBoxSwingWorker<GroupCode> getWorker(JComboBox<GroupCode> combobox, GroupCode value) {
                return new GroupCodeComboBoxWorker(combobox, value);
            }

            @Override
            protected ComboBoxRenderer<GroupCode> getRenderer() {
                return new GroupCodeComboBoxRenderer();
            }
        });
        column.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                GroupCode groupCode = (GroupCode) value;
                super.setValue(renderer.render(groupCode));
            }
        });
    }

    @Override
    protected void doDelete(List<Group> selected) {
        new DeleteSwingWorker<Group>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(Group model) {
                PersistenceConfig.getInstance().getGroupService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<Group>(dataTable) {
            @Override
            protected Iterable<Group> load() {
                return PersistenceConfig.getInstance().getGroupService().findAll();
            }
        }.execute();
    }

    @Override
    protected GroupTableModel getDefaultModel() {
        return new GroupTableModel();
    }

    @Override
    protected AbstractSettingsDialog<Group> getDialog() {
        return new GroupSettingsDialog(frame, new SaveListenerImpl<Group>());
    }
}
