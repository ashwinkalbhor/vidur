package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import processing.core.PApplet;

import event.CircleController;
import event.ImageController;

public class ImageControl extends JPanel {
	private JSlider imageScale;
	private JSlider scaleRadius;
	private JLabel zoomImage;
	private JLabel zoomCircle;
	private ImageHandler ih;
	public ImageControl(ImageHandler ih){
	setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
	
	this.ih =ih;
	
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
