package main;

//import java.awt.Dimension;
//import java.awt.Toolkit;

import gui.GUI;
import javax.swing.JFrame;
import javax.swing.UIManager;
//import com.jtattoo.plaf.*;
public class Main {
	
	
	public static void main(String[] args){
		try{
		UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Dimension scrnsize = toolkit.getScreenSize();
		setGUI(1200,800);
		}
		
		catch(Exception e){
			e.getStackTrace();
		}
		
	}
	
	
	public static void setGUI(int width, int height){
		GUI displayGUI = new GUI("CCPanel",width,height);
		displayGUI.setSize(width, height);
		displayGUI.setResizable(true);
		displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayGUI.setLayout(null);
		//displayGUI.setResizable(false);
		displayGUI.setVisible(true);
	}
}
