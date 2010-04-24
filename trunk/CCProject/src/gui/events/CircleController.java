package gui.events;


import image.control.HandleImage;
import image.control.ImageHandler;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * Class to control the circle size.
 * @author ASHWIN
 *
 */
public class CircleController implements ChangeListener {
    private ImageHandler imageHandler;
    /**
     * Constructor for CircleController class.
     * @param handleImage : Receives object ImageHandler class.
     */
    public CircleController(ImageHandler handleImage) {
        imageHandler = (ImageHandler) handleImage;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider jSlider = (JSlider) ce.getSource();

        imageHandler.setCircleRadius(jSlider.getValue() * 2.0f);
        imageHandler.redraw();
    }
}
