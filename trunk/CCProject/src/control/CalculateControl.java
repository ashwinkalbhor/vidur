package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import event.ProcessImageEvent;

public class CalculateControl extends JPanel{
	private static final long serialVersionUID = 2636247746338890880L;
	private JButton process;
	private JTextField count;
	//private ImageHandler ih;
	public CalculateControl(ImageHandler ih){
		//this.ih = ih;
		
		setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		this.setLayout(new GridLayout(2,1));
		process = new JButton("Process");
		process.setBounds(10, 30, 80, 40);
		ProcessImageEvent pie = new ProcessImageEvent(ih);
		process.addMouseListener(pie);
		add(process);
		count = new JTextField("Count");
		count.setBounds(100, 30, 350, 40);
		add(count);
		
	}
}
