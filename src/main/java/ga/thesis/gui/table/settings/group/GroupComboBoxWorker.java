package ga.thesis.gui.table.settings.group;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class GroupComboBoxWorker extends ComboBoxSwingWorker<GroupCode> {

    public GroupComboBoxWorker(JComboBox<GroupCode> comboBox) {
        super(comboBox);
    }

    @Override
    protected Iterable<GroupCode> load() {
        return PersistenceConfig.getInstance().getInstance().getGroupCodeService().findAll();
    }
}
