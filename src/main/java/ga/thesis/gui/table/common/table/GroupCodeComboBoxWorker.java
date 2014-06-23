package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class GroupCodeComboBoxWorker extends ComboBoxSwingWorker<GroupCode> {

    public GroupCodeComboBoxWorker(JComboBox<GroupCode> comboBox) {
        super(comboBox);
    }

    public GroupCodeComboBoxWorker(JComboBox<GroupCode> comboBox, GroupCode chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<GroupCode> load() {
        return PersistenceConfig.getInstance().getInstance().getGroupCodeService().findAll();
    }
}
