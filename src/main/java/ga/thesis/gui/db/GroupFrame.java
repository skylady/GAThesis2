/*
 * Created by JFormDesigner on Mon Jun 23 01:35:47 EEST 2014
 */

package ga.thesis.gui.db;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mike Kravchenko
 */
public class GroupFrame extends JFrame {
    public GroupFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mike Kravchenko
        dBData1 = new DBData(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(dBData1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mike Kravchenko
    private DBData dBData1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
