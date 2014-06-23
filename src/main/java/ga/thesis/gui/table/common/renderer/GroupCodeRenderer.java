package ga.thesis.gui.table.common.renderer;

import ga.thesis.hibernate.entities.GroupCode;

public class GroupCodeRenderer implements AbstractRenderer<GroupCode> {
    @Override
    public String render(GroupCode item) {
        return item == null ? "" : item.getSubject() + " " + item.getSubjectType();
    }
}
