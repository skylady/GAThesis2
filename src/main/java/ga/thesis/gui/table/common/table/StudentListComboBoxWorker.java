package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class StudentListComboBoxWorker extends ComboBoxSwingWorker<GroupList> {

    public StudentListComboBoxWorker(JComboBox<GroupList> comboBox) {
        super(comboBox);
    }

    public StudentListComboBoxWorker(JComboBox<GroupList> comboBox, GroupList chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<GroupList> load() {
        return PersistenceConfig.getInstance().getInstance().getGroupListService().findAll();
    }
}
