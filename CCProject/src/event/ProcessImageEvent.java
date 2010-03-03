package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import control.CountColonies;
import control.ImageHandler;

public class ProcessImageEvent extends MouseAdapter{
	private ImageHandler ih;
	private int counter;
	private JTextField count;
	private CountColonies cc;
	public ProcessImageEvent(ImageHandler ih,JTextField count){
		this.ih = ih;
		this.count = count;
	}
	
	public void mousePressed(MouseEvent me){
		super.mousePressed(me);
		cc = new CountColonies(ih);
		for (int i = 1; i < ih.getPImage().width-2; i++) {
			for (int j = 1; j < ih.getPImage().height-2; j++) {
				if(cc.count(i, j)){
					counter++;
				}
				if(ih.getPImage().get(i, j)== -1){
				//System.out.print(1 + "");
					}
				if(ih.getPImage().get(i, j) == -16777216){
					//System.out.print(0+"");
					}
			}
			System.out.println();
		}
		count.setText("d no.of colonies are "+counter);
		//System.out.println("The Number Of colonies are " + counter);
	}
	
}
