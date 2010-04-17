package image.events;

import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ImageTransferEvent extends MouseAdapter {
	private ImageHandler ih1, ih2;

	public ImageTransferEvent(final ImageHandler ih1, final ImageHandler ih2) {
		this.ih2 = ih2;
		this.ih1 = ih1;
	}

	@Override
	public final void mousePressed(final MouseEvent me) {
		super.mousePressed(me);
		ih2.setThresholdParam();
		if (ih1.getCircleDrawnParam()) {
			ih2.setDimForSubImage(ih1.getPImage()
					, ih1.getCircleRadius());
			ih2.drawSubImage(ih1.getPImage() , ih1.getX() ,
					ih1.getY() , ih1.getCircleRadius());
			ih2.redraw();
		}

	}
}
