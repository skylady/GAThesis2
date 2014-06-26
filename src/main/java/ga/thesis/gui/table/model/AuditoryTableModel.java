package ga.thesis.gui.table.model;

import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

public class AuditoryTableModel extends TimeTableAbstractTableModel<Auditory> {

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"id", "Auditory Number", "Auditory Size", "Auditory Type"};
    }

    @Override
    public Class[] getColumnClasses() {
        return new Class[] {Long.class, String.class,  Integer.class, String.class };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auditory auditory = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return auditory.getId();
            case 1: return auditory.getAuditoryNumber();
            case 2: return auditory.getAuditorySize();
            case 3: return auditory.getAuditoryType();
            default: throw new ColumnNotFoundException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    protected Auditory doUpdate(Auditory auditory, Object aValue, int columnIndex) {
        switch (columnIndex) {
            case 0: auditory.setId((Long) aValue); break;
            case 1: auditory.setAuditoryNumber((String) aValue); break;
            case 2: auditory.setAuditorySize((Integer) aValue); break;
            case 3: auditory.setAuditoryType((String) aValue); break;
            default:
                break;
        }
        return auditory;
    }

    @Override
    protected CRUDService<Auditory, ?> getService() {
        return PersistenceConfig.getInstance().getAuditoryService();
    }
}
