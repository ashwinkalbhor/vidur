package gui.control;

//~--- JDK imports ------------------------------------------------------------



import gui.events.Messages;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame {
    private static final long serialVersionUID = -591008432209644219L;
    private String            path                = Messages.getString("GUI.0");    // $NON-NLS-1$

    public GUI(String frameName, int width, int height) {
        super(frameName);

        Dimension dimension = super.getSize();

        // System.out.println(d.height);
        ImagePanel imagePanel1 = new ImagePanel(path);

        imagePanel1.setBounds(20, 20, 550, 400);
        this.add(imagePanel1);

        ImagePanel imagePanel2 = new ImagePanel(path);

        imagePanel2.setBounds(600, 20, 550, 400);
        this.add(imagePanel2);

        ControlPanel controlPanel = new ControlPanel(imagePanel1, imagePanel2);

        controlPanel.setBounds(20, 450, 1150, 260);
        add(controlPanel);
    }
}

