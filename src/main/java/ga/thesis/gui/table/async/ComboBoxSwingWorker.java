package ga.thesis.gui.table.async;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ComboBoxSwingWorker<T> extends SwingWorker<List<T>, T> {

    private JComboBox<T> comboBox;

    public ComboBoxSwingWorker(JComboBox<T> comboBox) {
        this.comboBox = comboBox;
    }

    protected abstract Iterable<T> load();

    public List<T> doInBackground() {
        Iterable<T> all = load();
        List<T> result = new ArrayList<T>();
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            result.add(next);
            publish(next);
        }
        return result;
    }

    @Override
    protected void process(List<T> chunks) {
        if (chunks == null) {
            return;
        }
        for (T item : chunks) {
            comboBox.addItem(item);
        }
    }
}