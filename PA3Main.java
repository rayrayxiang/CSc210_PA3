import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class handles a text file that manipulates the Garden object. As long 
 * as the file follows the format of the spec, we can have trees, vegetables, 
 * and flowers and even print them out.
 * 
 * @author rayra
 * 
 */
public class PA3Main {
	
	public static void main(String[] file_name) {
		try {
			Scanner file = new Scanner(new File(file_name[0]));
			int n_rows = Integer.parseInt(file.nextLine().split(" ")[1]);
			int n_cols = Integer.parseInt(file.nextLine().split(" ")[1]);
			// exit if the file tries to make a garden that's too wide
			if (n_cols <= 16) {
				Garden garden = new Garden(n_rows, n_cols);
				file.nextLine();
				run_commands(file, garden);
			}
			else {
				System.out.print("Too many plot columns.");
			}
			file.close();
		}
		catch (FileNotFoundException exception) {
			System.out.println("The file was not found!");
		}
	}
	
	/**
	 * There were too many types of commands to handle ;-;. This method applies 
	 * commands from the text file to the Garden object.
	 * 
	 * @param file: the text file that contains the commands
	 * @param garden: the garden
	 */
	static void run_commands(Scanner file, Garden garden) {
		while (file.hasNext()) {
			String[] command = file.nextLine().split(" ");
			int command_length = command.length;
			// sort commands based on length
			switch (command_length){
				case 1: 
					single_command(command, garden);
					break;
				
				case 2: 
					double_command(command, garden);
					break;
				
				case 3: 
					triple_command(command, garden);
					break;
				default:
					break;
			}
		}	
	}
	
	/**
	 * This method handles commands of length 1.
	 * 
	 * @param command: the action to perform
	 * @param garden: the garden
	 */
	static void single_command(String[] command, Garden garden) {
		String action = command[0].toUpperCase();
		if (!action.equals("PRINT")) {
			System.out.println("> " + action + "\n");
		}
		switch (action) {
			case "PRINT":
				System.out.println("> PRINT");
				garden.print_garden();
				break;	
			case "CUT":
				garden.destroy_all("tree");
				break;
			case "HARVEST":
				garden.destroy_all("vegetable");
				break;
			case "PICK":
				garden.destroy_all("flower");
				break;
			default:
				break;
		}
	}
	
	/**
	 * This method handles commands of length 2.
	 * 
	 * @param command: the action and a second component (either number of 
	 * times to grow or location or species to destroy)
	 * @param garden: the garden
	 */
	static void double_command(String[] command, Garden garden) {
		String action = command[0].toUpperCase();
		String two = command[1];
		System.out.println("> " + action + " " + two + "\n");
		switch (action) {
			case "GROW":
				garden.grow(Integer.parseInt(two));
				break;
			case "CUT":
				decide(action, two, garden, "tree");
				break;
			case "HARVEST":
				decide(action, two, garden, "vegetable");
				break;
			case "PICK":
				decide(action, two, garden, "flower");
				break;
			default:
				break;
		}
	}
	
	/**
	 * This method helps double_command decide whether to destroy a species or 
	 * just at one location.
	 * 
	 * @param action: cut, harvest, or pick
	 * @param two: coords or species
	 * @param garden: the garden
	 * @param type: tree, vegetable, or flower
	 */
	static void decide(String action, String two, Garden garden, String type) {
		if (two.matches("[a-zA-Z]*")) {
			garden.destroy_this(two);
		}
		else {
			int x = Integer.parseInt(two.split(",")[0].replaceAll("[(]", ""));
			int y = Integer.parseInt(two.split(",")[1].replaceAll("[)]", ""));
			garden.destroy_here(type, action, x, y);
		}
	}
	
	/**
	 * This method handles commands of length 3.
	 * 
	 * @param command: the command split into three pieces
	 * @param garden: the garden
	 */
	static void triple_command(String[] command, Garden garden) {
		String action = command[0].toUpperCase();
		String two = command[1];
		String three = command[2];
		switch (action) {
		case "PLANT":
			int x = Integer.parseInt(two.split(",")[0].replaceAll("[(]", ""));
			int y = Integer.parseInt(two.split(",")[1].replaceAll("[)]", ""));
			garden.plant(x, y, three.toLowerCase());
			break;
		case "GROW":
			System.out.println("> " + action + " " + two + " " + three + "\n");
			how_grow(two, three, garden);
			break;
		default:
			break;
		}
	}
	
	/**
	 * This method helps triple_command decide whether to grow a specific type 
	 * of plant (tree, vegetable, or flower) or to grow at a location.
	 * 
	 * @param two: in this case, the number of times to grow
	 * @param three: species or coords
	 * @param garden: the garden
	 */
	static void how_grow(String two, String three, Garden garden) {
		int times = Integer.parseInt(two);
		if (three.matches("[a-zA-Z]*")) {
			garden.grow(times, three);
		}
		else {
			int i = Integer.parseInt(three.split(",")[0].replaceAll("[(]", ""));
			int j = Integer.parseInt(three.split(",")[1].replaceAll("[)]", ""));
			garden.grow(times, i, j);
		}
	}
	
}
