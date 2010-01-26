package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

import event.ImageController;

public class ImageControl extends JPanel {
	private JSlider imageScale;
	private JSlider scaleRadius;
	public ImageControl(){
	setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	
	GridLayout gbl= new GridLayout(2,1);
	
	imageScale = new JSlider(0,100);
	imageScale.setSize(300,100);
	imageScale.setMajorTickSpacing(10);
	imageScale.setMinorTickSpacing(1);
	imageScale.setPaintLabels(true);
	imageScale.setPaintTicks(true);
	ImageController ic=new ImageController(imageScale);
	imageScale.addChangeListener(ic);
	System.out.println("ImageScale Value" + ic.returnValue() +"\n");
	
	add(imageScale);
	
	scaleRadius = new JSlider(0,100);
	scaleRadius.setSize(300,100);
	scaleRadius.setMajorTickSpacing(10);
	scaleRadius.setMinorTickSpacing(1);
	scaleRadius.setPaintLabels(true);
	scaleRadius.setPaintTicks(true);
	
	//scaleRadius.addChangeListener();
	//System.out.println("scaleRadius Value " + IC2.returnValue() +"\n"); 
	add(scaleRadius);
	
	}
}
