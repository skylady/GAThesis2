package ga.thesis.gui.table.impl;

import ga.thesis.gui.table.async.DeleteSwingWorker;
import ga.thesis.gui.table.async.LoadSwingWorker;
import ga.thesis.gui.table.common.AbstractDataTable;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.util.List;

public class GroupDataTable extends AbstractDataTable<Group, GroupTableModel> {

    public GroupDataTable(JFrame parent) {
        super(parent);
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
