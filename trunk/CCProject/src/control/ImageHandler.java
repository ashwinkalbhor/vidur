package control;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Vector;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private static final long serialVersionUID = -5394191045615392851L;
	private String path=null;
	private float cr = 200.0f;
	private int THRESHOLD_PARAM = 0;
	private float level=1.0f;
	private PImage img,subimg;
	private float r = 255.0f;
	private float gr = 255.0f;
	private float b = 255.0f;
	private float top , left , h, w;
	private float wt = 0.0f;
	public ImageHandler(String path){
		this.path=path;	
	}
	
	public void setup(){
		size(550,400);
		img = new PImage();
		subimg = new PImage();
		smooth();
	}
	
	public void draw(){
		
		fill(0);
		rect(0,0,550,400);
		translate(width/2,height/2);
		if(this.path!=null){
			image(img,top,left,h,w);
		}
		pushMatrix();
		tint(r, gr, b);
		setStroke();
		
		rect(-cr/2.0f,-cr/2.0f,cr,cr);
		ellipse(0,0,cr,cr);
		popMatrix();
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
	
	public void setDimForSubImage(PImage img){
		this.top =  -cr*this.getScaleParam((int)cr, (int)cr)/2.0f;
		this.left = -cr*this.getScaleParam((int)cr, (int)cr)/2.0f;
		this.h = cr*this.getScaleParam((int)cr, (int)cr);
		this.w = cr*this.getScaleParam((int)cr, (int)cr);
		
	}
	
	public Vector<Float> getDimForSubImage(){
		Vector<Float> vec = new Vector<Float>();
		vec.add(this.top);
		vec.add(this.left);
		vec.add(this.h);
		vec.add(this.w);
		return vec;
		
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
	
	public float getScaleParam(int a,int b){
		float  scaleA= (float) 550/a;
		float scaleB = (float) 400/b;
		if(scaleA<scaleB){
		return scaleA;}
		return scaleB;
	}
	
	public void getSubImage(PImage im){
	BufferedImage im1;
	
	im1 = (BufferedImage) ImageIO.getImageReaders(im);
	
	
	//System.out.println(im1.getHeight());
	}	
}
