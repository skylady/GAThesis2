package ga.thesis.gui.table.settings.period;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class PeriodSettingsDialog extends AbstractSettingsDialog<Period> {

    public PeriodSettingsDialog(Frame owner, SaveListener<Period> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<Period> getEditor() {
        return new PeriodSettingsEditor();
    }

    @Override
    public CRUDService<Period, ?> getService() {
        return PersistenceConfig.getInstance().getPeriodService();
    }
}
