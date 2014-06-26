package ga.thesis.gui.table.impl;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.common.components.AbstractComboBoxEditor;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRendererList;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRendererList;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorker;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorkerList;
import ga.thesis.gui.table.model.AbsenceMatrixTableModel;
import ga.thesis.gui.table.model.StudentListTableModel;
import ga.thesis.gui.table.settings.absencematrix.AbsenceMatrixSettingsDialog;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.studentlist.StudentListSettingsDialog;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

public class StudentListDataTable extends AbstractDataTable<StudentList, StudentListTableModel> {

    public StudentListDataTable(JFrame parent) {
        super(parent);
    }

    public static AbstractRenderer<GroupList> renderer = new GroupCodeRendererList();

    @Override
    protected void init() {
        super.init();

        TableColumn column = dataTable.getColumnModel().getColumn(2);
        column.setCellEditor(new AbstractComboBoxEditor<GroupList>() {

            @Override
            protected ComboBoxSwingWorker<GroupList> getWorker(JComboBox<GroupList> combobox, GroupList value) {
                return new GroupCodeComboBoxWorkerList(combobox, value);
            }

            @Override
            protected ComboBoxRenderer<GroupList> getRenderer() {
                return new GroupCodeComboBoxRendererList();
            }
        });
        column.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                GroupList groupCode = (GroupList) value;
                super.setValue(renderer.render(groupCode));
            }
        });
    }


    @Override
    protected void doDelete(List<StudentList> selected) {
        new DeleteSwingWorker<StudentList>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(StudentList model) {
                PersistenceConfig.getInstance().getStudentListService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<StudentList>(dataTable) {
            @Override
            protected Iterable<StudentList> load() {
                return PersistenceConfig.getInstance().getStudentListService().findAll();
            }
        }.execute();
    }

    @Override
    protected StudentListTableModel getDefaultModel() {
        return new StudentListTableModel();
    }

    @Override
    protected AbstractSettingsDialog<StudentList> getDialog() {
        return new StudentListSettingsDialog(frame, new SaveListenerImpl<StudentList>());
    }
}
