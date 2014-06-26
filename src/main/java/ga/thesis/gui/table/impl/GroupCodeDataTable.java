package ga.thesis.gui.table.impl;

import ga.thesis.entities.Group;
import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.common.components.AbstractComboBoxEditor;
import ga.thesis.gui.table.common.renderer.*;
import ga.thesis.gui.table.common.table.*;
import ga.thesis.gui.table.model.AbsencePeriodTableModel;
import ga.thesis.gui.table.model.GroupCodeTableModel;
import ga.thesis.gui.table.settings.absenceperiod.AbsencePeriodSettingsDialog;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.groupcode.GroupCodeSettingsDialog;
import ga.thesis.hibernate.entities.*;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

public class GroupCodeDataTable extends AbstractDataTable<GroupCode, GroupCodeTableModel> {

    public GroupCodeDataTable(JFrame parent) {
        super(parent);
    }

    public static AbstractRenderer<GroupList> renderer1 = new GroupCodeRendererList();
    public static AbstractRenderer<Teacher> renderer2 = new GroupCodeRendererTeacher();

    @Override
    protected void init() {
        super.init();
        TableColumn column1 = dataTable.getColumnModel().getColumn(3);
        column1.setCellEditor(new AbstractComboBoxEditor<Teacher>() {

            @Override
            protected ComboBoxSwingWorker<Teacher> getWorker(JComboBox<Teacher> combobox, Teacher value) {
                return new GroupCodeComboBoxWorkerTeacher(combobox, value) {
                };
            }

            @Override
            protected ComboBoxRenderer<Teacher> getRenderer() {
                return new GroupCodeComboBoxRendererTeacher();
            }
        });
        column1.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                Teacher teacher = (Teacher) value;
                super.setValue(renderer2.render(teacher));
            }
        });

        TableColumn column2 = dataTable.getColumnModel().getColumn(7);
        column2.setCellEditor(new AbstractComboBoxEditor<GroupList>() {

            @Override
            protected ComboBoxSwingWorker<GroupList> getWorker(JComboBox<GroupList> combobox, GroupList value) {
                return new GroupCodeComboBoxWorkerList(combobox, value) {
                };
            }

            @Override
            protected ComboBoxRenderer<GroupList> getRenderer() {
                return new GroupCodeComboBoxRendererList();
            }
        });
        column2.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                GroupList groupList = (GroupList) value;
                super.setValue(renderer1.render(groupList));
            }
        });


    }

    @Override
    protected void doDelete(List<GroupCode> selected) {
        new DeleteSwingWorker<GroupCode>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(GroupCode model) {
                PersistenceConfig.getInstance().getGroupCodeService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<GroupCode>(dataTable) {
            @Override
            protected Iterable<GroupCode> load() {
                return PersistenceConfig.getInstance().getGroupCodeService().findAll();
            }
        }.execute();
    }

    @Override
    protected GroupCodeTableModel getDefaultModel() {
        return new GroupCodeTableModel();
    }

    @Override
    protected AbstractSettingsDialog<GroupCode> getDialog() {
        return new GroupCodeSettingsDialog(frame, new SaveListenerImpl<GroupCode>());
    }
}
