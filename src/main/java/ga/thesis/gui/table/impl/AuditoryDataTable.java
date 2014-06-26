package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.settings.auditory.AuditorySettingsDialog;
import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.model.AuditoryTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.util.List;

public class AuditoryDataTable extends AbstractDataTable<Auditory, AuditoryTableModel> {

    public AuditoryDataTable(JFrame parent) {
        super(parent);
    }


    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void doDelete(List<Auditory> selected) {
        new DeleteSwingWorker<Auditory>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(Auditory model) {
                PersistenceConfig.getInstance().getAuditoryService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<Auditory>(dataTable) {
            @Override
            protected Iterable<ga.thesis.hibernate.entities.Auditory> load() {
                return PersistenceConfig.getInstance().getAuditoryService().findAll();
            }
        }.execute();
    }

    @Override
    protected AuditoryTableModel getDefaultModel() {
        return new AuditoryTableModel();
    }

    @Override
    protected AbstractSettingsDialog<Auditory> getDialog() {
        return new AuditorySettingsDialog(frame, new SaveListenerImpl<Auditory>());
    }
}
