package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class GroupTableModel extends TimeTableAbstractTableModel<Group> {

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Group Number", "Group Code Id", "Course"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, Integer.class, Integer.class, String.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Group group = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return group.getId();
            case 1: return group.getGroupNumber();
            case 2: return group.getIdGroupCode().getId();
            case 3: return group.getCourse();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 2 && columnIndex != 0;
    }

    @Override
    protected Group doUpdate(Group group, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: group.setId((Long) aValue); break;
            case 1: group.setGroupNumber((Integer) aValue); break;
            // defer case 2: group.setIdGroupCode(aValue.).getId(); break;
            case 3: group.setCourse((String) aValue); break;
            default:
                break;
        }
        return group;
    }

    @Override
    protected CRUDService<Group, ?> getService() {
        return PersistenceConfig.getInstance().getGroupService();
    }
}
