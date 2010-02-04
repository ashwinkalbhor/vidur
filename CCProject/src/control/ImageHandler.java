package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private String path;
	public int x,y;
	private static String s="data/Images/1.jpg";
	PImage img;
	public ImageHandler(String path){
		this.path=path;	
	}
	
	public void setup(){
		size(550,400);
		background(0);
		img = new PImage();
		img=loadImage(path);
		x=img.width;
		y=img.height;
	}
	
	public void draw(){
		
		pushMatrix();
		rect(0,0,550,400);
		fill(0);
		image(img,275-x/2,200-y/2,x,y);
		popMatrix();
	}
}
