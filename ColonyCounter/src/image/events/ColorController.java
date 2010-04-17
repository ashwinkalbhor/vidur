package image.events;

import gui.events.Messages;
import image.control.ImageColorController;
import image.control.ImageHandler;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ColorController implements ChangeListener {
	private ImageHandler ih;
	private JLabel jl;
	private ImageColorController icc; 
	public ColorController(ImageHandler ih, JLabel jl) {
		// TODO Auto-generated constructor stub
		this.jl = jl;
		this.ih = ih;
		
	}

	public void stateChanged(ChangeEvent ce) {
		//JSlider js = (JSlider) ce.getSource();
		icc= new ImageColorController(ih.getPImage());
		 //System.out.println(js.getValue());
		if (jl.getText() == Messages.getString("ColorController.0")) { //$NON-NLS-1$
			JSlider js = (JSlider) ce.getSource();
			System.out.println(js.getValue());
			icc.SetR(js.getValue());
			icc.redraw();
			ih.setPImage(icc.getPImage());
			ih.redraw();
		}
		if (jl.getText() == Messages.getString("ColorController.1")) { //$NON-NLS-1$
			JSlider js = (JSlider) ce.getSource();
			System.out.println(js.getValue());
			icc.SetB(js.getValue());
			icc.redraw();
			ih.setPImage(icc.getPImage());
			ih.redraw();
		}
		if (jl.getText() == Messages.getString("ColorController.2")) { //$NON-NLS-1$
			JSlider js = (JSlider) ce.getSource();
			System.out.println(js.getValue());
			icc.SetG(js.getValue());
			icc.redraw();
			ih.setPImage(icc.getPImage());
			ih.redraw();
		}
		

	}
}
