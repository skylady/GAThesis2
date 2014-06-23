package ga.thesis.gui.table.async;

import javax.swing.*;
import java.util.List;

public abstract class DeleteSwingWorker<T> extends SwingWorker<Boolean, T> {

    private List<T> models;

    public DeleteSwingWorker(List<T> models) {
        this.models = models;
    }

    protected abstract void afterDelete();

    protected abstract void doDelete(T model);

    public Boolean doInBackground() {
        for (T model: models) {
            doDelete(model);
        }
        return true;
    }

    @Override
    protected void done() {
        try {
            if (get()) {
                afterDelete();
            }
        } catch (Exception e) {}
    }
}