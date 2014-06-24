/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.absenceperiod;

import ga.thesis.gui.components.ComboBoxRenderer;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxRendererMatrix;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxRendererPeriod;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxWorkerMatrix;
import ga.thesis.gui.table.common.table.AbsencePeriodComboBoxWorkerPeriod;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.*;

import javax.swing.*;
import java.awt.*;

public class AbsencePeriodSettingsEditor extends JPanel implements Editor<AbsencePeriod> {
    public AbsencePeriodSettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        panel1 = new JPanel();
        label5 = new JLabel();
        periodId = new JComboBox();
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
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {47, 27, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Period");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(periodId, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("AbsenceMatrix");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(absenceMatrixId, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }

    private JComboBox<Period> getPeriodField() {
        JComboBox<Period> periodId = new JComboBox<Period>();
        periodId.setRenderer(new AbsencePeriodComboBoxRendererPeriod());
        new AbsencePeriodComboBoxWorkerPeriod(periodId).execute();
        return periodId;
    }


    private JComboBox<AbsenceMatrix> getMatrixField() {
        JComboBox<AbsenceMatrix> matrix = new JComboBox<AbsenceMatrix>();
        matrix.setRenderer(new AbsencePeriodComboBoxRendererMatrix());
        new AbsencePeriodComboBoxWorkerMatrix(matrix).execute();
        return matrix;
    }



    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public AbsencePeriod getModel() {
        return commit();
    }

    private AbsencePeriod commit() {
        ComboBoxModel period = periodId.getModel();
        ComboBoxModel matrix = absenceMatrixId.getModel();
        AbsencePeriod absencePeriod = new AbsencePeriod();
        absencePeriod.setIdPeriod(((Period) period.getSelectedItem()));
        absencePeriod.setIdAbsenceMatrix(((AbsenceMatrix) matrix.getSelectedItem()));
        return absencePeriod;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JPanel panel1;
    private JLabel label5;
    private JComboBox periodId;
    private JLabel label6;
    private JComboBox absenceMatrixId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
