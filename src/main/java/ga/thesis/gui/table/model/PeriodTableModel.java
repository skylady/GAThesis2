package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

/**
 * Created by sky_lady on 6/24/14.
 */
public class PeriodTableModel extends  TimeTableAbstractTableModel<Period> {

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Period", "Day Of the week"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, Integer.class, String.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Period period = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return period.getId();
            case 1: return period.getPeriod();
            case 2: return period.getDayOfTheWeek();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 2 && columnIndex != 0;
    }

    @Override
    protected Period doUpdate(Period period, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: period.setId((Long) aValue); break;
            case 1: period.setPeriod((Integer) aValue); break;
            case 2: period.setDayOfTheWeek((String) aValue); break;
            default:
                break;
        }
        return period;
    }

    @Override
    protected CRUDService<Period, ?> getService() {
        return PersistenceConfig.getInstance().getPeriodService();
    }
}
