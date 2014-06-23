/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.group;

import ga.thesis.gui.table.common.table.GroupCodeComboBoxRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorker;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mike Kravchenko
 */
public class GroupSettingsEditor extends JPanel implements Editor<Group> {
    public GroupSettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mike Kravchenko
        panel1 = new JPanel();
        label5 = new JLabel();
        groupNumber = new JTextField();
        label6 = new JLabel();
        groupCodeId = getGroupCodeField();
        label7 = new JLabel();
        course = new JTextField();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout) panel1.getLayout()).columnWidths = new int[]{101, 175, 0};
            ((GridBagLayout) panel1.getLayout()).rowHeights = new int[]{70, 27, 73, 0};
            ((GridBagLayout) panel1.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
            ((GridBagLayout) panel1.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Group Number");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(groupNumber, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("Group Code");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(groupCodeId, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label7 ----
            label7.setText("Course");
            panel1.add(label7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(course, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }

    private JComboBox<GroupCode> getGroupCodeField() {
        JComboBox<GroupCode> groupCodeId = new JComboBox<GroupCode>();
        groupCodeId.setRenderer(new GroupCodeComboBoxRenderer());
        new GroupCodeComboBoxWorker(groupCodeId).execute();
        return groupCodeId;
    }

    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public Group getModel() {
        return commit();
    }

    private Group commit() {
        String groupNumberText = groupNumber.getText();
        ComboBoxModel groupCode = groupCodeId.getModel();
        String courseText = course.getText();
        Group group = new Group();
        group.setGroupNumber(Integer.valueOf(groupNumberText));
        group.setIdGroupCode(((GroupCode) groupCode.getSelectedItem()));
        group.setCourse(courseText);
        return group;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mike Kravchenko
    private JPanel panel1;
    private JLabel label5;
    private JTextField groupNumber;
    private JLabel label6;
    private JComboBox groupCodeId;
    private JLabel label7;
    private JTextField course;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
