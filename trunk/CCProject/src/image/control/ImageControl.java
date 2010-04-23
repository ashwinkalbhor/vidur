package image.control;

//~--- non-JDK imports --------------------------------------------------------

import gui.events.CircleController;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ImageControl extends JPanel {
    private static final long serialVersionUID = 8244529568780449188L;
    private JSlider           imageScale;
    private JSlider           scaleRadius;

    public ImageControl(HandleImage handleImage1,HandleImage handleImage2) {
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GridLayout gbl = new GridLayout(2, 2);

        this.setLayout(gbl);

//      imageScale = new JSlider(0, 100);
//      imageScale.setSize(300, 50);
//      imageScale.setMajorTickSpacing(10);
//      imageScale.setMinorTickSpacing(5);
//      imageScale.setPaintLabels(true);
//      imageScale.setPaintTicks(true);
//      ImageController ic = new ImageController(ih2);
//      imageScale.addChangeListener(ic);
//      add(imageScale);

        JLabel circleControl = new JLabel("Scale Circle");

        circleControl.setBounds(0, 0, 100, 50);
        add(circleControl);
        scaleRadius = new JSlider(0, 200);
        scaleRadius.setSize(300, 50);
        scaleRadius.setMajorTickSpacing(20);
        scaleRadius.setMinorTickSpacing(10);
        scaleRadius.setPaintLabels(true);
        scaleRadius.setPaintTicks(true);

        CircleController cc = new CircleController(ih1);

        scaleRadius.addChangeListener(cc);
        add(scaleRadius);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
