package ga.thesis.gui.table.model;

import ga.thesis.entities.Individual;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class GroupCodeTableModel extends TimeTableAbstractTableModel<GroupCode> {

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"id", "Subject", "Subject Type", "Teacher Name", "Week Numbers", "Group Type", "Group Size", "Group List Name"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[]{Long.class, String.class, String.class, Teacher.class, String.class, String.class, Integer.class, GroupList.class}
                ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GroupCode groupCode = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return groupCode.getId();
            case 1:
                return groupCode.getSubject();
            case 2:
                return groupCode.getSubjectType();
            case 3:
                return groupCode.getIdGroupTeacher();
            case 4:
                return groupCode.getWeekNumbers();
            case 5:
                return groupCode.getGroupType();
            case 6:
                return groupCode.getGroupSize();
            case 7:
                return groupCode.getIdGroupList();
            default:
                throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected GroupCode doUpdate(GroupCode groupCode, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0:
                groupCode.setId((Long) aValue);
                break;
            case 1:
                groupCode.setSubject((String) aValue);
                break;
            case 2:
                groupCode.setSubjectType((String) aValue);
                break;
            case 3:
                groupCode.setIdGroupTeacher((Teacher) aValue);
                break;
            case 4:
                groupCode.setWeekNumbers((String) aValue);
                break;
            case 5:
                groupCode.setGroupType((String) aValue);
                break;
            case 6:
                groupCode.setGroupSize((Integer) aValue);
                break;
            case 7:
                groupCode.setIdGroupList((GroupList) aValue);
                break;
            default:
                break;
        }
        return groupCode;
    }

    @Override
    protected CRUDService<GroupCode, ?> getService() {
        return PersistenceConfig.getInstance().getGroupCodeService();
    }
}
