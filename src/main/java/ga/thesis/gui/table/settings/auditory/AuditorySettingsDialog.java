package ga.thesis.gui.table.settings.auditory;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class AuditorySettingsDialog extends AbstractSettingsDialog<Auditory> {

    public AuditorySettingsDialog(Frame owner, SaveListener<Auditory> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<Auditory> getEditor() {
        return new AuditorySettingsEditor();
    }

    @Override
    public CRUDService<Auditory, ?> getService() {
        return PersistenceConfig.getInstance().getAuditoryService();
    }
}
