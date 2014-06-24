/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.groupcode;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRendererList;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxRendererTeacher;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorkerList;
import ga.thesis.gui.table.common.table.GroupCodeComboBoxWorkerTeacher;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.Teacher;

import javax.swing.*;
import java.awt.*;

public class GroupCodeSettingsEditor extends JPanel implements Editor<GroupCode> {
    public GroupCodeSettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        panel1 = new JPanel();
        label5 = new JLabel();
        subject = new JTextField();
        label6 = new JLabel();
        subjectType = new JTextField();
        label7 = new JLabel();
        weekNumbers = new JTextField();
        label8 = new JLabel();
        groupType = new JTextField();
        label9 = new JLabel();
        groupSize = new JTextField();
        label10 = new JLabel();
        teacherId = new JComboBox();
        label11 = new JLabel();
        listId = new JComboBox();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {101, 175, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {30, 27, 0, 32, 32, 31, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Subject");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(subject, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("Subject Type");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(subjectType, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label7 ----
            label7.setText("Week Numbers");
            panel1.add(label7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(weekNumbers, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label8 ----
            label8.setText("Group Type");
            panel1.add(label8, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(groupType, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label9 ----
            label9.setText("Group Size");
            panel1.add(label9, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(groupSize, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label10 ----
            label10.setText("Teacher");
            panel1.add(label10, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(teacherId, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label11 ----
            label11.setText("GroupList");
            panel1.add(label11, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(listId, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }

    private JComboBox<Teacher> getTeacherField() {
        JComboBox<Teacher> teacher = new JComboBox<Teacher>();
        teacher.setRenderer(new GroupCodeComboBoxRendererTeacher());
        new GroupCodeComboBoxWorkerTeacher(teacher).execute();
        return teacher;
    }


    private JComboBox<GroupList> getListIdField() {
        JComboBox<GroupList> listId = new JComboBox<GroupList>();
        listId.setRenderer(new GroupCodeComboBoxRendererList());
        new GroupCodeComboBoxWorkerList(listId).execute();
        return listId;
    }

    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public GroupCode getModel() {
        return commit();
    }

    private GroupCode commit() {
        String subjectText = subject.getText();
        String subjectTypeText = subjectType.getText();
        String weekNumbersText = weekNumbers.getText();
        String groupTypeText = groupType.getText();
        String groupSizeText = groupSize.getText();
        ComboBoxModel teacher = teacherId.getModel();
        ComboBoxModel list = listId.getModel();

        GroupCode groupCode = new GroupCode();
        groupCode.setSubject(subjectText);
        groupCode.setSubjectType(subjectTypeText);
        groupCode.setWeekNumbers(weekNumbersText);
        groupCode.setGroupType(groupTypeText);
        groupCode.setGroupSize(Integer.valueOf(groupSizeText));
        groupCode.setIdGroupTeacher(((Teacher) teacher.getSelectedItem()));
        groupCode.setIdGroupList(((GroupList) list.getSelectedItem()));
        return groupCode;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JPanel panel1;
    private JLabel label5;
    private JTextField subject;
    private JLabel label6;
    private JTextField subjectType;
    private JLabel label7;
    private JTextField weekNumbers;
    private JLabel label8;
    private JTextField groupType;
    private JLabel label9;
    private JTextField groupSize;
    private JLabel label10;
    private JComboBox teacherId;
    private JLabel label11;
    private JComboBox listId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
