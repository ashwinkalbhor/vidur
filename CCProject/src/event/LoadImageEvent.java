package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

import processing.core.PApplet;

public class LoadImageEvent extends MouseAdapter {
	private BrowseHandler bh;
	private String path;
	private  ImageHandler ip;
	public LoadImageEvent(ImageHandler ip,BrowseHandler bh){
		this.ip=ip;
		this.bh = bh;
		this.path = path;
		
	}
	public void mouseClicked(MouseEvent me){
		super.mouseClicked(me);
		System.out.println(bh.returnPath());
		ip.setFilePath(bh.returnPath());
		ip.redraw();
		
		
	}
}
