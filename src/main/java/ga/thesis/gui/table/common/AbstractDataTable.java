/*
 * Created by JFormDesigner on Sun Jun 22 20:03:21 EEST 2014
 */

package ga.thesis.gui.table.common;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ga.thesis.gui.table.settings.common.AbstractSettingsDialog.SaveListener;

/**
 * @author Marianna Pasichnyk
 */
public abstract class AbstractDataTable<T, M extends TableModel> extends JPanel {
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

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
