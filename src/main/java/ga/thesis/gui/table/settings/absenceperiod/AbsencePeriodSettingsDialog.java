package ga.thesis.gui.table.settings.absenceperiod;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.AbsencePeriod;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class AbsencePeriodSettingsDialog extends AbstractSettingsDialog<AbsencePeriod> {

    public AbsencePeriodSettingsDialog(Frame owner, SaveListener<AbsencePeriod> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<AbsencePeriod> getEditor() {
        return new AbsencePeriodSettingsEditor();
    }

    @Override
    public CRUDService<AbsencePeriod, ?> getService() {
        return PersistenceConfig.getInstance().getAbsencePeriodService();
    }
}
