package event;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class CircleController implements ChangeListener{
	private ImageHandler ih;
	public CircleController(ImageHandler ih){
		this.ih= ih;
	}
	
	
	@Override
	public void stateChanged(ChangeEvent ce) {
		JSlider js=(JSlider) ce.getSource();
		//System.out.println(js.getValue());
		ih.setCircleRadius(js.getValue()*2.0f);
		ih.redraw();
		
	}
}
