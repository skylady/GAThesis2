package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class GroupCodeComboBoxWorkerTeacher extends ComboBoxSwingWorker<Teacher> {

    public GroupCodeComboBoxWorkerTeacher(JComboBox<Teacher> comboBox) {
        super(comboBox);
    }

    public GroupCodeComboBoxWorkerTeacher(JComboBox<Teacher> comboBox, Teacher chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<Teacher> load() {
        return PersistenceConfig.getInstance().getInstance().getTeacherService().findAll();
    }
}
