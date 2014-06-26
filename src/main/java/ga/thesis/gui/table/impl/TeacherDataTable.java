package ga.thesis.gui.table.impl;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.common.components.AbstractComboBoxEditor;
import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererMatrix;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.common.renderer.TeacherRenderer;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxRendererMatrix;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxWorkerMatrix;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorker;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.model.TeacherTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.gui.table.settings.teacher.TeacherSettingsDialog;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

public class TeacherDataTable extends AbstractDataTable<Teacher, TeacherTableModel> {

    public TeacherDataTable(JFrame parent) {
        super(parent);
    }

    public static AbstractRenderer<AbsenceMatrix> renderer = new AbsencePeriodRendererMatrix();

    @Override
    protected void init() {
        super.init();
        TableColumn column = dataTable.getColumnModel().getColumn(2);
        column.setCellEditor(new AbstractComboBoxEditor<AbsenceMatrix>() {

            @Override
            protected ComboBoxSwingWorker<AbsenceMatrix> getWorker(JComboBox<AbsenceMatrix> combobox, AbsenceMatrix value) {
                return new AbsencePeriodComboBoxWorkerMatrix(combobox, value);
            }

            @Override
            protected ComboBoxRenderer<AbsenceMatrix> getRenderer() {
                return new AbsencePeriodComboBoxRendererMatrix();
            }
        });
        column.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                AbsenceMatrix absenceMatrix = (AbsenceMatrix) value;
                super.setValue(renderer.render(absenceMatrix));
            }
        });
    }

    @Override
    protected void doDelete(List<Teacher> selected) {
        new DeleteSwingWorker<Teacher>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(Teacher model) {
                PersistenceConfig.getInstance().getTeacherService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<Teacher>(dataTable) {
            @Override
            protected Iterable<Teacher> load() {
                return PersistenceConfig.getInstance().getTeacherService().findAll();
            }
        }.execute();
    }

    @Override
    protected TeacherTableModel getDefaultModel() {
        return new TeacherTableModel();
    }

    @Override
    protected AbstractSettingsDialog<Teacher> getDialog() {
        return new TeacherSettingsDialog(frame, new SaveListenerImpl<Teacher>());
    }
}
