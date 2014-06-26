package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.*;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class AbsencePeriodTableModel extends TimeTableAbstractTableModel<AbsencePeriod> {

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Period", "Absence Matrix"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, Period.class, AbsenceMatrix.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AbsencePeriod absencePeriod = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return absencePeriod.getId();
            case 1: return absencePeriod.getIdPeriod();
            case 2: return absencePeriod.getIdAbsenceMatrix();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected AbsencePeriod doUpdate(AbsencePeriod absencePeriod, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: absencePeriod.setId((Long) aValue); break;
            case 1: absencePeriod.setIdPeriod((Period) aValue); break;
            case 2: absencePeriod.setIdAbsenceMatrix((AbsenceMatrix) aValue); break;
            default:
                break;
        }
        return absencePeriod;
    }

    @Override
    protected CRUDService<AbsencePeriod, ?> getService() {
        return PersistenceConfig.getInstance().getAbsencePeriodService();
    }
}
