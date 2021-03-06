package ga.thesis.gui.components;

import ga.thesis.gui.table.common.renderer.AbstractRenderer;

import javax.swing.*;
import java.awt.*;

public abstract class ComboBoxRenderer<T> extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        T item = (T) value;
        setText(getRenderer().render(item));
        return component;
    }

    public abstract AbstractRenderer<T> getRenderer();
}
