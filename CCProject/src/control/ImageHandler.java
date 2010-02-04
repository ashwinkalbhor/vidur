package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private String path="data/Images/1.jpg";
	private int x,y;
	private float sc =1.0f;
	PImage img;
	public ImageHandler(String path){
		this.path=path;	
	}
	
	public void setup(){
		size(550,400);
		//background(0);
		img = new PImage();
		img=loadImage(path);
		x=img.width;
		y=img.height;
	}
	
	public void draw(){
		
		fill(0);
		rect(0,0,550,400);
		scale(sc);
		image(img,275-x/2,200-y/2,x,y);
		noLoop();
	}
	
	public void setFilePath(String path){
		img = loadImage(path);
	}
	
	public void setScale(float sc){
		this.sc = sc;
	}
	
	
}
