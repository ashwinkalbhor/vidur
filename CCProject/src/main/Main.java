package main;

import gui.GUI;
import javax.swing.JFrame;

public class Main {
	
	
	public static void main(String[] args){
		setGUI(1200,750);
		
	}
	
	
	public static void setGUI(int width, int height){
		GUI displayGUI = new GUI("CCPanel");
		displayGUI.setSize(width, height);
		displayGUI.setResizable(true);
		displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayGUI.setLayout(null);
		displayGUI.setVisible(true);
	}
}
