package event;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class ImageDilaterEvent implements ChangeListener{
	
	private ImageHandler ih;
	
	public ImageDilaterEvent(ImageHandler ih){
		this.ih = ih;
	}
	@Override
	public void stateChanged(ChangeEvent ce) {
		// TODO Auto-generated method stub
		//this.stateChanged(ce);
		JSlider js = (JSlider) ce.getSource();
		ih.setDilateLevel(js.getValue());
		ih.redraw();
	}

}
