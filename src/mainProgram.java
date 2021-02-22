import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Avery Moates
 *
 */
public class mainProgram {
	static String fileA = "a_example.txt";
	static String fileB = "b_little_bit_of_everything.txt";
	static String fileC = "c_many_ingredients.txt";
	static String fileD = "d_many_pizzas.txt";
	static String fileE = "e_many_teams.txt";
	
	static String outputA = "a_output.txt";
	static String outputB = "b_output.txt";
	static String outputC = "c_output.txt";
	static String outputD = "d_output.txt";
	static String outputE = "e_output.txt";
	
	
	static Pizzeria pizzeria = new Pizzeria();
	static int numOfFour =0;
	static int numOfThree =0;
	static int numOfTwo =0;

	public static void main(String[] args) throws IOException {

		String filename = "";
		String outputFile = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Please type the desired input. A, B, C, D, E");
		String desiredInput = input.next();
		input.close();
		if(desiredInput.equalsIgnoreCase("A")) {
			filename = fileA;
			outputFile = outputA;
		}
		else if(desiredInput.equalsIgnoreCase("B")) {
			filename = fileB;
			outputFile = outputB;
		}
		else if(desiredInput.equalsIgnoreCase("C")) {
			filename = fileC;
			outputFile = outputC;
		}
		else if(desiredInput.equalsIgnoreCase("D")) {
			filename = fileD;
			outputFile = outputD;
		}
		else if(desiredInput.equalsIgnoreCase("E")) {
			filename = fileE;
			outputFile = outputE;
		}
		FileReader fr = new FileReader(filename);
		
		try(BufferedReader br = new BufferedReader(fr)){
			String line = br.readLine();
			String[] numbers = line.split(" ");
			numOfTwo = Integer.parseInt(numbers[1]);
			numOfThree = Integer.parseInt(numbers[2]);
			numOfFour = Integer.parseInt(numbers[3]);
			//System.out.println(line);
			int id =0;
			while((line = br.readLine())!=null) {
				String[] temp = line.split(" ");
				Pizza currentPizza = new Pizza(temp, id);
				pizzeria.addPizza(currentPizza);
				++id;
				
			}
			pizzeria.calNumOfIngredients();
			pizzeria.sort();
		}
		
		ArrayList<Delivery> team4Deliveries = new ArrayList<Delivery>(); 
		ArrayList<Delivery> team3Deliveries = new ArrayList<Delivery>();
		ArrayList<Delivery> team2Deliveries = new ArrayList<Delivery>();
		
		int diffIngredients = 0;
		int inAllIngredients = 0;
		int index = 0;
		double ratio = 0;
		boolean canContinue = true;
		while(canContinue==true&&pizzeria.getNumOfPizzas()>=4&&numOfFour>0) {
			if((index+3)<pizzeria.getNumOfPizzas()) {
				diffIngredients = Pizzeria.getDiffIngrPizzas(pizzeria.getPizza(index), pizzeria.getPizza(index+1), pizzeria.getPizza(index+2), pizzeria.getPizza(index+3));
				inAllIngredients = pizzeria.getPizza(index).getNumIngredients() + pizzeria.getPizza(index+1).getNumIngredients() + pizzeria.getPizza(index+2).getNumIngredients() + pizzeria.getPizza(index+3).getNumIngredients();
				ratio = (double)diffIngredients / inAllIngredients;
				if(ratio == 1) {
					makeDeliveryOfFour(team4Deliveries);
					--numOfFour;
				}
			}
			else {
				canContinue = false;
			}
			++index;
		}
		canContinue = true;
		index = 0;
		while(canContinue==true&&pizzeria.getNumOfPizzas()>=3&&numOfThree>0) {
			if((index+2)<pizzeria.getNumOfPizzas()) {
				diffIngredients = Pizzeria.getDiffIngrPizzas(pizzeria.getPizza(index), pizzeria.getPizza(index+1), pizzeria.getPizza(index+2));
				inAllIngredients = pizzeria.getPizza(index).getNumIngredients() + pizzeria.getPizza(index+1).getNumIngredients() + pizzeria.getPizza(index+2).getNumIngredients();
				ratio = (double)diffIngredients / inAllIngredients;
				if(ratio == 1) {
					makeDeliveryOfThree(team3Deliveries);
					--numOfThree;
				}
			}
			else {
				canContinue = false;
			}
			++index;
		}
		canContinue = true;
		index = 0;
		while(canContinue==true&&pizzeria.getNumOfPizzas()>=2&&numOfTwo>0) {
			if((index+1)<pizzeria.getNumOfPizzas()) {
				diffIngredients = Pizzeria.getDiffIngrPizzas(pizzeria.getPizza(index), pizzeria.getPizza(index+1));
				inAllIngredients = pizzeria.getPizza(index).getNumIngredients() + pizzeria.getPizza(index+1).getNumIngredients();
				ratio = (double)diffIngredients / inAllIngredients;
				if(ratio == 1) {
					makeDeliveryOfTwo(team2Deliveries);
					--numOfTwo;
				}
			}
			else {
				canContinue = false;
			}
			++index;
		}
		
		while(pizzeria.getNumOfPizzas()>=4&&numOfFour>0) {
			makeDeliveryOfFour(team4Deliveries);
			--numOfFour;
		}
		while(pizzeria.getNumOfPizzas()>=3&&numOfThree>0) {
			makeDeliveryOfThree(team3Deliveries);
			--numOfThree;
		}
		while(pizzeria.getNumOfPizzas()>=2&&numOfTwo>0) {
			makeDeliveryOfTwo(team2Deliveries);
			--numOfTwo;
		}
		
		PrintWriter writer = new PrintWriter(outputFile);
		
		int totalPizzaDeliveried = team4Deliveries.size() + team3Deliveries.size() + team2Deliveries.size();
		writer.println(totalPizzaDeliveried);
		for(int i=0; i<team4Deliveries.size(); ++i) {
			writer.println(team4Deliveries.get(i).toString());
		}
		for(int i=0; i<team3Deliveries.size(); ++i) {
			writer.println(team3Deliveries.get(i).toString());
		}
		for(int i=0; i<team2Deliveries.size(); ++i) {
			writer.println(team2Deliveries.get(i).toString());
		}
		writer.close();
	}
	
	public static void makeDeliveryOfFour(ArrayList<Delivery> four) {
		//make delivery
		Pizza[] pizzas = new Pizza[4];
		for(int i=0; i<4; ++i) {
			Pizza pizza = pizzeria.takePizza(0);
			pizzas[i] = pizza;
		}
		Delivery delivery = new Delivery(4, pizzas);
		four.add(delivery);
	}
	
	public static void makeDeliveryOfThree(ArrayList<Delivery> three) {
		//make delivery
		Pizza[] pizzas = new Pizza[3];
		for(int i=0; i<3; ++i) {
			Pizza pizza = pizzeria.takePizza(0);
			pizzas[i] = pizza;
		}
		Delivery delivery = new Delivery(3, pizzas);
		three.add(delivery);
	}
	
	public static void makeDeliveryOfTwo(ArrayList<Delivery> two) {
		//make delivery
		Pizza[] pizzas = new Pizza[2];
		for(int i=0; i<2; ++i) {
			Pizza pizza = pizzeria.takePizza(0);
			pizzas[i] = pizza;
		}
		Delivery delivery = new Delivery(2, pizzas);
		two.add(delivery);	
	}

}
