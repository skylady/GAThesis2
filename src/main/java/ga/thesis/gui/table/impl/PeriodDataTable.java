package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.model.PeriodTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.gui.table.settings.period.PeriodSettingsDialog;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.util.List;

public class PeriodDataTable extends AbstractDataTable<Period, PeriodTableModel> {

    public PeriodDataTable(JFrame parent) {
        super(parent);
    }


    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void doDelete(List<Period> selected) {
        new DeleteSwingWorker<Period>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(Period model) {
                PersistenceConfig.getInstance().getPeriodService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<Period>(dataTable) {
            @Override
            protected Iterable<Period> load() {
                return PersistenceConfig.getInstance().getPeriodService().findAll();
            }
        }.execute();
    }

    @Override
    protected PeriodTableModel getDefaultModel() {
        return new PeriodTableModel();
    }

    @Override
    protected AbstractSettingsDialog<Period> getDialog() {
        return new PeriodSettingsDialog(frame, new SaveListenerImpl<Period>());
    }
}
