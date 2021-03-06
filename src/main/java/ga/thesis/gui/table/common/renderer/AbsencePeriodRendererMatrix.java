package ga.thesis.gui.table.common.renderer;

import ga.thesis.hibernate.entities.AbsenceMatrix;

public class AbsencePeriodRendererMatrix implements AbstractRenderer<AbsenceMatrix> {
    @Override
    public String render(AbsenceMatrix item) {
        return item == null ? "" : item.getAbsenceMatrixName(); }
}
