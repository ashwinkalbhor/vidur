package logic.events;

//~--- non-JDK imports --------------------------------------------------------


import processing.core.PImage;

//~--- JDK imports ------------------------------------------------------------

import gui.events.Messages;
import image.control.HandleImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;


import logic.control.CountColonies;

public class ProcessImageEvent extends MouseAdapter {
    private CountColonies cc;
    private JTextField    count;
    private int           counter;
    private HandleImage  ih;
    PImage                tempPImage;

    public ProcessImageEvent(final HandleImage ih, final JTextField count) {
        this.ih    = ih;
        this.count = count;
    }

    @Override
    public final void mousePressed(final MouseEvent me) {

//      eg.Ecoli.jpg
        super.mousePressed(me);
        tempPImage = ih.getPImage();
        cc         = new CountColonies();
        cc.count(tempPImage);
        counter = cc.getColonyCount();
        count.setText(Messages.getString("ProcessImageEvent.1") + counter);    // $NON-NLS-1$
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
