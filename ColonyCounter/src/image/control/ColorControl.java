package image.control;

import gui.control.Messages;
import image.events.ColorController;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;



public class ColorControl extends JPanel {
	private static final long serialVersionUID = 3448980768705941232L;
	private JSlider ControlRed;
	private JSlider ControlGreen;
	private JSlider ControlBlue;
	private JLabel red;
	private JLabel green;
	private JLabel blue;

	public ColorControl(ImageHandler ih) {
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		GridLayout gbl = new GridLayout(3, 2);
		this.setLayout(gbl);
		ControlRed = new JSlider(0, 255);
		ControlRed.setSize(300, 50);
		ControlRed.setMajorTickSpacing(64);
		ControlRed.setMinorTickSpacing(16);
		ControlRed.setPaintLabels(true);
		ControlRed.setPaintTicks(true);
		red = new JLabel();
		red.setSize(50, 30);
		red.setText(Messages.getString("ColorControl.0")); //$NON-NLS-1$
		red.setBackground(new Color(255, 0, 0));
		red.setLabelFor(ControlRed);
		red.setForeground(new Color(255, 0, 0));
		ColorController redCol = new ColorController(ih, red);
		ControlRed.addChangeListener(redCol);
		add(ControlRed);
		add(red);

		ControlGreen = new JSlider(0, 255);
		ControlGreen.setSize(300, 50);
		ControlGreen.setMajorTickSpacing(64);
		ControlGreen.setMinorTickSpacing(16);
		ControlGreen.setPaintLabels(true);
		ControlGreen.setPaintTicks(true);
		green = new JLabel();
		green.setSize(50, 30);
		green.setText(Messages.getString("ColorControl.1")); //$NON-NLS-1$
		green.setBackground(new Color(255, 200, 20));
		green.setLabelFor(ControlGreen);
		green.setForeground(new Color(0, 255, 0));
		ColorController greenCol = new ColorController(ih, green);
		ControlGreen.addChangeListener(greenCol);
		add(ControlGreen);
		add(green);

		ControlBlue = new JSlider(0, 255);
		ControlBlue.setSize(300, 50);
		ControlBlue.setMajorTickSpacing(64);
		ControlBlue.setMinorTickSpacing(16);
		ControlBlue.setPaintLabels(true);
		ControlBlue.setPaintTicks(true);
		blue = new JLabel();
		blue.setSize(50, 30);
		blue.setText(Messages.getString("ColorControl.2")); //$NON-NLS-1$
		blue.setBackground(new Color(255, 200, 20));
		blue.setLabelFor(ControlBlue);
		blue.setForeground(new Color(0, 0, 255));
		ColorController blueCol = new ColorController(ih, blue);
		ControlBlue.addChangeListener(blueCol);
		add(ControlBlue);
		add(blue);

	}
}
