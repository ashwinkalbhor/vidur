package image.control;

import processing.core.PImage;
/**
 * This inteface handles the abstract methods for handling and managing image components.
 * @author ASHWIN
 *
 */
public interface HandleImage {

	public abstract void draw(ImageHandler imageHandler);

	public abstract int getCircleRadius();

	public abstract PImage getPImage();

	public abstract int getThresholdParam();

	public abstract int getX();

	public abstract int getY();

	public abstract void setCircleDrawnParam(final boolean cdp);

	public abstract void setCircleRadius(final float cr);

	public abstract void setPImage(final String path);

	public abstract void setPImage(final PImage pi);

	public abstract void setStrokeWeight(final int wt);

	public abstract void setThresholdParam();

	public abstract void setThresholdLevel(final int level);

	public abstract void setup();

	public abstract void mouseDragged();

	public abstract void setDimForOriginal(PImage pImage);

	public abstract void redraw();

}