import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Avery Moates
 *
 */
public class Pizzeria {
	
	private ArrayList<Pizza> pizzas;
	private Set<String> totalIngredients;
	private int numOfPizzas;
	private int numOfIngredients;
	
	public Pizzeria() {
		this.pizzas =new ArrayList<Pizza>();
		this.totalIngredients = new TreeSet<String>();
		this.numOfPizzas = 0;
	}
	
	public ArrayList<Pizza> getPizzas(){
		return pizzas;
	}
	
	public Pizza getPizza(int index) {
		return pizzas.get(index);
	}
	
	public Set<String> getTotalIngredients(){
		return totalIngredients;
	}
	
	public int getNumOfPizzas() {
		return this.numOfPizzas;
	}
	
	public int getNumOfIngredients() {
		return this.numOfIngredients;
	}
	
	public static int getDiffIngrPizzas(Pizza a, Pizza b) {
		int num = 0;
		Set<String> ingredients = new TreeSet<String>();
		for(int i=0; i<a.getNumIngredients(); ++i) {
			ingredients.add(a.getIngredients().get(i));
		}
		for(int i=0; i<b.getNumIngredients(); ++i) {
			ingredients.add(b.getIngredients().get(i));
		}
		
		num = ingredients.size();
		return num;
	}
	
	public static int getDiffIngrPizzas(Pizza a, Pizza b, Pizza c) {
		int num = 0;
		Set<String> ingredients = new TreeSet<String>();
		for(int i=0; i<a.getNumIngredients(); ++i) {
			ingredients.add(a.getIngredients().get(i));
		}
		for(int i=0; i<b.getNumIngredients(); ++i) {
			ingredients.add(b.getIngredients().get(i));
		}
		for(int i=0; i<c.getNumIngredients(); ++i) {
			ingredients.add(c.getIngredients().get(i));
		}
		
		num = ingredients.size();
		return num;
	}
	
	public static int getDiffIngrPizzas(Pizza a, Pizza b, Pizza c, Pizza d) {
		int num = 0;
		Set<String> ingredients = new TreeSet<String>();
		for(int i=0; i<a.getNumIngredients(); ++i) {
			ingredients.add(a.getIngredients().get(i));
		}
		for(int i=0; i<b.getNumIngredients(); ++i) {
			ingredients.add(b.getIngredients().get(i));
		}
		for(int i=0; i<c.getNumIngredients(); ++i) {
			ingredients.add(c.getIngredients().get(i));
		}
		for(int i=0; i<d.getNumIngredients(); ++i) {
			ingredients.add(d.getIngredients().get(i));
		}
		
		num = ingredients.size();
		return num;
	}
	
	
	
	public void addPizza(Pizza a) {
		this.pizzas.add(a);
		++this.numOfPizzas;
	}
	
	public Pizza takePizza(int index) {
		Pizza pizza = pizzas.remove(index);
		--this.numOfPizzas;
		return pizza;
	}
	
	public void sort() {
		Collections.sort(pizzas);
		Collections.reverse(pizzas);
	}
	
	public void calNumOfIngredients() {
		for(int i=0; i<this.numOfPizzas; ++i) {
			for(int j=0; j<pizzas.get(i).getNumIngredients(); ++j) {
				totalIngredients.add(pizzas.get(i).getIngredients().get(j));
			}
		}
		this.numOfIngredients = totalIngredients.size();
	}
	
	public void printPizzas() {
		for(int i=0; i<this.numOfPizzas; ++i) {
			System.out.println(pizzas.get(i).toString());
		}
	}
	public void printIngredients() {
		for(String a : this.totalIngredients) {
			System.out.println(a);
		}
	}

}
