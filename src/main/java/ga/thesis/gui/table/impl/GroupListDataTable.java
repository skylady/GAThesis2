package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.model.AbsenceMatrixTableModel;
import ga.thesis.gui.table.model.GroupListTableModel;
import ga.thesis.gui.table.settings.absencematrix.AbsenceMatrixSettingsDialog;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.grouplist.GroupListSettingsDialog;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.util.List;

public class GroupListDataTable extends AbstractDataTable<GroupList, GroupListTableModel> {

    public GroupListDataTable(JFrame parent) {
        super(parent);
    }


    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void doDelete(List<GroupList> selected) {
        new DeleteSwingWorker<GroupList>(selected) {

            @Override
            protected void afterDelete() {
                JOptionPane.showMessageDialog(getParent(), "Deleted");
                doLoad();
            }

            @Override
            protected void doDelete(GroupList model) {
                PersistenceConfig.getInstance().getGroupListService().delete(model);
            }

        }.execute();
    }

    @Override
    protected void doLoad() {
        new LoadSwingWorker<GroupList>(dataTable) {
            @Override
            protected Iterable<GroupList> load() {
                return PersistenceConfig.getInstance().getGroupListService().findAll();
            }
        }.execute();
    }

    @Override
    protected GroupListTableModel getDefaultModel() {
        return new GroupListTableModel();
    }

    @Override
    protected AbstractSettingsDialog<GroupList> getDialog() {
        return new GroupListSettingsDialog(frame, new SaveListenerImpl<GroupList>());
    }
}
