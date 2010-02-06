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
import event.LoadImageEvent;

public class ControlPanel extends JPanel{
	
	private JTextField filePath;
	public JButton browse;
	private JButton loadImage;
	private ImagePanel1 ip1;
	private ImagePanel1 ip2;
	public ControlPanel(ImagePanel1 ip1,ImagePanel1 ip2){
		setBorder(BorderFactory.createLineBorder(new Color(255,255,0)));
		setLayout(null);
		this.ip1=ip1;
		this.ip2=ip2;
		filePath = new JTextField("Please Select file",10);
		filePath.setLocation(10,30);
		filePath.setSize(300, 30);
		add(filePath);
		
		BrowseHandler BH = new BrowseHandler(filePath,ip1);
		
		ColorControl colorControl = new ColorControl(ip2.getPApplet());
		colorControl.setBounds(10, 70, 300, 180);
		add(colorControl);
		
		ImageControl imageControl =new ImageControl(ip1.getPApplet());
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
		
		loadImage = new JButton("LoadImage");
		loadImage.setLocation(450, 30);
		loadImage.setSize(80, 30);
		loadImage.addMouseListener(new LoadImageEvent(ip1.getPApplet(),BH));
		add(loadImage);
		
		
			
	}

}
