package logic.events;


import processing.core.PImage;

import gui.events.Messages;
import image.control.HandleImage;
import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import logic.control.CountColonies;

public class ProcessImageEvent extends MouseAdapter {
    private CountColonies countColonies;
    private JTextField    count;
    private int           counter;
    private ImageHandler  imageHandler;
    PImage                tempPImage;

    public ProcessImageEvent(final HandleImage handleImage, final JTextField count) {
        imageHandler = (ImageHandler) handleImage;
        this.count = count;
    }

    @Override
    public final void mousePressed(final MouseEvent me) {

        super.mousePressed(me);
        tempPImage = imageHandler.getPImage();
        countColonies         = new CountColonies(tempPImage);
        countColonies.count(tempPImage);
        counter = countColonies.getColonyCount();
        count.setText(Messages.getString("ProcessImageEvent.1") + counter);
    }
}

