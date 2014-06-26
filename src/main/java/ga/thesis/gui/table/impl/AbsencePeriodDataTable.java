package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererMatrix;
import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererPeriod;
import ga.thesis.gui.table.common.table.*;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.common.components.AbstractComboBoxEditor;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.model.AbsencePeriodTableModel;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.settings.absenceperiod.AbsencePeriodSettingsDialog;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.hibernate.entities.AbsencePeriod;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

public class AbsencePeriodDataTable extends AbstractDataTable<AbsencePeriod, AbsencePeriodTableModel> {

    public AbsencePeriodDataTable(JFrame parent) {
        super(parent);
    }

    public static AbstractRenderer<Period> renderer1 = new AbsencePeriodRendererPeriod();
    public static AbstractRenderer<AbsenceMatrix> renderer2 = new AbsencePeriodRendererMatrix();

    @Override
    protected void init() {
        super.init();
        TableColumn column1 = dataTable.getColumnModel().getColumn(1);
        column1.setCellEditor(new AbstractComboBoxEditor<Period>() {

            @Override
            protected ComboBoxSwingWorker<Period> getWorker(JComboBox<Period> combobox, Period value) {
                return new AbsencePeriodComboBoxWorkerPeriod(combobox, value) {
                };
            }

            @Override
            protected ComboBoxRenderer<Period> getRenderer() {
                return new AbsencePeriodComboBoxRendererPeriod();
            }
        });
        column1.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                Period period = (Period) value;
                super.setValue(renderer1.render(period));
            }
        });

        TableColumn column2 = dataTable.getColumnModel().getColumn(2);
        column2.setCellEditor(new AbstractComboBoxEditor<AbsenceMatrix>() {

            @Override
            protected ComboBoxSwingWorker<AbsenceMatrix> getWorker(JComboBox<AbsenceMatrix> combobox, AbsenceMatrix value) {
                return new AbsencePeriodComboBoxWorkerMatrix(combobox, value) {
                };
            }

            @Override
            protected ComboBoxRenderer<AbsenceMatrix> getRenderer() {
                return new AbsencePeriodComboBoxRendererMatrix();
            }
        });
        column2.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                AbsenceMatrix absenceMatrix = (AbsenceMatrix) value;
                super.setValue(renderer2.render(absenceMatrix));
            }
        });


    }

    @Override
    protected void doDelete(List<AbsencePeriod> selected) {
        new DeleteSwingWorker<AbsencePeriod>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(AbsencePeriod model) {
                PersistenceConfig.getInstance().getAbsencePeriodService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<AbsencePeriod>(dataTable) {
            @Override
            protected Iterable<AbsencePeriod> load() {
                return PersistenceConfig.getInstance().getAbsencePeriodService().findAll();
            }
        }.execute();
    }

    @Override
    protected AbsencePeriodTableModel getDefaultModel() {
        return new AbsencePeriodTableModel();
    }

    @Override
    protected AbstractSettingsDialog<AbsencePeriod> getDialog() {
        return new AbsencePeriodSettingsDialog(frame, new SaveListenerImpl<AbsencePeriod>());
    }
}
