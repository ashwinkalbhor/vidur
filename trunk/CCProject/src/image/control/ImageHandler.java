package image.control;


import processing.core.PApplet;
import processing.core.PImage;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author ASHWIN
 *
 */
public class ImageHandler extends PApplet implements HandleImage {
    private static final long serialVersionUID = -5394191045615392851L;
    private int               ThresholdParam  = 0;
    private int 			  pAppletHeight = 550;
    private int				  pAppletWidth = 400;
    private float             blue                = 255.0f;
    private float             CircleRadius               = 200.0f;
    private int               CiecleX               = 0;
    private int               CircleY               = 0;
    private float             green               = 255.0f;
    private float             ThresholdLevel            = 1.0f;
    private String            path             = null;
    private float             red                = 255.0f;
    private float             StrokeWt               = 0.0f;
    private boolean           CircleDrawn     = false;
    private PImage            img, subimg, tempImg;
    private float             top, left, height, width;

    public ImageHandler(final String path) {
        this.path = path;
    }

    @Override
    public final void draw() {
        fill(100);
        rect(0, 0, 550, 400);
        translate(width / 2, height / 2);

        if (getThreshlodParam() == THRESHOLD) {
            img.filter(THRESHOLD, ThresholdLevel);

            Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, this.img.width, img.height);

            for (int i = 0; i < img.width; i++) {
                for (int j = 0; j < this.img.height; j++) {
                    if (!ellipse.contains(i, j)) {
                        img.set(i, j, -10197916);
                    }
                }
            }
            setPImage(img);
        }
        image(img, left, top, height, width);
        setStroke();
        rect(CiecleX - CircleRadius / 2.0f, CircleY - CircleRadius / 2.0f, CircleRadius, CircleRadius);
        ellipse(CiecleX, CircleY, CircleRadius, CircleRadius);
        noFill();
        noLoop();
    }

    public final void drawSubImage(final PImage im, final int x, final int y, final int rad) {
        int ImX = (int) (((((im.width / 2) + x / getScaleParam(im.width, im.height))))
                         - ((rad / 2.0f) / getScaleParam(im.width, im.height)));
        int ImY = (int) (((((im.height / 2) + y / getScaleParam(im.width, im.height))))
                         - ((rad / 2.0f) / getScaleParam(im.width, im.height)));

        subimg = new PImage((int) (rad / getScaleParam(im.width, im.height)),
                            (int) (rad / getScaleParam(im.width, im.height)));
        subimg.copy(im, ImX, ImY, (int) (rad / getScaleParam(im.width, im.height)),
                    (int) (rad / getScaleParam(im.width, im.height)), 0, 0,
                    (int) (rad / getScaleParam(im.width, im.height)), (int) (rad / getScaleParam(im.width, im.height)));

        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, subimg.width, subimg.height);

        // BufferedImage bimage = (BufferedImage) subimg.getImage();
        // ColorModel cmodel = bimage.getColorModel();
        for (int i = 0; i < subimg.width; i++) {
            for (int j = 0; j < subimg.height; j++) {
                if (!ellipse.contains(i, j)) {
                    subimg.set(i, j, -10197916);
                }
            }
        }
        setPImage(subimg);
        settempImage(subimg);
        if (getScaleParam(img.width, img.height) > 1) {
            left = -150;
            top  = -150;
            height    = 300;
            width    = 300;
        } else {
            setDimForOriginal(img);
        }
    }
    public final boolean getCircleDrawnParam() {
        return CircleDrawn;
    }
    public final int getCircleRadius() {
        return (int) CircleRadius;
    }
    public final String getFilePath() {
        return path;
    }
    public final PImage getPImage() {
        return img;
    }
    public final float getScaleParam(final int a, final int b) {
        float scaleA = (float) pAppletHeight / a;
        float scaleB = (float) pAppletWidth / b;

        if (scaleA < scaleB) {
            return scaleA;
        }

        return scaleB;
    }

    public final PImage gettempImage() {
        return tempImg;
    }

    public final int getThreshlodParam() {
        return ThresholdParam;
    }
    @Override
    public final int getX() {
        return CiecleX;
    }
    @Override
    public final int getY() {
        return CircleY;
    }
    public final void setBlue(final float b) {
        blue = b;
    }

    public final void isCircleDrawn(final boolean cdp) {
        CircleDrawn = cdp;
    }
    public final void setCircleRadius(final float cr) {
        CircleRadius = cr;
    }
    public final void setDimForOriginal(final PImage img) {
        left = -img.width * getScaleParam(img.width, img.height) / 2.0f;
        top  = -img.height * getScaleParam(img.width, img.height) / 2.0f;
        height    = img.width * getScaleParam(img.width, img.height);
        width    = img.height * getScaleParam(img.width, img.height);
    }
    public final void setDimForSubImage(final PImage img, final int cr) {
        if (getScaleParam(img.width, img.height) > 1) {
            left = -150;
            top  = -150;
            height    = 300;
            width    = 300;
        } else {
            top  = -((cr / 2.0f) / getScaleParam(img.width, img.height)) / 2.0f;
            left = -((cr / 2.0f) / getScaleParam(img.width, img.height)) / 2.0f;
            height    = (cr / 2.0f) / getScaleParam(img.width, img.height);
            width    = (cr / 2.0f) / getScaleParam(img.width, img.height);
        }
    }
    public final void setGreen(final float gr) {
        green = gr;
    }
    public final void setPImage(final String path) {
        this.path            = path;
        ThresholdParam = 0;
        img= loadImage(path);
    }
    public final void setPImage(final PImage pi) {
        img = pi;
        setDimForOriginal(img);
    }
    public final void setRed(final float r) {
        red = r;
    }
    public final void setStroke() {
        stroke(255, 0, 0, StrokeWt);
        strokeWeight(1.0f);
        noFill();
    }

    public final void setStrokeWeight(final int wt) {
        StrokeWt = wt;
    }

    public final void settempImage(final PImage pi) {
        tempImg = pi;
    }

    public final void setThresholdParam() {
        ThresholdParam = 0;
    }
    public final void setThresholdLevel(final int level) {
        ThresholdParam = THRESHOLD;
        ThresholdLevel = (float) level / 100;
    }

  public final void setX(final int cx) {
        CiecleX = (int) (cx - width / 2);
    }
    public final void setY(final int cy) {
        CircleY = (int) (cy - height / 2);
    }

    @Override
    public final void setup() {
        size(pAppletHeight, pAppletWidth);
        img = new PImage();
        smooth();
    }

    @Override
    public final void mouseDragged() {
        if (getCircleDrawnParam()) {
            setX(mouseX);
            setY(mouseY);
        }

        redraw();
    }

	@Override
	public void draw(ImageHandler imageHandler) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getThresholdParam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCircleDrawnParam(boolean cdp) {
		// TODO Auto-generated method stub
	}
}


