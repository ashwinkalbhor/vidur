package logic.colony;

import java.awt.Dimension;

/**
 * This class defines the colony properties.
 * @author ASHWIN
 *
 */
public class ColonyCharacteristics {
	private Dimension colonyDim ;
	private int colonyArea;
	private int colonyColor;
	private int colSize;
	/**
	 * Constructor for the ColonyCharacteristics class.
	 * @param colonyDim : Recieves the colony dimensions.
	 * @param colonyArea : Receives the colony size(area).
	 * @param colonyColor : Receives the colony color.
	 */
	public ColonyCharacteristics(final Dimension colonyDim,
			final int colonyArea, final int colonyColor) {
		this.colonyDim = colonyDim;
		this.colonyArea = colonyArea;
		this.colonyColor = colonyColor;
	}
	/**
	 * Method to get colony dimensions.
	 * @return Returns the Dimension object for colony size.
	 */
	public Dimension getColonyDim() {
		return colonyDim;
	}
	/**
	 * Method to get area covered by colony.
	 * @return
	 */
	public int getColonyArea() {
		return colonyArea;
	}
	public int getColonyColor() {
		return colonyColor;
	}
	
	public boolean isColony(int colSize){
		if(colonyArea > colSize){
			return true;
		}
		return false;
	}
}
