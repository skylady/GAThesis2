/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.studentlist;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.table.StudentListComboBoxRendererList;
import ga.thesis.gui.table.common.table.StudentListComboBoxWorker;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;

import javax.swing.*;
import java.awt.*;

public class StudentListSettingsEditor extends JPanel implements Editor<StudentList> {
    public StudentListSettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        panel1 = new JPanel();
        label5 = new JLabel();
        studentName = new JTextField();
        label6 = new JLabel();
        groupListId = new JComboBox();

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
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {70, 22, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Student Name");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(studentName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("Group List");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(groupListId, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }

    private JComboBox<GroupList> getAbsenceMatrixField() {
        JComboBox<GroupList> groupListId = new JComboBox<GroupList>();
        groupListId.setRenderer(new StudentListComboBoxRendererList());
        new StudentListComboBoxWorker(groupListId).execute();
        return groupListId;
    }

    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public StudentList getModel() {
        return commit();
    }

    private StudentList commit() {
        String studentNameText = studentName.getText();
        ComboBoxModel groupList = groupListId.getModel();
        StudentList studentList = new StudentList();
        studentList.setStudentName(studentNameText);
        studentList.setIdGroupList(((GroupList) groupList.getSelectedItem()));
        return studentList;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JPanel panel1;
    private JLabel label5;
    private JTextField studentName;
    private JLabel label6;
    private JComboBox groupListId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
