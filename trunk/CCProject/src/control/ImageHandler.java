package control;

import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageHandler extends PApplet {
	private static final long serialVersionUID = -5394191045615392851L;
	private String path = null;
	private PImage img, subimg, temp_img;
	private int THRESHOLD_PARAM = 0;
	private int cx = 0;
	private int cy = 0;
	private int x = -10000;
	private int y = -10000;
	private float level = 1.0f;
	private float cr = 200.0f;
	private float r = 255.0f;
	private float sc = 0.0f;
	private float gr = 255.0f;
	private float b = 255.0f;
	private float top, left, h, w;
	private float wt = 0.0f;
	private boolean CIRCLE_DRAWN = false;

	public ImageHandler(String path) {
		this.path = path;
	}

	@Override
	public void draw() {

		fill(100);
		rect(0, 0, 550, 400);
		// pushMatrix();
		translate(width / 2, height / 2);
		// img.filter(THRESHOLD_PARAM,level);
		// pushMatrix();
		// scale(sc);
		
		image(this.img, left, top, h, w);
		// popMatrix();
		tint(r, gr, b);
		setStroke();
		this.setCircleCords();
		rect(-this.cr / 2.0f, -this.cr / 2.0f, this.cr, this.cr);
		
		ellipse(this.cx, this.cy, this.cr, this.cr);
		this.filter(THRESHOLD_PARAM, level);
		
		this.settempImage(this.get((int)left, (int)top, (int)h, (int)w));
		// println(img.get(200,200));
		// popMatrix();
		noFill();
		rect(this.x - 10 - width / 2, this.y - 10 - height / 2, 20, 20);
		
		noLoop();
		// println(left + "\t" + top + "\t" + h + "\t" + w);
	}

	public void drawRects(int x, int y) {
		this.setStrokeWeight(255);
		this.x = x - height / 2;
		this.y = y - width / 2;
	}

	public void drawSubImage(PImage im) {
		this.subimg = new PImage((int) this.w, (int) this.h);
		this.subimg.copy(im, im.width / 2 - (int) this.w, im.height / 2
				- (int) this.h, 2 * (int) this.w, 2 * (int) this.h, 0, 0,
				(int) this.w, (int) this.h);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, subimg.width,
				subimg.height);
		// BufferedImage bimage = (BufferedImage) subimg.getImage();
		// ColorModel cmodel = bimage.getColorModel();
		for (int i = 0; i < subimg.width; i++) {
			for (int j = 0; j < subimg.height; j++) {
				if (!ellipse.contains(i, j)) {
					subimg.set(i, j, -1);
				}
				// int r = cmodel.getRed(pnum);
				// int g = cmodel.getGreen(pnum);
				// int b = cmodel.getBlue(pnum);
				// System.out.println(cmodel.getRGB(pnum));
				// if(r > 200){
				// //System.out.println(r +"\t"+g +"\t"+b +"\t");
				//				
				// }else if(g > 200){
				//				
				// }else if(b > 200){
				//				
				// }
				// pnum++;
			}
		}
		this.setPImage(subimg);
		this.settempImage(subimg);
		if(this.getScaleParam(this.img.width, this.img.height)>1){
			this.left = -this.img.width/2.0f;
			this.top = -this.img.height/2.0f;
			this.h = this.img.height;
			this.w = this.img.width;
		}
		else
		{
		this.setDimForOriginal(this.img);
		}
		println("left = "+this.left+"\n"+"top = "+this.top+"\n"+"w = "+this.w+"\n"+"h = "+this.h+"\n");
	}

	public boolean getCIRCLE_DRAWN_param() {
		return this.CIRCLE_DRAWN;
	}

	public int getCircleRadius() {
		return (int) this.cr;
	}

	public String getFilePath() {
		return path;
	}

	public PImage getPImage() {
		return this.img;
	}

	public float getScaleParam(int a, int b) {
		float scaleA = (float) 550 / a;
		float scaleB = (float) 400 / b;
		if (scaleA < scaleB) {
			return scaleA;
		}
		return scaleB;
	}

	public PImage gettempImage() {
		return this.temp_img;
	}

	public int getTHRESHOLD_PARAM() {
		return THRESHOLD_PARAM;
	}

	public void setBlue(float b) {
		this.b = b;
	}

	public void setCIRCLE_DRAWN_param(boolean cdp) {
		this.CIRCLE_DRAWN = cdp;
	}

	public void setCircleRadius(float cr) {
		this.cr = cr;
	}

	public void setDimForOriginal(PImage img) {
		this.left = -img.width * this.getScaleParam(img.width, img.height)
				/ 2.0f;
		this.top = -img.height * this.getScaleParam(img.width, img.height)
				/ 2.0f;
		this.h = img.width * this.getScaleParam(img.width, img.height);
		this.w = img.height * this.getScaleParam(img.width, img.height);
	}

	public void setDimForSubImage(PImage img, int cr) {
		this.img = img;
		this.top = -((cr / 2.0f) / this.getScaleParam(img.width, img.height)) / 2.0f;
		this.left = -((cr / 2.0f) / this.getScaleParam(img.width, img.height)) / 2.0f;
		this.h = (cr / 2.0f) / this.getScaleParam(img.width, img.height);
		this.w = (cr / 2.0f) / this.getScaleParam(img.width, img.height);
	}

	public void setGreen(float gr) {
		this.gr = gr;
	}

	public void setImage(String path) {
		this.path = path;
		this.THRESHOLD_PARAM = 0;
		img = loadImage(path);
	}

	public void setPImage(PImage pi) {
		this.img = pi;
		this.setDimForOriginal(this.img);
	}

	public void setRed(float r) {
		this.r = r;
	}

	public void setScale(float sc) {
		this.sc = sc;
		scale(sc);
	}

	public void setStroke() {
		stroke(255, 0, 0, wt);
		strokeWeight(1.0f);
		noFill();
	}

	public void setStrokeWeight(int wt) {

		this.wt = wt;
	}

	public void settempImage(PImage pi) {
		this.temp_img = pi;
	}

	public void setTHRESHOLD_PARAM() {
		this.THRESHOLD_PARAM = 0;
	}

	public void setThresholdLevel(int level) {
		this.THRESHOLD_PARAM = THRESHOLD;
		this.level = (float) level / 100;
	}
	
	public void setCircleCords(){
		if(this.getCIRCLE_DRAWN_param()){
			if(mousePressed){
				this.setX(mouseX);
				this.setY(mouseY);
				println(this.cx);println(this.cy);
				this.redraw();
			}
		}
	}
	
	public void setX(int cx){
		this.cx = cx-this.width/2;
		println(cx+"\t"+this.cx);
	}
	
	public void setY(int cy){
		this.cy = cy-this.height/2;
		println(cy+"\t"+this.cy);
	}
	
	@Override
	public void setup() {
		size(550, 400);
		img = new PImage();
		smooth();
	}
}
