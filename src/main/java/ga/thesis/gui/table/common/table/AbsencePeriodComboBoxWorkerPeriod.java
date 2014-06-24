package ga.thesis.gui.table.common.table;

import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;

public class AbsencePeriodComboBoxWorkerPeriod extends ComboBoxSwingWorker<Period> {

    public AbsencePeriodComboBoxWorkerPeriod(JComboBox<Period> comboBox) {
        super(comboBox);
    }

    public AbsencePeriodComboBoxWorkerPeriod(JComboBox<Period> comboBox, Period chosenValue) {
        super(comboBox, chosenValue);
    }

    @Override
    protected Iterable<Period> load() {
        return PersistenceConfig.getInstance().getInstance().getPeriodService().findAll();
    }
}
