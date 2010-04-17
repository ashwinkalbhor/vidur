package image.control;

import gui.control.Messages;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.events.ProcessImageEvent;



public class CalculateControl extends JPanel {
	private static final long serialVersionUID = 2636247746338890880L;
	private JButton process;
	private JTextField count;

	// private ImageHandler ih;
	public CalculateControl(HandleImage ih) {
		// this.ih = ih;

		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		this.setLayout(new GridLayout(2, 1));
		count = new JTextField(Messages.getString("CalculateControl.0")); //$NON-NLS-1$
		count.setBounds(100, 30, 350, 40);

		process = new JButton(Messages.getString("CalculateControl.1")); //$NON-NLS-1$
		process.setBounds(10, 30, 80, 40);
		ProcessImageEvent pie = new ProcessImageEvent(ih, count);
		process.addMouseListener(pie);
		add(process);
		add(count);

	}
}
