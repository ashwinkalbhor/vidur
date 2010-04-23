package image.events;


import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageTransferEvent extends MouseAdapter {
    private ImageHandler handleImage1,handleImage2;

    public ImageTransferEvent(HandleImage handleImage1, HandleImage handleImage2) {
        this.handleImage1 = (ImageHandler)handleImage1;
        this.handleImage2 = (ImageHandler)handleImage2;
    }

    @Override
    public final void mousePressed(final MouseEvent me) {
        super.mousePressed(me);
        handleImage2.setThresholdParam();

        if (handleImage1.getCircleDrawnParam()) {
            handleImage2.setDimForSubImage(handleImage1.getPImage(), handleImage1.getCircleRadius());
            handleImage2.drawSubImage(handleImage1.getPImage(), handleImage1.getX(), handleImage1.getY(), handleImage1.getCircleRadius());
            handleImage2.redraw();
        }
    }
}


