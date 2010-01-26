package control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateControl extends JPanel{
	private JButton process;
	private JTextField count;
	public CalculateControl(){
		setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		
		GridLayout gbl= new GridLayout(2,1);
		process = new JButton("Process");
		process.setBounds(10, 30, 80, 40);
		add(process);
		count = new JTextField("Count");
		count.setBounds(100, 30, 350, 40);
		add(count);
		
	}
}
