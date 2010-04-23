package image.events;


import image.control.ImageHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageDilaterEvent implements ChangeListener {
    private ImageHandler imageHandler;

    public ImageDilaterEvent(ImageHandler ih) {
        this.imageHandler = ih;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {

        // TODO Auto-generated method stub
        // this.stateChanged(ce);
        // JSlider js = (JSlider) ce.getSource();
        // ih.setDilateLevel(js.getValue());
        imageHandler.redraw();
    }
}
