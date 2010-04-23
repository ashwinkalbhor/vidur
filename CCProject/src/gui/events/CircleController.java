package gui.events;


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
     * @param ih : Receives object ImageHandler class. 
     */
    public CircleController(ImageHandler ih) {
        imageHandler = ih;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider jSlider = (JSlider) ce.getSource();

        // System.out.println(js.getValue());
        imageHandler.setCircleRadius(jSlider.getValue() * 2.0f);
        imageHandler.redraw();
    }
}
