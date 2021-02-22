import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Avery Moates
 *
 */
public class Pizza implements Comparable{

	private int pizzaId;
	private int numIngredients;
	private ArrayList<String> ingredients = new ArrayList<String>();
	
	public Pizza(String[] line, int pizzaId) {
		this.pizzaId = pizzaId;
		this.numIngredients = Integer.parseInt(line[0]);
		for(int i=0; i<this.numIngredients; ++i) {
			ingredients.add(line[i+1]);
		}
	}
	
	public int getID() {
		return this.pizzaId;
	}
	
	public int getNumIngredients() {
		return this.numIngredients;
	}
	
	public ArrayList<String> getIngredients(){
		return this.ingredients;
	}
	
	public ArrayList<String> getCopiedIngredients(){
		ArrayList<String> copied = new ArrayList<String>();
		for(int i=0; i<numIngredients; ++i) {
			copied.add(ingredients.get(i));
		}
		return copied;
	}
	
	public String toString() {
		String line ="The amount of ingredients are: " 
				+this.numIngredients+" and the pizza ID is " 
				+this.pizzaId+ " [";
		for(int i=0; i<numIngredients; ++i) {
			line += " " + ingredients.get(i) +",";
		}
		line += "]";
		return line;
	}
	
	@Override
	public int compareTo(Object o) {
		int compareTo = 0;
		if(this.numIngredients == ((Pizza) o).getNumIngredients()) {
			compareTo = 0;
		}
		else if(this.numIngredients < ((Pizza) o).getNumIngredients()) {
			compareTo = -1;
		}
		else if(this.numIngredients > ((Pizza) o).getNumIngredients()) {
			compareTo = 1;
		}
		return compareTo;
	}
	
	
	
}
