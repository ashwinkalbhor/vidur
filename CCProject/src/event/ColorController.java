package event;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class ColorController implements ChangeListener{
	private ImageHandler ih;
	private JLabel jl;
	public ColorController(ImageHandler ih,JLabel jl) {
		// TODO Auto-generated constructor stub
		this.jl = jl;
		this.ih = ih;
	}

	public void stateChanged(ChangeEvent ce) {
		JSlider js=(JSlider) ce.getSource();
		//System.out.println(js.getValue());
		if(jl.getText()=="Red"){
			ih.setRed(js.getValue());
		}
		if(jl.getText()=="Blue"){
			ih.setBlue(js.getValue());
		}
		if(jl.getText()=="Green"){
			ih.setGreen(js.getValue());
		}
		ih.redraw();
		
	}
}
