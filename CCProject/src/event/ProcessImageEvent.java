package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import control.CountColonies;
import control.ImageHandler;

public class ProcessImageEvent extends MouseAdapter {
	private ImageHandler ih;
	private int counter;
	private JTextField count;
	private CountColonies cc;

	public ProcessImageEvent(ImageHandler ih, JTextField count) {
		this.ih = ih;
		this.count = count;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// working with images with black colonies against white background
		// eg.Ecoli.jpg
		super.mousePressed(me);
		cc = new CountColonies(ih, ih.getPImage());
			cc.count();
		counter = cc.getColonyCount();
//		System.out.println(Messages.getString("ProcessImageEvent.0") + counter); //$NON-NLS-1$
		count.setText(Messages.getString("ProcessImageEvent.1") + counter); //$NON-NLS-1$
	}

}
