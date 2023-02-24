/**
 * This is the abstract Plant object. Whenever we want to make a plant, we 
 * instead make a subclass. All plants have a type: tree, vegetable, or flower.
 * 
 * @author rayra
 *
 */
public abstract class Plant {
	
	protected String type;
	
	/**
	 * Grows the plant once.
	 */
	abstract void grow();
	
	/** 
	 * @return the plant species
	 */
	abstract String get_species();
	
	/**
	 * @return the 1D array representing each row of the plant to print
	 */
	abstract String[] get_design();
	
}
