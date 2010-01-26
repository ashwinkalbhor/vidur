package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageController implements ChangeListener{
	private JSlider js;
	public ImageController(JSlider js){
		this.js=js;
	}
	
	
	@Override
	public void stateChanged(ChangeEvent ce) {
	}
	
	public int returnValue(){
		return js.getValue();
	}
}
