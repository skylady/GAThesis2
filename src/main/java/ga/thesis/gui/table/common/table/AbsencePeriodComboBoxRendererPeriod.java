package ga.thesis.gui.table.common.table;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.renderer.AbsencePeriodRendererPeriod;
import ga.thesis.gui.table.common.renderer.AbstractRenderer;
import ga.thesis.hibernate.entities.Period;

public class AbsencePeriodComboBoxRendererPeriod extends ComboBoxRenderer<Period> {
    @Override
    public AbstractRenderer<Period> getRenderer() {
        return new AbsencePeriodRendererPeriod();
    }
}
