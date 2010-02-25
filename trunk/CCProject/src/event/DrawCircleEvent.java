package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class DrawCircleEvent extends MouseAdapter {
	private ImageHandler ih;
	public DrawCircleEvent(ImageHandler ih){
		this.ih = ih;
	}
	
	public void mousePressed(MouseEvent me){
		super.mousePressed(me);
		ih.setStrokeWeight(255);
		ih.setCIRCLE_DRAWN_param(true);
		ih.redraw();
	}
}
