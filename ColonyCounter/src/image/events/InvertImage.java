package image.events;

import image.control.ImageHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import processing.core.PConstants;

public class InvertImage extends MouseAdapter {
	//private BrowseHandler bh;
	private ImageHandler ip;

	public InvertImage(ImageHandler ip) {
		this.ip = ip;

	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		//ip.setImage(bh.returnPath());
		if(ip.getThresholdParam()==16){
		for (int i = 0; i < ip.getPImage().height; i++) {
			for (int j = 0; j < ip.getPImage().width; j++) {
				if(ip.getPImage().get(i, j)== -16777216){
					ip.getPImage().set(i, j,-1);
				}
				else
				{
					ip.getPImage().set(i, j,-16777216);
				}
				
			}
			
		}
		ip.setPImage(ip.getPImage());
		ip.redraw();

	}
}
}