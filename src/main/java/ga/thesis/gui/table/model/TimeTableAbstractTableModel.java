package ga.thesis.gui.table.model;

import ga.thesis.gui.table.async.UpdateSwingWorker;
import ga.thesis.hibernate.service.CRUDService;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public abstract class TimeTableAbstractTableModel<T> extends AbstractTableModel {
    protected List<T> rows = new ArrayList<T>();

    public TimeTableAbstractTableModel() {
    }

    public void reload(List<T> list) {
        this.rows = list;
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object valueAt = getValueAt(rowIndex, columnIndex);

        if (aValue.equals(valueAt)) {
            return;
        }

        T group = rows.get(rowIndex);
        T updated = doUpdate(group, aValue, columnIndex);
        updateInDb(updated, rowIndex, columnIndex);
    }

    private void updateInDb(T model, final int rowIndex, final int columnIndex) {
        new UpdateSwingWorker<T>(getService(), this, model, rowIndex, columnIndex).execute();
    }

    protected abstract T doUpdate(T group, Object value, int columnIndex);

    protected abstract CRUDService<T, ?> getService();

    public int getRowCount() {
        return rows.size();
    }

    public abstract int getColumnCount();

    public abstract String[] getColumnNames();

    public abstract Class[] getColumnClasses();

    public String getColumnName(int col) {
        return getColumnNames()[col];
    }

    public Class<?> getColumnClass(int col) {
        return getColumnClasses()[col];
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public static class ColumnNotFoundException extends RuntimeException {
        private final int column;

        public ColumnNotFoundException(int column) {
            this.column = column;
        }

        @Override
        public String toString() {
            return super.toString() + " at column " + column;
        }
    }
}
