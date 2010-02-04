package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import control.DrawCircle;
import control.ImageHandler;

public class ImagePanel1 extends JPanel{
	//private String path;
	ImageHandler IH;
	DrawCircle dc;
	public ImagePanel1(String path){
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		setLayout(null);
		
		
		DrawCircle dc = new DrawCircle();
		dc.init();
		dc.setup();
		dc.draw(100);
		dc.setSize(550, 400);

		
		IH = new ImageHandler(path);
		this.add(IH);
		this.add(dc);
		IH.init();
		IH.setup();
		
		//IH.draw();
		IH.setSize(550, 400);
		
		
		
		
	}
	
	public ImageHandler getPApplet(){
		return IH;
	}
	
	

}
