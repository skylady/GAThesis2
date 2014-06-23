package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.hibernate.entities.GroupCode;

public class GroupCodeComboBoxRenderer extends ComboBoxRenderer<GroupCode> {
    @Override
    public AbstractRenderer<GroupCode> getRenderer() {
        return new GroupCodeRenderer();
    }
}
