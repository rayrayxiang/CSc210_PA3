/**
 * This class represents a vegetable.
 * 
 * @author rayra
 *
 */
public class Vegetable extends Plant{
	private String[] design;
	private String abb;
	private String species;
	private int growth;
	
	/**
	 * We create a vegetable by giving its abbreviation and species. We also 
	 * keep track of its array of strings, the number of times it has been 
	 * asked to grow, and the fact that it is a vegetable.
	 * 
	 * @param abb: one letter abbreviation
	 * @param species: name of species
	 */
	Vegetable(String abb, String species) {
		this.design = new String[5];
		this.growth = 0;
		this.abb = abb;
		this.species = species;
		this.type = "vegetable";
		for (int i = 0; i < 5; i++) {
			// start vegetables at the top
			if (i == 0) {
				this.design[i] = ".." + abb + "..";
			}
			else {
				this.design[i] = ".....";
			}
		}
	}
	
	/**
	 * Vegetables grow down.
	 */
	void grow() {
		this.growth += 1;
		if (this.growth <= 4) {
			this.design[this.growth] = ".." + abb + "..";
		}
	}
	
	String get_species() {
		return this.species;
	}
	
	String[] get_design() {
		return this.design;
	}
	
}
