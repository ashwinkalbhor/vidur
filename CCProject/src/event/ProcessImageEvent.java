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
		//working with images with black colonies against white background eg.Ecoli.jpg
		super.mousePressed(me);
		cc = new CountColonies(ih.gettempImage());
		counter = 0;
		for (int i = 1; i < ih.gettempImage().height-1; i++) {
			for (int j = 1; j < ih.gettempImage().width-1; j++) {
				if(cc.count(j, i)){
					//ih.set(j, i, 0);
					counter++;
					System.out.println(counter);
				}
				if(ih.gettempImage().get(j, i)== -1){			//for white background pixels
				//System.out.print(0 + "");
					}
				if(ih.gettempImage().get(j, i) == -16777216){	//for black colony pixels
				//System.out.print(1+"");
					}
				
			}
			//System.out.println();
		}
		
		//System.out.println(ih.gettempImage().height + "\t" + ih.gettempImage().width);
		count.setText("d no.of colonies are "+counter);
		//System.out.println("The Number Of colonies are " + counter);
		//System.out.println(ih.gettempImage().width+"\n"+ih.gettempImage().height);
	}
	
}
