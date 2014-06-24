/*
 * Created by JFormDesigner on Mon Jun 23 01:47:33 EEST 2014
 */

package ga.thesis.gui.table.settings.auditory;

import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.hibernate.entities.Period;

import javax.swing.*;
import java.awt.*;

public class AuditorySettingsEditor extends JPanel implements Editor<Auditory> {
    public AuditorySettingsEditor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        panel1 = new JPanel();
        label5 = new JLabel();
        auditoryNumber = new JTextField();
        label7 = new JLabel();
        auditorySize = new JTextField();
        label8 = new JLabel();
        auditoryType = new JTextField();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder()
            ));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout) panel1.getLayout()).columnWidths = new int[]{101, 175, 0};
            ((GridBagLayout) panel1.getLayout()).rowHeights = new int[]{70, 63, 59, 0, 0};
            ((GridBagLayout) panel1.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
            ((GridBagLayout) panel1.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Auditory Number");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(auditoryNumber, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label7 ----
            label7.setText("Auditory Size");
            panel1.add(label7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(auditorySize, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label8 ----
            label8.setText("Auditory Type");
            panel1.add(label8, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(auditoryType, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        init();
    }


    private void init() {

    }

    @Override
    public JPanel getEditor() {
        return panel1;
    }

    @Override
    public Auditory getModel() {
        return commit();
    }

    private Auditory commit() {
        String auditoryNumberText = auditoryNumber.getText();
        String auditorySizeText = auditorySize.getText();
        String auditoryTypeText = auditoryType.getText();
        Auditory auditory = new Auditory();
        auditory.setAuditoryNumber(auditoryNumberText);
        auditory.setAuditorySize(Integer.valueOf(auditorySizeText));
        auditory.setAuditoryType(auditoryTypeText);
        return auditory;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JPanel panel1;
    private JLabel label5;
    private JTextField auditoryNumber;
    private JLabel label7;
    private JTextField auditorySize;
    private JLabel label8;
    private JTextField auditoryType;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
