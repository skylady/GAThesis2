package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRenderer;
import ga.thesis.gui.table.common.renderer.GroupCodeRendererList;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;

public class GroupCodeComboBoxRendererList extends ComboBoxRenderer<GroupList> {
    @Override
    public AbstractRenderer<GroupList> getRenderer() {
        return new GroupCodeRendererList();
    }
}
