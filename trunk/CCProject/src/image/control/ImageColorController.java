package image.control;


import processing.core.PApplet;
import processing.core.PImage;

public class ImageColorController extends PApplet {
    private int     Threshold = 0;
    private int     blue               = 0;
    private int     green               = 0;
    private float   ThresholdLevel           = 1.0f;
    private int     red               = 0;
    private boolean CircleDrawn    = false;
    private PImage  img;
    private ImageHandler imageHandler;

    public ImageColorController(HandleImage handleImage) {
        imageHandler = (ImageHandler)handleImage;
    }

    @Override
	public final void setup() {
        size(img.width, img.height);
    }

    @Override
	public void draw() {
    	imageHandler.tint(red, green, blue);
    	imageHandler.image(imageHandler.getPImage(), 0, 0, imageHandler.getPImage().width,
        		imageHandler.getPImage().height);

        if (CircleDrawn) {
        	imageHandler.filter(Threshold, ThresholdLevel);
        }

        imageHandler.setPImage(imageHandler.get(0, 0, imageHandler.getPImage().width,
        		imageHandler.getPImage().height));
        imageHandler.noLoop();
    }

    public void SetR(int r) {
        red = r;
    }

    public void SetG(int g) {
        green = g;
    }

    public void SetB(int b) {
        blue = b;
    }

    public void setPImage(PImage img) {
        this.img = img;
    }

    public PImage getPImage() {
        return img;
    }

    public int getThreshold() {
        return Threshold;
    }

    public void setThreshold() {
        this.Threshold = 0;
    }

    public void setThresholdLevel(int level) {
        this.Threshold = THRESHOLD;
        this.ThresholdLevel           = (float) level / 100;
    }

    public void isCircleDrawn(boolean cdp) {
        this.CircleDrawn = cdp;
    }
}
