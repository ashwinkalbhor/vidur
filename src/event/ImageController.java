package event;

//import javax.swing.JSlider;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class ImageController implements ChangeListener {
	private ImageHandler ih;

	public ImageController(ImageHandler ih) {
		this.ih = ih;
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		JSlider js = (JSlider) ce.getSource();
		ih.setScale(js.getValue() * 2.0f);
		ih.redraw();

	}

}
