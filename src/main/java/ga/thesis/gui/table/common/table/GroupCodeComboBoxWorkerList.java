package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class GroupCodeComboBoxWorkerList extends ComboBoxSwingWorker<GroupList> {

    public GroupCodeComboBoxWorkerList(JComboBox<GroupList> comboBox) {
        super(comboBox);
    }

    public GroupCodeComboBoxWorkerList(JComboBox<GroupList> comboBox, GroupList chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<GroupList> load() {
        return PersistenceConfig.getInstance().getInstance().getGroupListService().findAll();
    }
}
