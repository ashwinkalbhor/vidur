package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

import event.CircleController;
import event.ImageController;

public class ImageControl extends JPanel {
	private static final long serialVersionUID = 8244529568780449188L;
	private JSlider imageScale;
	private JSlider scaleRadius;
	public ImageControl(ImageHandler ih){
	setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
	GridLayout gbl= new GridLayout(2,2);
	this.setLayout(gbl);
	imageScale = new JSlider(0,100);
	imageScale.setSize(300,100);
	imageScale.setMajorTickSpacing(10);
	imageScale.setMinorTickSpacing(1);
	imageScale.setPaintLabels(true);
	imageScale.setPaintTicks(true);
	ImageController ic=new ImageController(ih);
	imageScale.addChangeListener(ic);
	add(imageScale);
	
	scaleRadius = new JSlider(0,200);
	scaleRadius.setSize(300,100);
	scaleRadius.setMajorTickSpacing(20);
	scaleRadius.setMinorTickSpacing(1);
	scaleRadius.setPaintLabels(true);
	scaleRadius.setPaintTicks(true);
	CircleController cc=new CircleController(ih);
	scaleRadius.addChangeListener(cc);
	add(scaleRadius);
	
	}
}
