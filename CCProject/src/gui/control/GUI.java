package gui.control;

//~--- JDK imports ------------------------------------------------------------

import gui.Messages;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame {
    private static final long serialVersionUID = -591008432209644219L;
    private String            s                = Messages.getString("GUI.0");    // $NON-NLS-1$

    public GUI(String frameName, int width, int height) {
        super(frameName);

        Dimension d = super.getSize();

        // System.out.println(d.height);
        ImagePanel ip1 = new ImagePanel(s);

        ip1.setBounds(20, 20, 550, 400);
        this.add(ip1);

        ImagePanel ip2 = new ImagePanel(s);

        ip2.setBounds(600, 20, 550, 400);
        this.add(ip2);

        ControlPanel controlPanel = new ControlPanel(ip1, ip2);

        controlPanel.setBounds(20, 450, 1150, 260);
        add(controlPanel);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
