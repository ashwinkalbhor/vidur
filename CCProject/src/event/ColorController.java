package event;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ImageHandler;

public class ColorController implements ChangeListener {
	private ImageHandler ih;
	private JLabel jl;

	public ColorController(ImageHandler ih, JLabel jl) {
		// TODO Auto-generated constructor stub
		this.jl = jl;
		this.ih = ih;
	}

	public void stateChanged(ChangeEvent ce) {
		JSlider js = (JSlider) ce.getSource();
		// System.out.println(js.getValue());
		if (jl.getText() == Messages.getString("ColorController.0")) { //$NON-NLS-1$
			ih.setRed(js.getValue());
		}
		if (jl.getText() == Messages.getString("ColorController.1")) { //$NON-NLS-1$
			ih.setBlue(js.getValue());
		}
		if (jl.getText() == Messages.getString("ColorController.2")) { //$NON-NLS-1$
			ih.setGreen(js.getValue());
		}
		ih.redraw();

	}
}
