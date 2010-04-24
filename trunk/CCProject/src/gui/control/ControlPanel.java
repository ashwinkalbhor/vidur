package gui.control;


import gui.events.BrowseHandler;
import gui.events.ClearCircleEvent;
import gui.events.DrawCircleEvent;
import image.control.CalculateControl;
import image.control.ColorControl;
import image.control.ImageColorController;
import image.control.ImageControl;
import image.events.ImageTransferEvent;
import image.events.InvertImage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.control.ProcessImage;

public class ControlPanel extends JPanel {
    private static final long serialVersionUID = -6581079276015103030L;
    private JButton           browse;
    private JTextField        filePath;
    private JButton           invert, drawcircle, clearcircle;
    private JButton           transfer;

    public ControlPanel(ImagePanel imagePanel1, ImagePanel imagePanel2) {
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setLayout(null);
        filePath = new JTextField("Please Select file");
        filePath.setLocation(10, 30);
        filePath.setSize(300, 30);
        add(filePath);

        BrowseHandler browseHandler =
        new BrowseHandler(filePath, imagePanel1, imagePanel2);
        ColorControl  colorControl =
        new ColorControl(imagePanel2.getPApplet());

        colorControl.setBounds(10, 70, 300, 180);
        add(colorControl);

        ImageControl imageControl = new ImageControl(imagePanel1.getPApplet(), imagePanel2.getPApplet());

        imageControl.setBounds(800, 20, 300, 100);
        add(imageControl);

        CalculateControl calculate = new CalculateControl(imagePanel2.getPApplet());

        calculate.setBounds(800, 140, 300, 100);
        add(calculate);

        ProcessImage processImage = new ProcessImage(imagePanel2.getPApplet());

        processImage.setBounds(460, 10, 320, 200);
        add(processImage);
        browse = new JButton("Browse");
        browse.setLocation(335, 30);
        browse.setSize(100, 30);
        browse.addMouseListener(browseHandler);
        add(browse);
        invert = new JButton("Invert");
        invert.setLocation(335, 70);
        invert.setSize(100, 30);
        invert.addMouseListener(new InvertImage(imagePanel2.getPApplet()));

        // invert.setEnabled(false);
        add(invert);
        transfer = new JButton("Transfer");
        transfer.setLocation(335, 110);
        transfer.setSize(100, 30);

        ImageTransferEvent imageTransferEvent =
        new ImageTransferEvent(imagePanel1.getPApplet(),
        		imagePanel2.getPApplet());

        transfer.addMouseListener(imageTransferEvent);
        add(transfer);
        drawcircle = new JButton("Draw Circle");
        drawcircle.setLocation(335, 150);
        drawcircle.setSize(100, 30);

        DrawCircleEvent drawCircleEvent = new DrawCircleEvent(imagePanel1.getPApplet(),
              new ImageColorController(imagePanel2.getPApplet()));

        drawcircle.addMouseListener(drawCircleEvent);
        add(drawcircle);
        clearcircle = new JButton("Clear Circle");
        clearcircle.setLocation(335, 190);
        clearcircle.setSize(100, 30);

        ClearCircleEvent clearCircleEvent = new ClearCircleEvent(imagePanel1.getPApplet());

        clearcircle.addMouseListener(clearCircleEvent);
        add(clearcircle);
    }
}

