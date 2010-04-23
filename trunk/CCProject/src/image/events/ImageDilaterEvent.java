package image.events;

//~--- non-JDK imports --------------------------------------------------------

import image.control.ImageHandler;

//~--- JDK imports ------------------------------------------------------------

//import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageDilaterEvent implements ChangeListener {
    private ImageHandler ih;

    public ImageDilaterEvent(ImageHandler ih) {
        this.ih = ih;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {

        // TODO Auto-generated method stub
        // this.stateChanged(ce);
        // JSlider js = (JSlider) ce.getSource();
        // ih.setDilateLevel(js.getValue());
        ih.redraw();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
