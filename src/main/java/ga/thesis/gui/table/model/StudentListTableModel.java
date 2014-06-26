package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class StudentListTableModel extends TimeTableAbstractTableModel<StudentList> {

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Student Name", "Group List"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, String.class, GroupList.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StudentList studentList = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return studentList.getId();
            case 1: return studentList.getStudentName();
            case 2: return studentList.getIdGroupList();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected StudentList doUpdate(StudentList studentList, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: studentList.setId((Long) aValue); break;
            case 1: studentList.setStudentName((String) aValue); break;
            case 2: studentList.setIdGroupList((GroupList) aValue); break;
            default:
                break;
        }
        return studentList;
    }

    @Override
    protected CRUDService<StudentList,?> getService() {
        return PersistenceConfig.getInstance().getStudentListService();
    }
}
