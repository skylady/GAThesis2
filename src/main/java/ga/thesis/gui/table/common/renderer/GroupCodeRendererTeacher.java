package ga.thesis.gui.table.common.renderer;

import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;

public class GroupCodeRendererTeacher implements AbstractRenderer<Teacher> {
    @Override
    public String render(Teacher item) {
        return item == null ? "" : item.getName();
    }}
