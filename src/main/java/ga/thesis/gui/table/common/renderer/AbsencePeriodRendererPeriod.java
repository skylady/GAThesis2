package ga.thesis.gui.table.common.renderer;

import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Period;

public class AbsencePeriodRendererPeriod implements AbstractRenderer<Period> {
    @Override
    public String render(Period item) {
        return item == null ? "" : item.getPeriod()+ " пара "+ item.getDayOfTheWeek() ;
    }
}
