package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import control.ImageHandler;

public class ImagePanel1 extends JPanel{
	ImageHandler IH;
	public ImagePanel1(String path){
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		setLayout(null);
		
		IH = new ImageHandler(path);
		this.add(IH);
		IH.init();
		IH.setSize(550, 400);
	}
	
	public ImageHandler getPApplet(){
		return IH;
	}
	
	

}
