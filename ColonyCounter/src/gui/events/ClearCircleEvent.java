package gui.events;

import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClearCircleEvent extends MouseAdapter {
	private ImageHandler ih;

	public ClearCircleEvent(ImageHandler ih) {
		this.ih = ih;

	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mouseClicked(me);
		ih.setCircleDrawnParam(false);
		ih.setStrokeWeight(0);
		ih.redraw();
	}
}
