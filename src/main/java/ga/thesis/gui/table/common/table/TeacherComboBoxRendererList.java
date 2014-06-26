package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRendererList;
import ga.thesis.gui.table.common.renderer.TeacherRenderer;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.GroupList;

public class TeacherComboBoxRendererList extends ComboBoxRenderer<AbsenceMatrix> {
    @Override
    public AbstractRenderer<AbsenceMatrix> getRenderer() {
        return new TeacherRenderer();
    }
}
