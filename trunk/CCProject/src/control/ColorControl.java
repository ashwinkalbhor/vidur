package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ColorControl extends JPanel{
	private JSlider ControlRed;
	private JSlider ControlGreen;
	private JSlider ControlBlue;
	private JLabel red;
	private JLabel green;
	private JLabel blue;
	
	public ColorControl(){
		setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		
		GridLayout gbl= new GridLayout(3,2);
		this.setLayout(gbl);
		
		ControlRed = new JSlider(0,255);
		add(ControlRed);
		ControlRed.setSize(300,100);
		ControlRed.setMajorTickSpacing(50);
		ControlRed.setMinorTickSpacing(1);
		ControlRed.setPaintLabels(true);
		ControlRed.setPaintTicks(true);
		red = new JLabel();
		red.setSize(50,30);
		red.setText("Red");
		red.setBackground(new Color(255,0,0));
		red.setLabelFor(ControlRed);
		red.setForeground(new Color(255,0,0));		
		add(red);
		
		ControlGreen = new JSlider(0,255);
		ControlGreen.setSize(300,100);
		ControlGreen.setMajorTickSpacing(50);
		ControlGreen.setMinorTickSpacing(1);
		ControlGreen.setPaintLabels(true);
		ControlGreen.setPaintTicks(true);
		add(ControlGreen);
		green = new JLabel();
		green.setSize(50, 30);
		green.setText("Green");
		green.setBackground(new Color(255,200,20));
		green.setLabelFor(ControlGreen);
		green.setForeground(new Color(0,255,0));
		add(green);
		
		ControlBlue = new JSlider(0,255);
		ControlBlue.setSize(300,100);
		ControlBlue.setMajorTickSpacing(50);
		ControlBlue.setMinorTickSpacing(1);
		ControlBlue.setPaintLabels(true);
		ControlBlue.setPaintTicks(true);
		add(ControlBlue);
		blue = new JLabel();
		blue.setSize(50, 30);
		blue.setText("Blue");
		blue.setBackground(new Color(255,200,20));
		blue.setLabelFor(ControlBlue);
		blue.setForeground(new Color(0,0,255));
		add(blue);
		
	}
}
