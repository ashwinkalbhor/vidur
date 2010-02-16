package control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private static final long serialVersionUID = -5394191045615392851L;
	private String path=null;
	private boolean flag=false;
	private boolean flag1=false;
	private boolean flag2=false;
	private boolean flag3 = false;
	private float sc =1.0f;
	private float cr = 200.0f;
	private float level=1.0f;
	private float dilate;
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
		if(flag1){
		image(img,-400/2.0f,-400/2.0f,400,400);
		
		}
		popMatrix();
		
		stroke(255,0,0);
		strokeWeight(1.0f);
		noFill();
		if(flag2){
		rect(-this.getCircleRadius()/2,-this.getCircleRadius()/2,this.getCircleRadius(),this.getCircleRadius());
		drawCircle();
		}
		if(flag3==true){
			filter(THRESHOLD,level);
			}
		System.out.println(img.pixels[0]);
		noLoop();
	}
	
	public void setFilePath(String path){
		flag1=true;
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
		this.flag=false;
		this.cr = cr;
	}
	
	public int getCircleRadius(){
		return (int) this.cr;
	}
	
	public void setRed(float r){
		this.flag=false;
		this.r = r;
	}
	public void setGreen(float gr){
		this.flag=false;
		this.gr = gr;
	}
	public void setBlue(float b){
		this.flag=false;
		
		this.b = b;
	}
	
	public void setImage(String path){
		this.flag=false;
		this.flag1=true;
		this.path = path;
		img=loadImage(path);
	}
	
	public void setThresholdLevel(int level){
		this.flag3=true;
		this.level = (float) level/100;
	}
	
	public void setDilateLevel(int level){
		this.flag3=true;
		this.dilate = level/100;
	}
	
	public String getFilePath(){
		return path;
	}
	
	public void DrawCircleOnClick(){
		this.flag2=true;
	}
	
	public void ClearCircleOnClicked(){
		this.flag2=false;
	}
	
	public PImage getPImage(){
		return img;
		}
}
