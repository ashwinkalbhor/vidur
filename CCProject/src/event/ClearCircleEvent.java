package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class ClearCircleEvent extends MouseAdapter {
	private ImageHandler ih;

	public ClearCircleEvent(ImageHandler ih) {
		this.ih = ih;

	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mouseClicked(me);
		ih.setCIRCLE_DRAWN_param(false);
		ih.setStrokeWeight(0);
		ih.redraw();
	}
}
