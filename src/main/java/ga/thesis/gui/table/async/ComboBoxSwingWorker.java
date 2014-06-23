package ga.thesis.gui.table.async;

import ga.thesis.hibernate.entities.HasId;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class ComboBoxSwingWorker<T extends HasId<?>> extends SwingWorker<List<T>, T> {

    private JComboBox<T> comboBox;
    private T chosenValue;
    private boolean isChosenValue;

    public ComboBoxSwingWorker(JComboBox<T> comboBox) {
        this.comboBox = comboBox;
    }

    public ComboBoxSwingWorker(JComboBox<T> comboBox, T chosenValue) {
        this.comboBox = comboBox;
        this.isChosenValue = true;
        this.chosenValue = chosenValue;
    }

    protected abstract Iterable<T> load();

    public List<T> doInBackground() {
        Iterable<T> all = load();
        List<T> result = new ArrayList<T>();
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            result.add(next);
        }
        return result;
    }

    @Override
    protected void done() {
        try {
            if (isDone()) {
                List<T> list = get();
                Vector<T> vector = new Vector<T>();
                vector.addAll(list);
                DefaultComboBoxModel<T> aModel = new DefaultComboBoxModel<T>(vector);
                if (isChosenValue && isInModel(chosenValue, list)) {
                    aModel.setSelectedItem(chosenValue);
                }
                comboBox.setModel(aModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInModel(T model, List<T> list) {
        for (T item : list) {
            if (item.getId().equals(model.getId())) {
                return true;
            }
        }
        return false;
    }
}