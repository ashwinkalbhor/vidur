package image.events;

import image.control.ImageColorController;
import image.control.ImageHandler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This Class is for ...
 * @author ASHWIN
 *
 */
public class ImageThresholdEvent implements ChangeListener {
	/**
	 * @param ImageHandling
	 */
	private ImageHandler ih;
	private ImageColorController icc;
	public ImageThresholdEvent(ImageHandler ih,ImageColorController icc) {
		this.ih = ih;
		this.icc = icc;
	}

	@Override
	public final void stateChanged(final ChangeEvent ce) {
		// TODO Auto-generated method stub
		JSlider js = (JSlider) ce.getSource();
		icc.setThresholdLevel(js.getValue());
		icc.redraw();
		ih.setThresholdLevel(js.getValue());
		//ih.setPImage(icc.getPImage());
		ih.redraw();
	}

}
