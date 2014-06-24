package ga.thesis.gui.table.common.renderer;

import ga.thesis.hibernate.entities.GroupList;

public class TeacherRenderer implements AbstractRenderer<GroupList> {
    @Override
    public String render(GroupList item) {
        return item == null ? "" : item.getGroupName();
    }
}
