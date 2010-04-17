package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import gui.control.GUI;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

    // private static int x;
    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(Messages.getString("Main.0"));    // $NON-NLS-1$

          Toolkit toolkit = Toolkit.getDefaultToolkit();
          Dimension scrnsize = toolkit.getScreenSize();
          System.out.println(scrnsize.width+"\t"+scrnsize.height);
          setGUI(scrnsize.width, scrnsize.height);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected static void setGUI(final int width, final int height) {
        GUI displayGUI = new GUI(Messages.getString("Main.1"), width, height);    // $NON-NLS-1$

        displayGUI.setSize(width, height);
        displayGUI.setResizable(true);
        displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayGUI.setLayout(null);
        displayGUI.setVisible(true);
        //displayGUI.setResizable(false);

        // x = (int) Math.round(Math.random())*600;
    }
}
