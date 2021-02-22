

/**
 * 
 * @author avery
 *
 */
public class Delivery {
	
	Pizza[] pizzas;
	int[] pizzaIDs;
	int teamType = 0;
	
	public Delivery(int amount, Pizza[] a) {
		this.teamType = amount;
		this.pizzas = a;
		pizzaIDs = new int[amount];
		for(int i=0; i<this.teamType; ++i) {
			this.pizzaIDs[i] = this.pizzas[i].getID();
		}
	}
	
	public String toString() {
		String returnThis = "" + this.teamType;
		for(int i=0; i<this.teamType; ++i) {
			returnThis += " " + pizzaIDs[i] ;
		}
		
		return returnThis;
	}

}
