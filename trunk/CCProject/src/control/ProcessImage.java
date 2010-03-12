package control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import event.ImageThresholdEvent;

public class ProcessImage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private ImageHandler ih;
	private JSlider thresholder;
	private JSlider dilater;
	private JLabel Threshold;
	private JLabel Dilate;
	private JLabel Processor;

	public ProcessImage(ImageHandler ih) {
		// this.ih = ih;
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		setLayout(null);

		Processor = new JLabel(Messages.getString("ProcessImage.0")); //$NON-NLS-1$
		Processor.setSize(120, 20);
		Processor.setLocation(10, 10);
		Processor.setName(Messages.getString("ProcessImage.1")); //$NON-NLS-1$
		add(Processor);

		Threshold = new JLabel(Messages.getString("ProcessImage.2")); //$NON-NLS-1$
		Threshold.setSize(80, 20);
		Threshold.setLocation(10, 35);
		Threshold.setLabelFor(thresholder);
		add(Threshold);

		thresholder = new JSlider(0, 100);
		thresholder.setLocation(10, 60);
		thresholder.setSize(300, 50);
		thresholder.setMajorTickSpacing(30);
		thresholder.setMinorTickSpacing(3);
		thresholder.setPaintLabels(true);
		thresholder.setPaintTicks(true);
		ImageThresholdEvent ite = new ImageThresholdEvent(ih);
		thresholder.addChangeListener(ite);
		add(thresholder);

		Dilate = new JLabel(Messages.getString("ProcessImage.3")); //$NON-NLS-1$
		Dilate.setSize(50, 20);
		Dilate.setLocation(10, 115);
		Dilate.setLabelFor(dilater);
		add(Dilate);

		dilater = new JSlider(0, 100);
		dilater.setLocation(10, 140);
		dilater.setSize(300, 50);
		dilater.setMajorTickSpacing(30);
		dilater.setMinorTickSpacing(3);
		dilater.setPaintLabels(true);
		dilater.setPaintTicks(true);
		// ImageDilaterEvent ide = new ImageDilaterEvent(ih);
		// dilater.addChangeListener(ide);
		add(dilater);

	}

}
