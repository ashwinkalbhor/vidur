package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class LoadImageEvent extends MouseAdapter {
	private BrowseHandler bh;
	private  ImageHandler ip;
	public LoadImageEvent(ImageHandler ip,BrowseHandler bh){
		this.ip=ip;
		this.bh = bh;
		
	}
	public void mousePressed(MouseEvent me){
		super.mousePressed(me);
		ip.setImage(bh.returnPath());
		ip.redraw();
				
	}
}
