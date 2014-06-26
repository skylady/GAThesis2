package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class GroupListTableModel extends TimeTableAbstractTableModel<GroupList> {

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Group List Name"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, String.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GroupList groupList = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return groupList.getId();
            case 1: return groupList.getGroupName();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected GroupList doUpdate(GroupList group, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: group.setId((Long) aValue); break;
            case 1: group.setGroupName((String) aValue); break;
            default:
                break;
        }
        return group;
    }

    @Override
    protected CRUDService<GroupList, ?> getService() {
        return PersistenceConfig.getInstance().getGroupListService();
    }
}
