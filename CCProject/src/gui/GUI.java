package gui;

import javax.swing.JFrame;

public class GUI extends JFrame {
	private static final long serialVersionUID = -591008432209644219L;
		private  String s="data/Images/1.jpg";
		
	public GUI(String frameName){
		super(frameName);
		
		
		
		ImagePanel1 ip1 = new ImagePanel1(s);
		ip1.setBounds(20, 20, 550, 400);
		this.add(ip1);
		
		ImagePanel1 ip2 = new ImagePanel1(s);
		ip2.setBounds(600, 20, 550, 400);
		this.add(ip2);
				
		ControlPanel controlPanel = new ControlPanel(ip1,ip2);
		controlPanel.setBounds(20,450, 1150, 310);
		add(controlPanel);
		System.out.println(frameName);
	
	}
	
}
