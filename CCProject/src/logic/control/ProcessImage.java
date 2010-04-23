package logic.control;

import gui.events.Messages;
import image.control.HandleImage;
import image.control.ImageColorController;
import image.events.ImageThresholdEvent;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class ProcessImage extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel            Dilate;
    private JLabel            Processor;
    private JLabel            Threshold;
    private JSlider           dilater;

    private JSlider thresholder;

    public ProcessImage(HandleImage handleImage) {

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setLayout(null);
        Processor = new JLabel(Messages.getString("ProcessImage.0"));
        Processor.setSize(120, 20);
        Processor.setLocation(10, 10);
        Processor.setName(Messages.getString("ProcessImage.1"));
        add(Processor);
        Threshold = new JLabel(Messages.getString("ProcessImage.2"));
        Threshold.setSize(80, 20);
        Threshold.setLocation(10, 35);
        Threshold.setLabelFor(thresholder);
        add(Threshold);
        thresholder = new JSlider(0, 100);
        thresholder.setLocation(10, 60);
        thresholder.setSize(300, 50);
        thresholder.setMajorTickSpacing(30);
        thresholder.setMinorTickSpacing(3);
        thresholder.setPaintLabels(true);
        thresholder.setPaintTicks(true);

        ImageThresholdEvent imageThresholdEvent = new ImageThresholdEvent(handleImage,
        new ImageColorController(handleImage));

        thresholder.addChangeListener(imageThresholdEvent);
        add(thresholder);
        Dilate = new JLabel(Messages.getString("ProcessImage.3"));
        Dilate.setSize(50, 20);
        Dilate.setLocation(10, 115);
        Dilate.setLabelFor(dilater);
        add(Dilate);
        dilater = new JSlider(0, 100);
        dilater.setLocation(10, 140);
        dilater.setSize(300, 50);
        dilater.setMajorTickSpacing(30);
        dilater.setMinorTickSpacing(3);
        dilater.setPaintLabels(true);
        dilater.setPaintTicks(true);

        // ImageDilaterEvent ide = new ImageDilaterEvent(ih);
        // dilater.addChangeListener(ide);
        add(dilater);
        dilater.setEnabled(false);
    }
}
