/**
 * This class represents a flower.
 * 
 * @author rayra
 *
 */
public class Flower extends Plant {
	private String[] design;
	private String abb;
	private String species;
	private int growth;
	
	/**
	 * We create a flower by giving its abbreviation and species. We also keep 
	 * track of its array of strings, the number of times it has been asked to 
	 * grow, and the fact that it is a flower.
	 * 
	 * @param abb: one letter abbreviation
	 * @param species: name of species
	 */
	Flower(String abb, String species) {
		this.design = new String[5];
		this.growth = 0;
		this.abb = abb;
		this.species = species;
		this.type = "flower";
		for (int i = 0; i < 5; i++) {
			// start flowers in the middle
			if (i == 2) {
				design[i] = ".." + abb + "..";
			}
			else {
				design[i] = ".....";
			}
		}
	}
	
	/**
	 * Flowers grow out.
	 */
	void grow() {
		this.growth += 1;
		if (this.growth == 1) {
			this.design[2] = "." + abb + abb + abb + ".";
			this.design[1] = ".." + abb + "..";
			this.design[3] = ".." + abb + "..";
		}
		if (growth == 2) {
			this.design[2] = abb + abb + abb + abb + abb;
			this.design[1] = "." + abb + abb + abb + ".";
			this.design[3] = "." + abb + abb + abb + ".";
			this.design[0] = ".." + abb + "..";
			this.design[4] = ".." + abb + "..";
		}
		if (growth == 3) {
			this.design[1] = abb + abb + abb + abb + abb;
			this.design[3] = abb + abb + abb + abb + abb;
			this.design[0] = "." + abb + abb + abb + ".";
			this.design[4] = "." + abb + abb + abb + ".";
		}
		if (growth == 4) {
			this.design[0] = abb + abb + abb + abb + abb;
			this.design[4] = abb + abb + abb + abb + abb;
		}
	}
	
	String get_species() {
		return this.species;
	}
	
	String[] get_design() {
		return this.design;
	}
	
}
