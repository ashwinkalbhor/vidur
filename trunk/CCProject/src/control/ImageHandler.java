package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private static final long serialVersionUID = -5394191045615392851L;
	private String path=null;
	private PImage img,subimg;
	private int THRESHOLD_PARAM = 0;
	private float level=1.0f;
	private float cr = 200.0f;
	private float r = 255.0f;
	private float gr = 255.0f;
	private float b = 255.0f;
	private float top , left , h, w;
	private float wt = 0.0f;
	private boolean CIRCLE_DRAWN = false;
	public ImageHandler(String path){
		this.path=path;	
	}
	
	public void setup(){
		size(550,400);
		img = new PImage();
		
		smooth();
	}
	
	public void draw(){
		
		fill(0);
		rect(0,0,550,400);
		translate(width/2,height/2);
		image(img,top,left,h,w);
		tint(r, gr, b);
		setStroke();
		rect(-cr/2.0f,-cr/2.0f,cr,cr);
		ellipse(0,0,cr,cr);

		noFill();
		filter(THRESHOLD_PARAM,level);
		noLoop();
	}
	
	public void setDimForOriginal(PImage img){
		this.top =  -img.width*this.getScaleParam(img.width, img.height)/2.0f;
		this.left = -img.height*this.getScaleParam(img.width, img.height)/2.0f;
		this.h = img.width*this.getScaleParam(img.width, img.height);
		this.w = img.height*this.getScaleParam(img.width, img.height);
	}
	
	public void setDimForSubImage(PImage img,int cr){
		this.img=img;
		this.top =  -((cr/2.0f)/this.getScaleParam(img.width,img.height))/2.0f;
		this.left = -((cr/2.0f)/this.getScaleParam(img.width,img.height))/2.0f;
		this.h = (cr/2.0f)/this.getScaleParam(img.width,img.height);
		this.w = (cr/2.0f)/this.getScaleParam(img.width,img.height);
	}
	
	public void setStroke(){
		stroke(255,0,0,wt);
		strokeWeight(1.0f);
		noFill();
	}
	public void setStrokeWeight(int wt){
		
		this.wt = wt;
	}
	
	public void setCircleRadius(float cr){
		this.cr = cr;
	}
	
	public int getCircleRadius(){
		return (int) this.cr;
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
	
	public void setTHRESHOLD_PARAM(){
		this.THRESHOLD_PARAM = 0;
	}
	public void setImage(String path){
		this.path = path;
		this.THRESHOLD_PARAM = 0;
		img=loadImage(path);
	}
	
	public void setThresholdLevel(int level){
		this.THRESHOLD_PARAM = 16;
		this.level = (float) level/100;
	}
	
	
	public String getFilePath(){
		return path;
	}
	
	public PImage getPImage(){
		return this.img;
		}
	
	public void setCIRCLE_DRAWN_param(boolean cdp){
		this.CIRCLE_DRAWN = cdp;
	}
	public boolean getCIRCLE_DRAWN_param(){
		return this.CIRCLE_DRAWN;
	}
	public float getScaleParam(int a,int b){
		float  scaleA= (float) 550/a;
		float scaleB = (float) 400/b;
		if(scaleA<scaleB){
		return scaleA;}
		return scaleB;
	}
	
	public void getSubImage(PImage im){
	this.subimg = new PImage((int)this.w, (int)this.h) ; 
	this.subimg.copy(im, im.width/2-(int)this.w, im.height/2-(int)this.h, 2*(int)this.w,2*(int)this.h , 0, 0, (int)this.w, (int)this.h);
	this.setDimForOriginal(this.subimg);
	this.img = subimg;
	}	
	
	public PImage setSubImage(){
		return this.subimg;
	}
}
