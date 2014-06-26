/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.teacher;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.table.TeacherComboBoxRendererList;
import ga.thesis.gui.table.common.table.TeacherComboBoxWorker;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Teacher;

import javax.swing.*;
import java.awt.*;

public class TeacherSettingsEditor extends JPanel implements Editor<Teacher> {
    public TeacherSettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        panel1 = new JPanel();
        label5 = new JLabel();
        teacherName = new JTextField();
        label6 = new JLabel();
        absenceMatrixId = new JComboBox();

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
            label5.setText("Name");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(teacherName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("Absence Matrix");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(absenceMatrixId, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }

    private JComboBox<AbsenceMatrix> getAbsenceMatrixField() {
        JComboBox<AbsenceMatrix> absenceMatrixId = new JComboBox<AbsenceMatrix>();
        absenceMatrixId.setRenderer(new TeacherComboBoxRendererList());
        new TeacherComboBoxWorker(absenceMatrixId).execute();
        return absenceMatrixId;
    }

    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public Teacher getModel() {
        return commit();
    }

    private Teacher commit() {
        String teacherNameText = teacherName.getText();
        ComboBoxModel absenceMatrix = absenceMatrixId.getModel();
        Teacher teacher = new Teacher();
        teacher.setName(teacherNameText);
        teacher.setIdAbsenceMatrix(((AbsenceMatrix) absenceMatrix.getSelectedItem()));
        return teacher;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JPanel panel1;
    private JLabel label5;
    private JTextField teacherName;
    private JLabel label6;
    private JComboBox absenceMatrixId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
