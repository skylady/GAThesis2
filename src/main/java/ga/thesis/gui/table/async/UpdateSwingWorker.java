package ga.thesis.gui.table.async;

import ga.thesis.gui.table.model.TimeTableAbstractTableModel;
import ga.thesis.hibernate.service.CRUDService;

import javax.swing.*;
import java.util.List;

public class UpdateSwingWorker<T> extends SwingWorker<T, T> {

    private CRUDService<T, ?> service;
    private TimeTableAbstractTableModel tableModel;
    private T model;
    private int rowIndex;
    private int columnIndex;

    public UpdateSwingWorker(CRUDService<T, ?> service, TimeTableAbstractTableModel tableModel, T model, int rowIndex, int columnIndex) {
        this.service = service;
        this.tableModel = tableModel;
        this.model = model;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public T doInBackground() {
        T updated = service.update(model);
        publish(updated);
        return updated;
    }

    @Override
    protected void process(List<T> chunks) {
        if (chunks == null || chunks.size() < 1) {
            return;
        }
        tableModel.fireTableCellUpdated(rowIndex, columnIndex);
    }
}