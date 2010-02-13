package gui;

import event.BrowseHandler;
import event.ImageThresholdEvent;
import event.ImageTransferEvent;
import event.LoadImageEvent;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CalculateControl;
import control.ColorControl;
import control.ImageControl;
import control.ProcessImage;

public class ControlPanel extends JPanel{
	private static final long serialVersionUID = -6581079276015103030L;
	private JTextField filePath;
	private JButton browse;
	private JButton transfer;
	private JButton loadImage;
	public ControlPanel(ImagePanel1 ip1,ImagePanel1 ip2){
		setBorder(BorderFactory.createLineBorder(new Color(255,255,0)));
		setLayout(null);
		filePath = new JTextField("Please Select file",10);
		filePath.setLocation(10,30);
		filePath.setSize(300, 30);
		add(filePath);
		
		BrowseHandler BH = new BrowseHandler(filePath,ip1,ip2);
		
		ColorControl colorControl = new ColorControl(ip2.getPApplet());
		colorControl.setBounds(10, 70, 300, 180);
		add(colorControl);
		
		ImageControl imageControl =new ImageControl(ip1.getPApplet());
		imageControl.setBounds(800, 20, 300, 100);
		add(imageControl);
		
		CalculateControl calculate=new CalculateControl();
		calculate.setBounds(800, 140, 300, 100);
		add(calculate);
		
		ProcessImage pi = new ProcessImage(ip2.getPApplet());
		pi.setBounds(460, 20, 300, 200);
		add(pi);
		
		browse = new JButton("Browse");
		browse.setLocation(350,30);
		browse.setSize(80, 30);
		browse.addMouseListener(BH);
		add(browse);
		
		loadImage = new JButton("LoadImage");
		loadImage.setLocation(350, 70);
		loadImage.setSize(80, 30);
		loadImage.addMouseListener(new LoadImageEvent(ip1.getPApplet(),BH));
		add(loadImage);
		
		transfer = new JButton("Transfer");
		transfer.setLocation(350, 100);
		transfer.setSize(80, 30);
		ImageTransferEvent ite = new ImageTransferEvent(ip1.getPApplet(),ip2.getPApplet());
		transfer.addMouseListener(ite);
		add(transfer);
			
	}

}
