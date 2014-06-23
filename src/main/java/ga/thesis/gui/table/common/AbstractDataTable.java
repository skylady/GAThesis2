/*
 * Created by JFormDesigner on Sun Jun 22 20:03:21 EEST 2014
 */

package ga.thesis.gui.table.common;

import ga.thesis.gui.table.model.TimeTableAbstractTableModel;
import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static ga.thesis.gui.table.settings.common.AbstractSettingsDialog.SaveListener;

/**
 * @author Marianna Pasichnyk
 */
public abstract class AbstractDataTable<T, M extends TimeTableAbstractTableModel<T>> extends JPanel {
    protected JFrame frame;

    public AbstractDataTable(JFrame parent) {
        this.frame = parent;
        initComponents();
    }

    private void init() {
        dataTable.setModel(getDefaultModel());
    }

    private void addButtonActionPerformed(ActionEvent e) {
        getDialog().setVisible(true);
    }

    private void loadButtonActionPerformed(ActionEvent e) {
        doLoad();
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        int[] selectedRows = dataTable.getSelectedRows();
        if (selectedRows == null || selectedRows.length < 1) {
            return;
        }
        List<T> selected = new ArrayList<T>();
        for (Integer i: selectedRows) {
            int index = dataTable.convertRowIndexToModel(i);
            T model = ((M) dataTable.getModel()).getAtRow(index);
            selected.add(model);
        }
        doDelete(selected);
    }

    protected abstract void doDelete(List<T> selected);

    protected abstract void doLoad();

    protected abstract M getDefaultModel();

    protected abstract AbstractSettingsDialog<T> getDialog();

    public class SaveListenerImpl<T> implements SaveListener<T> {
        @Override
        public void onSave(T model) {
            doLoad();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mike Kravchenko
        scrollPane2 = new JScrollPane();
        dataTable = new JTable();
        toolBar1 = new JToolBar();
        loadButton = new JButton();
        addButton = new JButton();
        deleteButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new BorderLayout());

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(dataTable);
        }
        add(scrollPane2, BorderLayout.CENTER);

        //======== toolBar1 ========
        {
            toolBar1.setBorderPainted(false);

            //---- loadButton ----
            loadButton.setText("load");
            loadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadButtonActionPerformed(e);
                }
            });
            toolBar1.add(loadButton);

            //---- addButton ----
            addButton.setText("+");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addButtonActionPerformed(e);
                }
            });
            toolBar1.add(addButton);

            //---- deleteButton ----
            deleteButton.setText("-");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteButtonActionPerformed(e);
                }
            });
            toolBar1.add(deleteButton);
        }
        add(toolBar1, BorderLayout.NORTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        init();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mike Kravchenko
    private JScrollPane scrollPane2;
    protected JTable dataTable;
    private JToolBar toolBar1;
    private JButton loadButton;
    private JButton addButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
