package ga.thesis.gui.table.settings.teacher;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class TeacherSettingsDialog extends AbstractSettingsDialog<Teacher> {

    public TeacherSettingsDialog(Frame owner, SaveListener<Teacher> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<Teacher> getEditor() {
        return new TeacherSettingsEditor();
    }

    @Override
    public CRUDService<Teacher, ?> getService() {
        return PersistenceConfig.getInstance().getTeacherService();
    }
}
