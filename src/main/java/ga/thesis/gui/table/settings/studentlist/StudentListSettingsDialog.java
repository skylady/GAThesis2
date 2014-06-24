package ga.thesis.gui.table.settings.studentlist;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.StudentList;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class StudentListSettingsDialog extends AbstractSettingsDialog<StudentList> {

    public StudentListSettingsDialog(Frame owner, SaveListener<StudentList> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<StudentList> getEditor() {
        return new StudentListSettingsEditor();
    }

    @Override
    public CRUDService<StudentList, ?> getService() {
        return PersistenceConfig.getInstance().getStudentListService();
    }
}
