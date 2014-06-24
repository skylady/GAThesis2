package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRendererTeacher;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;

public class GroupCodeComboBoxRendererTeacher extends ComboBoxRenderer<Teacher> {
    @Override
    public AbstractRenderer<Teacher> getRenderer() {
        return new GroupCodeRendererTeacher();
    }
}
