package main;

import gui.control.GUI;


//import java.awt.Dimension;
//import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(Messages.getString("Main.0"));

            //Toolkit   toolkit  = Toolkit.getDefaultToolkit();
            //Dimension scrnsize = toolkit.getScreenSize();
            setGUI(1200, 750);
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void setGUI(final int width, final int height) {
        GUI displayGUI = new GUI(Messages.getString("Main.1"), width, height);    // $NON-NLS-1$

        displayGUI.setSize(width, height);
        displayGUI.setResizable(true);
        displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayGUI.setLayout(null);
        displayGUI.setVisible(true);
        displayGUI.setResizable(false);
    }
}

