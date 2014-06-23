/*
 * Created by JFormDesigner on Sun Jun 22 20:03:21 EEST 2014
 */

package ga.thesis.gui.db;

import ga.thesis.gui.table.async.CustomSwingWorker;
import ga.thesis.gui.table.model.GroupTableModel;
import ga.thesis.gui.table.settings.group.GroupSettingsDialog;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.service.PersistenceConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ga.thesis.gui.table.settings.common.AbstractSettingsDialog.SaveListener;

/**
 * @author Marianna Pasichnyk
 */
public class DBData extends JPanel {
    private JFrame frame;

    public DBData(JFrame parent) {
        this.frame = parent;
        initComponents();
    }

    private void addButtonActionPerformed(ActionEvent e) {
        SaveListener saveListener = new SaveListener() {
            @Override
            public void onSave(Object model) {
                doLoad();
            }
        };
        new GroupSettingsDialog(frame, saveListener).setVisible(true);
    }

    private void loadButtonActionPerformed(ActionEvent e) {
        doLoad();
    }

    protected void doLoad() {
        new CustomSwingWorker<Group>(table1) {
            @Override
            protected Iterable<Group> load() {
                return PersistenceConfig.getInstance().getGroupService().findAll();
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mike Kravchenko
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        toolBar1 = new JToolBar();
        comboBox1 = new JComboBox();
        loadButton = new JButton();
        addButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
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
            scrollPane2.setViewportView(table1);
        }
        add(scrollPane2, BorderLayout.CENTER);

        //======== toolBar1 ========
        {
            toolBar1.add(comboBox1);

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
        table1.setModel(new GroupTableModel());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mike Kravchenko
    private JScrollPane scrollPane2;
    private JTable table1;
    private JToolBar toolBar1;
    private JComboBox comboBox1;
    private JButton loadButton;
    private JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
