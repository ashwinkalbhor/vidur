package control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

import event.ImageThresholdEvent;


public class ProcessImage extends JPanel {
	private ImageHandler ih;
	private JSlider thresholder;
	private JSlider dilater;
	public ProcessImage(ImageHandler ih){
		this.ih = ih;
		setBorder(BorderFactory.createLineBorder(new Color(255,255,0)));
		setLayout(null);
		
		thresholder = new JSlider(0,100);
		thresholder.setSize(300, 100);
		thresholder.setMajorTickSpacing(10);
		thresholder.setMinorTickSpacing(1);
		thresholder.setPaintLabels(true);
		thresholder.setPaintTicks(true);
		ImageThresholdEvent ite = new ImageThresholdEvent(ih);
		thresholder.addChangeListener(ite);
		add(thresholder);
	}
	
	
}
