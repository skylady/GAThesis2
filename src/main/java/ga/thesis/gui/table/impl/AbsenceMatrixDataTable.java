package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.model.AbsenceMatrixTableModel;
import ga.thesis.gui.table.model.AuditoryTableModel;
import ga.thesis.gui.table.settings.absencematrix.AbsenceMatrixSettingsDialog;
import ga.thesis.gui.table.settings.auditory.AuditorySettingsDialog;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.util.List;

public class AbsenceMatrixDataTable extends AbstractDataTable<AbsenceMatrix, AbsenceMatrixTableModel> {

    public AbsenceMatrixDataTable(JFrame parent) {
        super(parent);
    }


    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void doDelete(List<AbsenceMatrix> selected) {
        new DeleteSwingWorker<AbsenceMatrix>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(AbsenceMatrix model) {
                PersistenceConfig.getInstance().getAbsenceMatrixService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<AbsenceMatrix>(dataTable) {
            @Override
            protected Iterable<AbsenceMatrix> load() {
                return PersistenceConfig.getInstance().getAbsenceMatrixService().findAll();
            }
        }.execute();
    }

    @Override
    protected AbsenceMatrixTableModel getDefaultModel() {
        return new AbsenceMatrixTableModel();
    }

    @Override
    protected AbstractSettingsDialog<AbsenceMatrix> getDialog() {
        return new AbsenceMatrixSettingsDialog(frame, new SaveListenerImpl<AbsenceMatrix>());
    }
}
