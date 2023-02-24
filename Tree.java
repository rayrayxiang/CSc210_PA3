/**
 * This class represents a tree.
 * 
 * @author rayra
 *
 */
public class Tree extends Plant {
	private String[] design;
	private String abb;
	private String species;
	private int growth;
	
	/**
	 * We create a tree by giving its abbreviation and species. We also keep 
	 * track of its array of strings, the number of times it has been asked to 
	 * grow, and the fact that it is a tree.
	 * 
	 * @param abb: one letter abbreviation
	 * @param species: name of species
	 */
	Tree(String abb, String species) {
		this.design = new String[5];
		this.growth = 4;
		this.abb = abb;
		this.species = species;
		this.type = "tree";
		for (int i = 0; i < 5; i++) {
			// start tree on the bottom
			if (i == 4) {
				this.design[i] = ".." + abb + "..";
			}
			else {
				this.design[i] = ".....";
			}
		}
	}
	
	/**
	 * Trees grow up.
	 */
	void grow() {
		this.growth -= 1;
		if (this.growth >= 0) {
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
