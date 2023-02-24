import java.util.HashMap;

/**
 * This class is the Garden object, which contains a 2D array of Plant objects.
 * 
 * @author rayra
 *
 */
public class Garden {
	private Plant[][] grid;
	private int n_rows;
	private int n_cols;
	private HashMap<String, String> flowers = new HashMap<String, String>();
	private HashMap<String, String> trees = new HashMap<String, String>();
	private HashMap<String, String> vegetables = new HashMap<String, String>();
	
	/**
	 * Our garden is characterized by its number of rows and columns and its 
	 * 2D array.
	 * 
	 * @param n_rows
	 * @param n_cols
	 */
	Garden(int n_rows, int n_cols) {
		fill_hashmaps();
		this.n_rows = n_rows;
		this.n_cols = n_cols;
		this.grid = new Plant[n_rows][n_cols];
	}
	
	/**
	 * These hashmaps help classify a plant as a flower, tree, or vegetable and
	 * store its abbreviation, which is needed to create a Plant object.
	 */
	void fill_hashmaps() {
		trees.put("oak", "o");
		trees.put("willow", "w");
		trees.put("banana", "b");
		trees.put("coconut", "c");
		trees.put("pine", "p");
		
		vegetables.put("garlic", "g");
		vegetables.put("zucchini", "z");
		vegetables.put("tomato", "t");
		vegetables.put("yam", "y");
		vegetables.put("lettuce", "l");
		
		flowers.put("iris", "i");
		flowers.put("lily", "l");
		flowers.put("rose", "r");
		flowers.put("daisy", "d");
		flowers.put("tulip", "t");
		flowers.put("sunflower", "s");
	}
	
	/**
	 * Adds the correct kind of Plant object to a specific location in 
	 * the 2D array.
	 * 
	 * @param x: first dimension
	 * @param y: second dimension
	 * @param species: name of plant
	 */
	void plant(int x, int y, String species) {
		// classify the plant as a tree, vegetable, or flower
		if (trees.containsKey(species)) {
			this.grid[x][y] = new Tree(trees.get(species), species);
		}
		if (vegetables.containsKey(species)) {
			this.grid[x][y] = new Vegetable(vegetables.get(species), species);
		}
		if (flowers.containsKey(species)) {
			this.grid[x][y] = new Flower(flowers.get(species), species);
		}
	}
	
	/**
	 * Grows all plants.
	 * 
	 * @param times: number of times to grow
	 */
	void grow(int times) {
		for (Plant[] row : this.grid) {
			for (Plant plant : row) {
				if (plant != null) {
					for (int i = 0; i < times; i++) {
						plant.grow();
					}
				}
			}
		}
	}
	
	/**
	 * Grows a plant at a specific location.
	 * 
	 * @param times: number of times to grow
	 * @param x: first dimension
	 * @param y: second dimension
	 */
	void grow(int times, int x, int y) {
		if (x < this.n_rows && y < this.n_cols && this.grid[x][y] != null) {
			for (int i = 0; i < times; i++) {
				this.grid[x][y].grow();
			}
		}
		else {
			System.out.println("Can't grow there.\n");
		}
	}
	
	/**
	 * Grows all plants of a specific type.
	 * 
	 * @param times: number of times to grow
	 * @param type: type of plant
	 */
	void grow(int times, String type) {
		for (Plant[] row : this.grid) {
			for (Plant plant : row) {
				for (int i = 0; i < times; i++) {
					if (plant != null && plant.type.equals(type)) {
						plant.grow();
					}
				}
			}
		}
	}
	
	/**
	 * Removes all plants of a certain type.
	 * 
	 * @param type: type of plant
	 */
	void destroy_all(String type) {
		for (int x = 0; x < n_rows; x++) {
			for (int y = 0; y < n_cols; y++) {
				if (this.grid[x][y] != null && this.grid[x][y].type.equals(type)) {
					this.grid[x][y] = null;
				}
			}
		}
	}
	
	/**
	 * Destroys a plant at a specific location.
	 * 
	 * @param type: tree, vegetable, or flower
	 * @param action: cut, harvest, or pick
	 * @param x: first dimension
	 * @param y: second dimension
	 */
	void destroy_here(String type, String action, int x, int y) {
		if (x < this.n_rows && y < this.n_cols && this.grid[x][y] != null && this.grid[x][y].type.equals(type)) {
			grid[x][y] = null;
		}
		else {
			System.out.println("Can't " + action.toLowerCase() + " there.\n");
		}
	}
	
	/**
	 * Destroys all plants of a specific species.
	 * 
	 * @param species: species of plant
	 */
	void destroy_this(String species) {
		for (int x = 0; x < n_rows; x++) {
			for (int y = 0; y < n_cols; y++) {
				if (this.grid[x][y] != null && this.grid[x][y].get_species().equals(species.toLowerCase())) {
					this.grid[x][y] = null;
				}
			}
		}
	}
	
	/**
	 * Prints the garden.
	 */
	void print_garden() {
		for (Plant[] row : this.grid) {
			for (int i = 0; i < 5; i++) {
				for (Plant plant : row) {
					if (plant != null) {
						System.out.print(plant.get_design()[i]);
					}
					else {
						System.out.print(".....");
					}
				}
			System.out.print("\n");
			}
		}
		System.out.print("\n");
	}
	
}
