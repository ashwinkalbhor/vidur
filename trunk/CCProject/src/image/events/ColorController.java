package image.events;

import gui.events.Messages;
import image.control.HandleImage;
import image.control.ImageColorController;
import image.control.ImageHandler;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorController implements ChangeListener {
    ImageColorController imageColorController;
    private ImageHandler imageHandler;
    private JLabel       jLabel;

    public ColorController(HandleImage handleImage, JLabel jl) {

        // TODO Auto-generated constructor stub
        jLabel = jl;
        imageHandler = (ImageHandler)handleImage;
    }

    public void stateChanged(ChangeEvent ce) {

        imageColorController = new ImageColorController(imageHandler);

        if (jLabel.getText() == Messages.getString("ColorController.0")) {
            JSlider jSlider = (JSlider) ce.getSource();
            imageColorController.SetR(jSlider.getValue());
            imageColorController.redraw();
            imageHandler.setPImage(imageColorController.getPImage());
            imageHandler.redraw();
        }

        if (jLabel.getText() == Messages.getString("ColorController.1")) {
            JSlider jSlider = (JSlider) ce.getSource();
            imageColorController.SetB(jSlider.getValue());
            imageColorController.redraw();
            imageHandler.setPImage(imageColorController.getPImage());
            imageHandler.redraw();
        }

        if (jLabel.getText() == Messages.getString("ColorController.2")) {
            JSlider jSlider = (JSlider) ce.getSource();
            imageColorController.SetG(jSlider.getValue());
            imageColorController.redraw();
            imageHandler.setPImage(imageColorController.getPImage());
            imageHandler.redraw();
        }
    }
}
