package gui;

import java.awt.Container;
import javax.swing.JFrame;

public class GUI extends JFrame {
		private static String s="data/Images/1.jpg";
	public GUI(String frameName){
		super(frameName);
		
		
		Container contains = getContentPane();
		ImagePanel1 IP = new ImagePanel1(s);
		IP.setBounds(20, 20, 550, 400);
		
		this.add(IP);
		
		
		ControlPanel controlPanel = new ControlPanel(IP);
		controlPanel.setBounds(20,450, 1150, 310);
		add(controlPanel);
		//add(IP);
		System.out.println(frameName);
	
	}
	
}
