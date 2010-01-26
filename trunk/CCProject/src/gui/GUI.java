package gui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import control.ControlPanel;
import control.ImagePanel1;
import event.BrowseHandler;

public class GUI extends JFrame {
		private String s;
	public GUI(String frameName){
		super(frameName);
		
		Container contains = getContentPane();
		ImagePanel1 IP = new ImagePanel1(s);
		IP.setBounds(20, 20, 550, 400);
		add(IP);
		ControlPanel controlPanel = new ControlPanel(IP);
		controlPanel.setBounds(20,450, 1150, 310);
		add(controlPanel);
		
		//add(IP);
		
		
	}
	
}
