package ga.thesis.gui.table.async;

import ga.thesis.gui.table.model.TimeTableAbstractTableModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomSwingWorker<T> extends SwingWorker<List<T>, T> {

    private JTable table;

    public CustomSwingWorker(JTable table) {
        this.table = table;
    }

    protected abstract Iterable<T> load();

    public List<T> doInBackground() {
        Iterable<T> all = load();
        List<T> result = new ArrayList<T>();
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            publish(iterator.next());
        }
        return result;
    }

    @Override
    protected void process(List<T> chunks) {
        if (table.getModel() instanceof TimeTableAbstractTableModel) {
            ((TimeTableAbstractTableModel<T>) table.getModel()).reload(chunks);
        } else {
            System.out.println("smth wrong");
        }
    }
}