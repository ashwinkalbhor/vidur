package logic.events;

import gui.events.Messages;
import image.control.HandleImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import logic.control.CountColonies;

public class ProcessImageEvent extends MouseAdapter {
	private HandleImage imageHandler;
	private int counter;
	private JTextField count;
	private CountColonies countColonies;
/**
 * Constructor for the ProcessImageEvent class
 * @param imageHandler : 
 * @param count
 */
	public ProcessImageEvent(final HandleImage imageHandler,
		final JTextField count ) {
		this.imageHandler = imageHandler;
		this.count = count;
	}

	@Override
	public final void mousePressed(final MouseEvent me) {
		super.mousePressed(me);
		countColonies = new CountColonies(imageHandler.getPImage());
		counter = countColonies.getColonyCount();
		count.setText(Messages.getString("ProcessImageEvent.1")
				+ counter); //$NON-NLS-1$
	}

}
