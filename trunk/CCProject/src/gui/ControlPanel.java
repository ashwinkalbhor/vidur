package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CalculateControl;
import control.ColorControl;
import control.ImageControl;


import event.BrowseHandler;

public class ControlPanel extends JPanel{
	
	private JTextField filePath;
	public JButton browse;
	//private String s;
	private ImagePanel1 ip;
	public ControlPanel(ImagePanel1 ip){
		setBorder(BorderFactory.createLineBorder(new Color(255,255,0)));
		setLayout(null);
		//this.ip=ip;
		filePath = new JTextField("Please Select file",10);
		filePath.setLocation(10,30);
		filePath.setSize(300, 30);
		add(filePath);
		
		BrowseHandler BH = new BrowseHandler(filePath,ip);
		
		ColorControl colorControl = new ColorControl();
		colorControl.setBounds(10, 70, 300, 180);
		add(colorControl);
		
		ImageControl imageControl =new ImageControl();
		imageControl.setBounds(800, 20, 300, 100);
		add(imageControl);
		
		CalculateControl calculate=new CalculateControl();
		calculate.setBounds(800, 140, 300, 100);
		add(calculate);
		
		browse = new JButton("Browse");
		browse.setLocation(350,30);
		browse.setSize(80, 30);
		browse.addMouseListener(BH);
		add(browse);
			
	}

}
