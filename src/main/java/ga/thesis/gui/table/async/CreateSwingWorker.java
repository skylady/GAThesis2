package ga.thesis.gui.table.async;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.hibernate.service.CRUDService;

import javax.swing.*;
import java.util.List;

public class CreateSwingWorker<T> extends SwingWorker<T, T> {

    private CRUDService<T, ?> service;
    private T model;
    private AbstractSettingsDialog<T> dialog;

    public CreateSwingWorker(CRUDService<T, ?> service, AbstractSettingsDialog<T> dialog, T model) {
        this.service = service;
        this.model = model;
        this.dialog = dialog;
    }

    public T doInBackground() {
        service.create(model);
        publish(model);
        return model;
    }

    @Override
    protected void process(List<T> chunks) {
        if (chunks == null || chunks.size() < 1) {
            return;
        }
        JOptionPane.showMessageDialog(dialog, "Persisted in DB");
        dialog.onAfterSave(chunks.get(0));
    }
}