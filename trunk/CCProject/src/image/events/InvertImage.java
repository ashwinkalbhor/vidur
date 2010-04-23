package image.events;

import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InvertImage extends MouseAdapter {

    private HandleImage handleImage;
    private int backGround = -16777216;

    public InvertImage(HandleImage handleImage) {
        this.handleImage = handleImage;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        super.mousePressed(me);

        if (((ImageHandler) handleImage).getThreshlodParam() == 16) {
            for (int i = 0; i < handleImage.getPImage().height; i++) {
                for (int j = 0; j < handleImage.getPImage().width; j++) {
                    if (handleImage.getPImage().get(i, j) == backGround) {
                        handleImage.getPImage().set(i, j, -1);
                    } else {
                        handleImage.getPImage().set(i, j, backGround);
                    }
                }
            }

            handleImage.setPImage(handleImage.getPImage());
            handleImage.redraw();
        }
    }
}
