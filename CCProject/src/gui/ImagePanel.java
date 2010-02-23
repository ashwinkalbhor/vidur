package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import control.ImageHandler;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 4756979408320177070L;
	private ImageHandler IH;
	
	public ImagePanel(String path){
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
