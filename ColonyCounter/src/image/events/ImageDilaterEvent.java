package image.events;

//import javax.swing.JSlider;
import image.control.ImageHandler;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ImageDilaterEvent implements ChangeListener {

	private ImageHandler ih;

	private ImageDilaterEvent(ImageHandler ih) {
		this.ih = ih;
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		// TODO Auto-generated method stub
		// this.stateChanged(ce);
		// JSlider js = (JSlider) ce.getSource();
		// ih.setDilateLevel(js.getValue());
		ih.redraw();
	}

}
