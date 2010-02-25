package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class ProcessImageEvent extends MouseAdapter{
	private ImageHandler ih;
	public ProcessImageEvent(ImageHandler ih){
		this.ih = ih;
	}
	
	public void mousePressed(MouseEvent me){
		super.mousePressed(me);
		for (int k = 0; k < ih.setSubImage().width; k++) {
			for (int k2 = 0; k2 < ih.setSubImage().height; k2++) {
				System.out.print(ih.setSubImage().get(k, k2)+"\t");
				
			}
			System.out.println();
			
		}
		
	}
}
