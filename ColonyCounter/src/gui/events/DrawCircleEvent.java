package gui.events;

import image.control.ImageColorController;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DrawCircleEvent extends MouseAdapter {
	private ImageHandler ih;
	private ImageColorController icc;

	public DrawCircleEvent(ImageHandler ih,ImageColorController icc) {
		this.ih = ih;
		this.icc = icc;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		ih.setStrokeWeight(255);
		ih.setCircleDrawnParam(true);
		icc.setCIRCLE_DRAWN_PARAM(true);
		icc.redraw();
		ih.redraw();
	}
}
