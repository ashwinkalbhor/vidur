package gui.control;

import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * This class creates and supports the object of ImageHandler.
 * @author ASHWIN
 * @version : 1.0
 */
public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 4756979408320177070L;
	/**
	 * @param imageHandeler : Object of Imagehandler Class.
	 */
	private static ImageHandler imageHandeler;
	/**
	 * @param imageWidth : Sets the width of imageHandeler object.
	 */
	private static final int pappletWidth = 550;
	/**
	 * @param pappletHeight : Sets the height of imageHandeler object.
	 */
	private static final int pappletHeight = 400;
	/**
	 * Constructor for ImagePanel class.
	 * @param path : Path for the Image that needs to be passed to imageHandeler object.
	 */
	public ImagePanel(String path) {
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		setLayout(null);
		imageHandeler = new ImageHandler(path);
		add(imageHandeler);
		imageHandeler.init();
		imageHandeler.setSize(pappletWidth, pappletHeight);
	}

	public HandleImage getPApplet() {
		return imageHandeler;
	}

}
