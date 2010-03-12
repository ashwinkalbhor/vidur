package event;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class ImageThresholdEvent implements ChangeListener {
	private ImageHandler ih;

	public ImageThresholdEvent(ImageHandler ih) {
		this.ih = ih;
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		// TODO Auto-generated method stub
		JSlider js = (JSlider) ce.getSource();
		ih.setThresholdLevel(js.getValue());
		ih.redraw();
	}

}
