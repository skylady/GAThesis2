package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererMatrix;
import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererPeriod;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.AbsencePeriod;
import ga.thesis.hibernate.entities.Period;

public class AbsencePeriodComboBoxRendererMatrix extends ComboBoxRenderer<AbsenceMatrix> {
    @Override
    public AbstractRenderer<AbsenceMatrix> getRenderer() {
        return new AbsencePeriodRendererMatrix();
    }
}
