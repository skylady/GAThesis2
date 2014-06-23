package ga.thesis.gui.table.settings.absencematrix;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class AbsenceMatrixSettingsDialog extends AbstractSettingsDialog<AbsenceMatrix> {

    public AbsenceMatrixSettingsDialog(Frame owner, SaveListener<AbsenceMatrix> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<AbsenceMatrix> getEditor() {
        return new AbsenceMatrixSettingsEditor();
    }

    @Override
    public CRUDService<AbsenceMatrix, ?> getService() {
        return PersistenceConfig.getInstance().getAbsenceMatrixService();
    }
}
