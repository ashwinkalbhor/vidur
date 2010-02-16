package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class ClearCircleEvent extends MouseAdapter {
	private ImageHandler ih;
	public ClearCircleEvent(ImageHandler ih){
		this.ih = ih;
		
	}
	
	public void mouseClicked(MouseEvent me){
		super.mouseClicked(me);
		ih.ClearCircleOnClicked();
		ih.redraw();
	}
}
