/*
 * Created by JFormDesigner on Mon Jun 23 21:15:52 EEST 2014
 */

package ga.thesis.gui.main;

import ga.thesis.gui.table.impl.*;

import javax.swing.*;
import java.awt.*;

public class DatabaseEditorFrame extends JFrame {
    public DatabaseEditorFrame() {
        initComponents();
    }

    private void createUIComponents() {
        tabPanel = new JTabbedPane();
        tabPanel.add("Group", new GroupDataTable(this));
        tabPanel.add("Period", new PeriodDataTable(this));
        tabPanel.add("Auditory", new AuditoryDataTable(this));
        tabPanel.add("Absence Matrix", new AbsenceMatrixDataTable(this));
        tabPanel.add("Absence Period", new AbsencePeriodDataTable(this));
        tabPanel.add("Group Code", new GroupCodeDataTable(this));
        tabPanel.add("Group List", new GroupListDataTable(this));
        tabPanel.add("Teacher", new TeacherDataTable(this));
        tabPanel.add("Student List", new StudentListDataTable(this));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
        createUIComponents();


        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 373, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 226, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        contentPane.add(tabPanel, new GridBagConstraints(0, 0, 2, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Marianna Pasichnyk
    private JTabbedPane tabPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
