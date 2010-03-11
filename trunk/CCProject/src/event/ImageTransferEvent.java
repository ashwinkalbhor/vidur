package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class ImageTransferEvent extends MouseAdapter {
	private ImageHandler ih1, ih2;

	public ImageTransferEvent(ImageHandler ih1, ImageHandler ih2) {
		this.ih2 = ih2;
		this.ih1 = ih1;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		ih2.setTHRESHOLD_PARAM();
		if (ih1.getCIRCLE_DRAWN_param()) {
			//ih2.setPImage(ih1.getPImage());
			ih2.setDimForSubImage(ih1.getPImage(), ih1.getCircleRadius());
			ih2.drawSubImage(ih1.getPImage());
			ih2.redraw();
		}

	}
}
