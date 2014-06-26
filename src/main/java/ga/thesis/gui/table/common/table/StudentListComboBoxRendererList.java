package ga.thesis.gui.table.common.table;

import ga.thesis.entities.Group;
import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.StudentListRenderer;
import ga.thesis.gui.table.common.renderer.TeacherRenderer;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupList;

public class StudentListComboBoxRendererList extends ComboBoxRenderer<GroupList> {
    @Override
    public AbstractRenderer<GroupList> getRenderer() {
        return new StudentListRenderer();
    }
}
