package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private static final long serialVersionUID = -5394191045615392851L;
	private String path="data/Images/1.jpg";
	private float sc =1.0f;
	private float cr = 200.0f;
	private float level=1.0f;
	private PImage img;
	private float r = 255.0f;
	private float gr = 255.0f;
	private float b = 255.0f;
	public ImageHandler(String path){
		this.path=path;	
	}
	
	public void setup(){
		size(550,400);
		img = new PImage();
		img=loadImage(path);
		smooth();
	}
	
	public void draw(){
		
		fill(0);
		rect(0,0,550,400);
		translate(width/2,height/2);
		pushMatrix();
		scale(sc);
		tint(r, gr, b);
		filter(THRESHOLD,level);
		image(img,-400/2.0f,-400/2.0f,400,400);
		popMatrix();
		stroke(255,0,0);
		strokeWeight(1.0f);
		noFill();
		drawCircle();
		noLoop();
	}
	
	public void setFilePath(String path){
		this.path = path;
		img = loadImage(path);
	}
	
	public void setScale(float sc){
		this.sc = sc;
	}
	
	public void drawCircle(){
		ellipse(0,0,cr,cr);
	}
	
	public void setCircleRadius(float cr){
		this.cr = cr;
	}
	
	public void setRed(float r){
		this.r = r;
	}
	public void setGreen(float gr){
		this.gr = gr;
	}
	public void setBlue(float b){
		this.b = b;
	}
	
	public void setImage(String path){
		this.path = path;
		img=loadImage(path);
	}
	
	public void setThresholdLevel(int level){
		this.level =(float) level/100;
	}
	
	public String getFilePath(){
		return path;
	}
}
