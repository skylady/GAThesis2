package ga.thesis.gui.table.settings.common;

import javax.swing.*;

public interface Editor<T> {
    public JPanel getEditor();

    public T getModel();
}
