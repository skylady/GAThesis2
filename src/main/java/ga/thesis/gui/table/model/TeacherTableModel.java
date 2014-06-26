package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class TeacherTableModel extends TimeTableAbstractTableModel<Teacher> {

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Name","Absence Matrix"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, String.class, AbsenceMatrix.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return teacher.getId();
            case 1: return teacher.getName();
            case 2: return teacher.getIdAbsenceMatrix();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected Teacher doUpdate(Teacher teacher, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: teacher.setId((Long) aValue); break;
            case 1: teacher.setName((String) aValue); break;
            case 2: teacher.setIdAbsenceMatrix((AbsenceMatrix) aValue); break;
            default:
                break;
        }
        return teacher;
    }

    @Override
    protected CRUDService<Teacher, ?> getService() {
        return PersistenceConfig.getInstance().getTeacherService();
    }
}
