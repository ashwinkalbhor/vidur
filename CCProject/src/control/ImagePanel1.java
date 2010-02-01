package control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel1 extends JPanel{
	//private String path;
	//private ImageHandler IH;
	public ImagePanel1(String path){
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		setLayout(null);
		ImageHandler IH = new ImageHandler(path);
		this.add(IH);
		IH.setSize(550, 400);
		IH.init();
		IH.setup();
		IH.draw();
		
	}
	
	

}
