package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class AbsenceMatrixTableModel extends TimeTableAbstractTableModel<AbsenceMatrix> {

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Absence Matrix Name"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, String.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AbsenceMatrix absenceMatrix = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return absenceMatrix.getId();
            case 1: return absenceMatrix.getAbsenceMatrixName();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected AbsenceMatrix doUpdate(AbsenceMatrix absenceMatrix, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: absenceMatrix.setId((Long) aValue); break;
            case 1: absenceMatrix.setAbsenceMatrixName((String) aValue); break;
            default:
                break;
        }
        return absenceMatrix;
    }

    @Override
    protected CRUDService<AbsenceMatrix, ?> getService() {
        return PersistenceConfig.getInstance().getAbsenceMatrixService();
    }
}
