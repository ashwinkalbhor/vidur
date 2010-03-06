package control;

import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet{
	private static final long serialVersionUID = -5394191045615392851L;
	private String path=null;
	private PImage img,subimg,temp_img;
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
		//img.filter(THRESHOLD_PARAM,level);
		image(this.img,left,top,h,w);
		tint(r, gr, b);
		setStroke();
		rect(-cr/2.0f,-cr/2.0f,cr,cr);
		ellipse(0,0,cr,cr);
		
		filter(THRESHOLD_PARAM,level);
		this.settempImage(this.get(75, 0, 400, 400));
		//println(img.get(200,200));
		noFill();
		noLoop();
		//println(left + "\t" + top + "\t" + h + "\t" + w);
	}
	public void setDimForOriginal(PImage img){
		this.left =  -img.width*this.getScaleParam(img.width, img.height)/2.0f;
		this.top = -img.height*this.getScaleParam(img.width, img.height)/2.0f;
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
	public int getTHRESHOLD_PARAM(){
		return THRESHOLD_PARAM;
	}
	public void setImage(String path){
		this.path = path;
		this.THRESHOLD_PARAM = 0;
		img=loadImage(path);
	}
	public void setThresholdLevel(int level){
		this.THRESHOLD_PARAM = THRESHOLD;
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
	public void drawSubImage(PImage im){
	this.subimg = new PImage((int)this.w, (int)this.h) ; 
	this.subimg.copy(im, im.width/2-(int)this.w, im.height/2-(int)this.h, 2*(int)this.w,2*(int)this.h , 0, 0, (int)this.w, (int)this.h);
	Ellipse2D.Double ellipse = new Ellipse2D.Double(0,0,subimg.width,subimg.height);
	BufferedImage bimage = (BufferedImage) subimg.getImage();
	ColorModel cmodel = bimage.getColorModel();
	for (int i = 0,pnum =0; i<subimg.width;i++){
		for(int j =0 ; j<subimg.height;j++){
			if(!ellipse.contains(i, j)){
				subimg.set(i, j, 0);
			}
			int r = cmodel.getRed(pnum);
			int g = cmodel.getGreen(pnum);
			int b = cmodel.getBlue(pnum);
			System.out.println(cmodel.getRGB(pnum));
			if(r > 200){
			//System.out.println(r +"\t"+g +"\t"+b +"\t");
				
			}else if(g > 200){
				
			}else if(b > 200){
				
			}
			pnum++;
		}
	}
	this.setDimForOriginal(this.subimg);
	setPImage(subimg);
	}
	
	public void setPImage(PImage pi){
		this.img = pi;
	}
	public PImage gettempImage(){
		return this.temp_img;
	}
	public void settempImage(PImage pi){
		this.temp_img = pi;
	}
}
