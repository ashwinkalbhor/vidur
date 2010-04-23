package logic.control;

import processing.core.PImage;
/**
 * This class has methods to count the colonies in the given cropped Image.
 * @author ASHWIN
 * Version : 1.0
 */
public class CountColonies {
	/**
	 * @param totalColonies : Initialises the colonycounter to 0.
	 */
	private int totalColonies = 0;
	/**
	 * @param img : Defines the PImage object used in the class.
	 */
    private PImage img;
    /**
     * @param colonyColor : static final variable sets the colony color to black.
     */
    private static final int colonyColor = -16777216;
    /**
     * static final variable sets the colony size threshold to 25.
     */
    private static final int colonySize = 25;

    /**
     * Contructor of class CountColonies.
     */
    public CountColonies(PImage img) {
    	setPImage(img);
    	count(img);
    }

    /**
     * Method to clean the colony recursively after getting counted .
     * @param img : Accepts PImage object .
     * @param x : Xth coord of the colony center.
     * @param y : Yth coord of the colony center.
     * @return : Returns PImage object after cleaning the respective colony.
     */
    public final PImage clean(PImage img, int x, int y) {
        int a = x;
        int b = y;

        try {
        if (img.get(a + 1, b) == colonyColor) {
                img.set(a + 1, b, -1);
                setPImage(img);
                clean(getPImage(), a + 1, b);
            }
            if (img.get(a, b + 1) == colonyColor) {
                img.set(a, b + 1, -1);
                setPImage(img);
                clean(getPImage(), a, b + 1);
            }
            if (img.get(a - 1, b) == colonyColor) {
                img.set(a - 1, b, -1);
                setPImage(img);
                clean(getPImage(), a - 1, b);
            }
            if (img.get(a, b - 1) == colonyColor) {
                img.set(a, b - 1, -1);
                setPImage(img);
                clean(getPImage(), a, b - 1);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return img;
    }

    /**
     * This method accepts PImage object and counts the number of
     * colonies. The count is stored in totalColonies variable.
     * @param img : Accepts PImage object from the user.
     */
    public final void count(final PImage img) {
        for (int i = 2; i < getPImage().height - 2; i++) {
            for (int j = 2; j < getPImage().width - 2; j++) {
                if (neighbours(getPImage(), i, j) == colonySize) {
                    totalColonies++;
                    setPImage(clean(getPImage(), i, j));
                }
            }
        }
    }

    /**
     * This method returns the colony number.
     * @return : returns totalColonies in the image provided to count function.
     */
    public int getColonyCount() {
        return totalColonies;
    }

    /**
     * This method requires object of PImage and returns the total number of
     * pixels belonging to colony in 5x5 kernel around the pixel under
     * consideration.
     * @param img : PImage object received from count function.
     * @param a : Xth coord of current pixel .
     * @param b : Yth coord of current pixel .
     * @return : Returns total size(int) of the 5x5 kernel
     */
    public final int neighbours(final PImage img, final int a, final int b) {
        int totalPixels = 0;

        for (int i = a - 2; i <= a + 2; i++) {
            for (int j = b - 2; j <= b + 2; j++) {
                if (getPImage().get(i, j) == colonyColor) {
                    totalPixels++;
                }
            }
        }

        return totalPixels;
    }
    /**
     * Setter for PImage , accepts PImage object only .
     * @param pi : Object of PImage.
     */
    public final void setPImage(final PImage pi) {
        img = pi;
    }

    /**
     * Getter for PImage , returns PImage object .
     * @return : PImage - Object
     */
    public final PImage getPImage() {
        return img;
    }
}


