package gui.events;


import image.control.HandleImage;
import image.control.ImageColorController;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawCircleEvent extends MouseAdapter {
    private ImageColorController imageColorController;
    private ImageHandler         imageHandler;

    public DrawCircleEvent(HandleImage handleImage, ImageColorController icc) {
        this.imageHandler  = (ImageHandler)handleImage;
        this.imageColorController = icc;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        super.mousePressed(me);
        imageHandler.setStrokeWeight(255);
        imageHandler.isCircleDrawn(true);
        imageColorController.isCircleDrawn(true);
        imageColorController.redraw();
        imageHandler.redraw();
    }
}
