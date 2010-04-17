package image.control;

import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author ASHWIN
 *
 */
public class ImageHandler extends PApplet {
    private static final long serialVersionUID = -5394191045615392851L;
    private String path = null;
    private PImage img;
    private PImage subimg ;
    private int ThresholdParam = 0;
    private int circleX = 0;
    private int circleY = 0;
    private float thresholdLevel = 1.0f;
    private float circleRadius = 200.0f;
    private float redComponent = 255.0f;
    private float greenComponent = 255.0f;
    private float blueComponent = 255.0f;
    private float imgTop, imgLeft, imgHeght, imgWidth;
    private float circleBorderSize = 0.0f;
    private boolean circleDrawn = false;
    
    public ImageHandler(String path) {
        this.path = path;
    }
    
    @Override
            public final void draw() {
        
        fill(100);
        rect(0, 0, 550, 400);
        
        translate(width / 2, height / 2);
        if(getThresholdParam()==THRESHOLD){
            img.filter(ThresholdParam, thresholdLevel);
            Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0,img.width,img.height);
            for (int i = 0; i < img.width; i++){
                for (int j = 0; j < this.img.height; j++) {
                    if (!ellipse.contains(i, j)) {
                        img.set(i , j , -10197916);
                    }
                }
            }
            setPImage(img);
        }
        tint(redComponent, greenComponent, blueComponent);
        image(img , imgLeft , imgTop , imgHeght , imgWidth);
        setStroke();
        //settempImage(get((int) (left), (int) (top), (int) h, (int) w));
        rect(circleX - circleRadius / 2.0f, circleY - circleRadius / 2.0f, circleRadius, circleRadius);
        ellipse(circleX, circleY, circleRadius, circleRadius);
        noFill();
        noLoop();
    }
    public final void drawSubImage(final PImage im,final int x,final int y,final int rad) {
        int subImageCenter =0;
        int ImX = (int) (((((im.width/2)+x/getScaleParam(im.width,im.height))))-((rad/2.0f)/getScaleParam(im.width,im.height)));
        int ImY = (int) (((((im.height/2)+y/getScaleParam(im.width,im.height))))-((rad/2.0f)/getScaleParam(im.width,im.height)));
        subimg = new PImage((int)(rad/getScaleParam(im.width,im.height)),(int)(rad/getScaleParam(im.width,im.height)));
        subimg.copy(im, ImX,ImY, (int)(rad/getScaleParam(im.width,im.height)),(int)(rad/getScaleParam(im.width,im.height)), 0, 0,
                (int)(rad/getScaleParam(im.width,im.height)),(int)(rad/getScaleParam(im.width,im.height)));
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, subimg.width,
                subimg.height);
        for (int i = 0; i < subimg.width; i++) {
            for (int j = 0; j < subimg.height; j++) {
                if (!ellipse.contains(i, j)) {
                    subimg.set(i, j,getBackground().getRGB());
                }}}
        setPImage(subimg);
        //(subimg);
        if(getScaleParam(img.width, img.height)>1){
            imgLeft = -150;
            imgTop = -150;
            imgHeght = 300;
            imgWidth = 300;
        } else {
            setDimForOriginal(img);
        }
    }
    
    public final boolean getCircleDrawnParam() {
        return circleDrawn;
    }
    
    public final int getCircleRadius() {
        return (int) circleRadius;
    }
    
    private final String getFilePath() {
        return path;
    }
    
    public final PImage getPImage() {
        return img;
    }
    
    protected final float getScaleParam(final int a, final int b) {
        float scaleA = (float) 550 / a;
        float scaleB = (float) 400 / b;
        if (scaleA < scaleB) {
            return scaleA;
        }
        return scaleB;
    }
    public final int getThresholdParam() {
        return ThresholdParam;
    }
    
    @Override
            public final int getX(){
        return circleX;
    }
    
    @Override
        public final int getY(){
        return circleY;
    }
    
    private final void setBlue(final float b) {
        this.blueComponent = b;
    }
    
    public final void setCircleDrawnParam(final boolean cdp) {
        this.circleDrawn = cdp;
    }
    
    public final void setCircleRadius(final float cr) {
        this.circleRadius = cr;
    }
    
    public final void setDimForOriginal(final PImage img) {
        imgLeft = -img.width * getScaleParam(img.width, img.height)
        / 2.0f;
        imgTop = -img.height * getScaleParam(img.width, img.height)
        / 2.0f;
        imgHeght = img.width * getScaleParam(img.width, img.height);
        imgWidth = img.height * getScaleParam(img.width, img.height);
    }
    
    public final void setDimForSubImage(final PImage img, final int cr) {
        
        if(getScaleParam(img.width, img.height)>1){
            imgLeft = -150;
            imgTop = -150;
            imgHeght = 300;
            imgWidth = 300;
        } else{
            imgTop = -((cr/2.0f) / getScaleParam(img.width, img.height)) / 2.0f;
            imgLeft = -((cr/2.0f) / getScaleParam(img.width, img.height)) / 2.0f;
            imgHeght = (cr/2.0f) / getScaleParam(img.width, img.height);
            imgWidth = (cr/2.0f) / getScaleParam(img.width, img.height);
        }
    }
    
    private final void setGreen(final float gr) {
        greenComponent = gr;
    }
    
    public final void setImage(final String path) {
        this.path = path;
        ThresholdParam = 0;
        img = loadImage(path);
    }
    
    public final void setPImage(final PImage pi) {
        img = pi;
        setDimForOriginal(img);
    }
    
    private final void setRed(final float red) {
        
        redComponent = red;
    }

    protected final void setStroke() {
        stroke(255, 0, 0, circleBorderSize);
        strokeWeight(1.0f);
        noFill();
    }
    
    public final void setStrokeWeight(final int wt) {
        circleBorderSize = wt;
    }
    
//	public final void settempImage(final PImage pi) {
//		this.temp_img = pi;
//	}
    
    public final void setThresholdParam() {
        ThresholdParam = 0;
    }
    
    public final void setThresholdLevel(final int thresholdLevel) {
        ThresholdParam = THRESHOLD;
        this.thresholdLevel = (float) thresholdLevel / 100;
    }
    protected final void setX(final int circleX){
        this.circleX = circleX-this.width/2;
        //println(cx+"\t"+this.cx);
    }
    
    /**
     * 
     * @param circleY : Receives the Yth coordinate for the circle.
     */
    protected final void setY(final int circleY){
        this.circleY = circleY-this.height/2;
        //println(circleY+"\t"+this.cy);
    }
    /**
     * 
     */
    @Override
            public final void setup() {
        size(550, 400);
        img = new PImage();
        smooth();
    }
    
    /**
     * This method controls the center of circle.
     */
    @Override
            public final void mouseDragged(){
        if(this.getCircleDrawnParam()){
            setX(mouseX);
            setY(mouseY);
            
            println("hello"+"\t"+this.circleX+"\t"+this.circleY);
        }
        redraw();
    }
}
