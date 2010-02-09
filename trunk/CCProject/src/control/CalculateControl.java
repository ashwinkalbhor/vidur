package control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateControl extends JPanel{
	private static final long serialVersionUID = 2636247746338890880L;
	private JButton process;
	private JTextField count;
	public CalculateControl(){
		setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		process = new JButton("Process");
		process.setBounds(10, 30, 80, 40);
		add(process);
		count = new JTextField("Count");
		count.setBounds(100, 30, 350, 40);
		add(count);
		
	}
}
