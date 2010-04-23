package gui.events;


import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClearCircleEvent extends MouseAdapter {
    private ImageHandler imageHandler;

    public ClearCircleEvent(HandleImage handleImage) {
        this.imageHandler = (ImageHandler)handleImage;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        super.mouseClicked(me);
        imageHandler.isCircleDrawn(false);
        imageHandler.setStrokeWeight(0);
        imageHandler.redraw();
    }
}
