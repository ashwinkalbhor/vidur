package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

import processing.core.PApplet;

public class ImageController implements ChangeListener{
	private JSlider js;
	private ImageHandler ih;
	public ImageController(ImageHandler ih){
		this.ih= ih;
	}
	
	
	@Override
	public void stateChanged(ChangeEvent ce) {
		JSlider js=(JSlider) ce.getSource();
		System.out.println(js.getValue());
		ih.setScale(js.getValue()/20.0f);
		ih.redraw();
		
	}
	
	
}
