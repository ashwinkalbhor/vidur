package image.events;

import image.control.ImageHandler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageController implements ChangeListener {
    private ImageHandler imageHandler;

    public ImageController(ImageHandler ih) {
        imageHandler = ih;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        //JSlider jSlider = (JSlider) ce.getSource();
        imageHandler.redraw();
    }
}
