package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class TeacherComboBoxWorker extends ComboBoxSwingWorker<AbsenceMatrix> {

    public TeacherComboBoxWorker(JComboBox<AbsenceMatrix> comboBox) {
        super(comboBox);
    }

    public TeacherComboBoxWorker(JComboBox<AbsenceMatrix> comboBox, AbsenceMatrix chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<AbsenceMatrix> load() {
        return PersistenceConfig.getInstance().getInstance().getAbsenceMatrixService().findAll();
    }
}
