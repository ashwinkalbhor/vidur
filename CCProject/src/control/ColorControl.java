package control;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ColorControl extends JPanel{
	private JSlider ControlRed;
	private JSlider ControlGreen;
	private JSlider ControlBlue;
	public ColorControl(){
		setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		
		GridLayout gbl= new GridLayout(1,3);
		
		ControlRed = new JSlider(0,255);
		ControlRed.setSize(300,100);
		ControlRed.setMajorTickSpacing(50);
		ControlRed.setMinorTickSpacing(1);
		ControlRed.setPaintLabels(true);
		ControlRed.setPaintTicks(true);
		add(ControlRed);
		
		ControlGreen = new JSlider(0,255);
		ControlGreen.setSize(300,100);
		ControlGreen.setMajorTickSpacing(50);
		ControlGreen.setMinorTickSpacing(1);
		ControlGreen.setPaintLabels(true);
		ControlGreen.setPaintTicks(true);
		add(ControlGreen);
		
		ControlBlue = new JSlider(0,255);
		ControlBlue.setSize(300,100);
		ControlBlue.setMajorTickSpacing(50);
		ControlBlue.setMinorTickSpacing(1);
		ControlBlue.setPaintLabels(true);
		ControlBlue.setPaintTicks(true);
		add(ControlBlue);
		
		
	}
}
