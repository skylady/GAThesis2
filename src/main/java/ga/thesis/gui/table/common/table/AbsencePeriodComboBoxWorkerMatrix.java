package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class AbsencePeriodComboBoxWorkerMatrix extends ComboBoxSwingWorker<AbsenceMatrix> {

    public AbsencePeriodComboBoxWorkerMatrix(JComboBox<AbsenceMatrix> comboBox) {
        super(comboBox);
    }

    public AbsencePeriodComboBoxWorkerMatrix(JComboBox<AbsenceMatrix> comboBox, AbsenceMatrix chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<AbsenceMatrix> load() {
        return PersistenceConfig.getInstance().getInstance().getAbsenceMatrixService().findAll();
    }
}
