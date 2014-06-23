package ga.thesis.gui.table.common.components;


import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.async.ComboBoxSwingWorker;
import ga.thesis.hibernate.entities.HasId;

import javax.swing.*;
import java.awt.*;

/**
 * Custom class for adding elements in the JComboBox.
 */
public abstract class AbstractComboBoxEditor<U extends HasId<?>> extends DefaultCellEditor {

    public AbstractComboBoxEditor() {
        super(new JComboBox<U>());
        JComboBox<U> component = (JComboBox<U>) getComponent();
        component.setRenderer(getRenderer());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        getWorker( (JComboBox<U>) getComponent(), (U) value ).execute();
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    protected abstract ComboBoxSwingWorker<U> getWorker(JComboBox<U> combobox, U value);
    protected abstract ComboBoxRenderer<U> getRenderer();
}