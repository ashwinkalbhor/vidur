package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class DrawCircleEvent extends MouseAdapter {
	private ImageHandler ih;
	public DrawCircleEvent(ImageHandler ih){
		this.ih = ih;
	}
	
	public void mouseClicked(MouseEvent me){
		super.mouseClicked(me);
		ih.setStrokeWeight(255);
		ih.redraw();
	}
}
