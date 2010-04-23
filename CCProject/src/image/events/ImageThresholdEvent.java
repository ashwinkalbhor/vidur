package image.events;

import image.control.HandleImage;
import image.control.ImageColorController;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This Class is for ...
 * @author ASHWIN
 *
 */
public class ImageThresholdEvent implements ChangeListener {
    private ImageColorController imageColorController;

    /**
     * @param ImageHandling
     */
    private HandleImage handleImage;

    public ImageThresholdEvent(HandleImage handleImage, ImageColorController imageColorController) {
        this.handleImage  = handleImage;
        this.imageColorController = imageColorController;
    }

    @Override
    public final void stateChanged(final ChangeEvent ce) {

        // TODO Auto-generated method stub
        JSlider js = (JSlider) ce.getSource();

        imageColorController.setThresholdLevel(js.getValue());
        imageColorController.redraw();
        handleImage.setPImage(handleImage.getPImage());
        handleImage.setThresholdLevel(js.getValue());
        handleImage.redraw();
    }
}

