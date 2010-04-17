package image.control;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageColorController extends PApplet{
	private PImage img;
	private int r=0;
	private int g = 0;
	private int b = 0;
	private int THRESHOLD_PARAM = 0;
	private float level = 1.0f;
	private boolean CIRCLE_DRAWN = false;
	
	public ImageColorController(final PImage img) {
		this.img = img;
		this.CIRCLE_DRAWN = CIRCLE_DRAWN ; 
	}

	@Override
         public final void setup() {
		size(img.width , img.height);
	}

	@Override
         public void draw(){
		tint(r,g,b);
		image(img,0,0,img.width,img.height);
		if(CIRCLE_DRAWN){
			filter(THRESHOLD_PARAM, level);
		}
		setPImage(get(0,0,img.width,img.height));
		noLoop();
	}
	
	public void SetR(int r){
		this.r = r;
	}
	public void SetG(int g){
		this.g = g;
	}
	public void SetB(int b){
		this.b = b;
	}
	
	
	
	protected void setPImage(PImage img){
		this.img = img;
	}
	
	public PImage getPImage(){
		return img;
	}
	
	private int getTHRESHOLD_PARAM() {
		return THRESHOLD_PARAM;
	}
	
	private void setThresholdParam() {
		this.THRESHOLD_PARAM = 0;
	}

	public void setThresholdLevel(int level) {
		this.THRESHOLD_PARAM = THRESHOLD;
		this.level = (float) level / 100;
	}
	
	public void setCIRCLE_DRAWN_PARAM(boolean cdp){
		this.CIRCLE_DRAWN = cdp;
	}
}
