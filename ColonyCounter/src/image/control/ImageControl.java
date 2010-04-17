package image.control;

import gui.events.CircleController;
import image.events.ImageController;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;


/**
 * This class controls the display of Image through PApplet class.
 * @author ASHWIN
 *
 */
public class ImageControl extends JPanel {
	private static final long serialVersionUID = 8244529568780449188L;
	private JSlider imageScale;
	private JSlider scaleRadius;
/**
 * Constructor for ImageControl class , displays ImageHandler Object on Jpanel.
 * @param imageHandler1
 * @param imageHandler2
 */
	public ImageControl(ImageHandler imageHandler1, ImageHandler imageHandler2) {
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		GridLayout gbl = new GridLayout(2, 2);
		this.setLayout(gbl);
		imageScale = new JSlider(0, 100);
		imageScale.setSize(300, 50);
		imageScale.setMajorTickSpacing(10);
		imageScale.setMinorTickSpacing(5);
		imageScale.setPaintLabels(true);
		imageScale.setPaintTicks(true);
		ImageController ic = new ImageController(imageHandler2);
		imageScale.addChangeListener(ic);
		add(imageScale);

		scaleRadius = new JSlider(0, 200);
		scaleRadius.setSize(300, 50);
		scaleRadius.setMajorTickSpacing(20);
		scaleRadius.setMinorTickSpacing(10);
		scaleRadius.setPaintLabels(true);
		scaleRadius.setPaintTicks(true);
		CircleController cc = new CircleController(imageHandler1);
		scaleRadius.addChangeListener(cc);
		add(scaleRadius);

	}
}
