package imageProcessingToolkit;

import processing.core.PImage;

/**
 * This class creates circularly cropped images.
 * @author ASHWIN
 *@version : 1.0
 */
public class CropImage {
	private int imgLeft;
	private int imgTop;
	private int imgWidth;
	private int imgHeight;
	private PImage pimage;
	private PImage tempPImage;
	/**
	 * Constructor for the class CropImage.
	 * @param center : Decides the center for the cropped image.
	 * @param width : Width of the circularly cropped image.
	 * @param height : Height of the circularly cropped image.
	 */
	public CropImage(PImage pimage,int center,int width,int height){
		tempPImage = new PImage(width,height);
		this.pimage = pimage;
		setImageCoords(center,width,height);
		setPImage(crop());
	}
	/**
	 * Method to get the cropped PImage object.
	 * @return : Returns the PImage Object.
	 */
	public PImage getPImage(){
		return tempPImage;
	}
	/**
	 * Sets the PImage for the class that can be accessed through getPImage.
	 * @param pi : Parameter for setPImage method.
	 */
	public final void setPImage(final PImage pi) {
		tempPImage = pi;
	}
	/**
	 * Method to crop the PImage.
	 * @return Returns the PImage object of cropped PImage.
	 */
	public PImage crop(){
		tempPImage.copy(pimage, imgLeft, imgTop, imgWidth, imgHeight, 0, 0, imgWidth, imgHeight);
		return tempPImage;
	}
	
	/**
	 * Thie method sets the left and top coordinates from input
	 * PImage so as to crop it.
	 * @param center : Capture the center from where the image is to cropped.
	 * @param width : Capture the width of the cropped image.
	 * @param height : Capture the height of the cropped image.
	 */
	public void setImageCoords(final int center, final int width,
			final int height) {
		imgLeft = center - width / 2;
		imgTop = center - height / 2;
		imgWidth = width;
		imgHeight = height;
	}
}
