package image.events;

//~--- non-JDK imports --------------------------------------------------------

import gui.events.Messages;
import image.control.HandleImage;
import image.control.ImageColorController;
import image.control.ImageHandler;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorController implements ChangeListener {
    ImageColorController icc;
    private ImageHandler imageHandler;
    private JLabel       jl;

    public ColorController(HandleImage handleImage, JLabel jl) {

        // TODO Auto-generated constructor stub
        this.jl = jl;
        this.imageHandler = (ImageHandler)handleImage;
    }

    public void stateChanged(ChangeEvent ce) {

        // JSlider js = (JSlider) ce.getSource();
        icc = new ImageColorController(imageHandler.getPImage());

        // System.out.println(js.getValue());
        if (jl.getText() == Messages.getString("ColorController.0")) {    // $NON-NLS-1$
            JSlider js = (JSlider) ce.getSource();

            System.out.println(js.getValue());
            icc.SetR(js.getValue());
            icc.redraw();
            imageHandler.setPImage(icc.getPImage());
            imageHandler.redraw();
        }

        if (jl.getText() == Messages.getString("ColorController.1")) {    // $NON-NLS-1$
            JSlider js = (JSlider) ce.getSource();

            System.out.println(js.getValue());
            icc.SetB(js.getValue());
            icc.redraw();
            imageHandler.setPImage(icc.getPImage());
            imageHandler.redraw();
        }

        if (jl.getText() == Messages.getString("ColorController.2")) {    // $NON-NLS-1$
            JSlider js = (JSlider) ce.getSource();

            System.out.println(js.getValue());
            icc.SetG(js.getValue());
            icc.redraw();
            imageHandler.setPImage(icc.getPImage());
            imageHandler.redraw();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
