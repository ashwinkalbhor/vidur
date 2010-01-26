package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private String path;
	private PImage img;
	public ImageHandler(String path){
		this.path=path;
	}
	
	public void setup(){
		size(200,200);
		background(0);
		img = new PImage();
		img=loadImage(path);
	}
	
	public void draw(){
		rect(0,0,200,200);
		fill(0);
		image(img,0,0);
	}
}
