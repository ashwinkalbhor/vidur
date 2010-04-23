package gui.control;

import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * This class sets ImageHanling object and displays Image.
 * @author ASHWIN
 * @version : 1.0;
 */
public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 4756979408320177070L;
    private ImageHandler imageHandler;

    /**
     * Constructor to initialize PApplet object for givrn File Path.
     * @param path : It takes Image File path as argument.
     */
    public ImagePanel(String path) {
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setLayout(null);
        imageHandler = new ImageHandler(path);
        add(imageHandler);
        imageHandler.init();
        imageHandler.setSize(550, 400);
    }

    public HandleImage getPApplet() {
        return imageHandler;
    }

    /**
     * Method to get ImageHandling Object.
     * @return : It returns object of Image Handling class.
     */
    public HandleImage getImageHandler() {
        return imageHandler;
    }

    public void setImageHandler(ImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }
}
