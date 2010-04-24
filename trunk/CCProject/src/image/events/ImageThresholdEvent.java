package image.events;

import image.control.HandleImage;
import image.control.ImageColorController;
import image.control.ImageHandler;

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
    private ImageHandler handleImage;

    public ImageThresholdEvent(ImageHandler handleImage,
    ImageColorController imageColorController) {
        this.handleImage  = handleImage;
        this.imageColorController = imageColorController;
    }

    @Override
    public final void stateChanged(final ChangeEvent ce) {

        // TODO Auto-generated method stub
        JSlider jSlider = (JSlider) ce.getSource();

        imageColorController.setThresholdLevel(jSlider.getValue());
        imageColorController.redraw();
        handleImage.setPImage(handleImage.getPImage());
        handleImage.setThresholdLevel(jSlider.getValue());
        handleImage.redraw();
    }
}

