package canteen;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Canteen {
	// Kitchen will just print out the orders
	private KitchenInterface kitchenScreen;
	// Simulate all customer interfaces
	private ArrayList<CustomerInterface> customerScreens;
	private OrderProcessor op;
	private Menu menu;
	
	private void fillMenu() {
		ArrayList<Item> items = new ArrayList<Item>();

		items.add(new Beverage("Cola", 13.00, 0));
		items.add(new Dish("Rice", 9.00, 1));
		items.add(new Dish("Steak", 60.00, 2));
		items.add(new ComboItem("Steak&Rice", new ArrayList<Item>(Arrays.asList(items.get(1), items.get(2))), 0.9, 3));
		
		menu = new Menu(items);
	}
	
	private void printMenu(ArrayList<Item> menuItems) {
		for(int i = 0; i < menuItems.size(); i++) {
			System.out.println("[" + menuItems.get(i).getID() + "] " + menuItems.get(i).getName() + "\t| $" + menuItems.get(i).getPrice());
		}
	}
	
	public void runInterfaces() {
		long startTime = Instant.now().getEpochSecond();
		kitchenScreen = new KitchenInterface(startTime);
		customerScreens = new ArrayList<CustomerInterface>();
		op = new OrderProcessor();
		
		fillMenu();
		
		for(int i = 1; i <= 5; i++) {
			CustomerInterface temp = new CustomerInterface(i, kitchenScreen, startTime);
			temp.update(menu);
			customerScreens.add(temp);
		}
		
		for(int i = 0; i < 5; i++) {
			CustomerInterface temp = customerScreens.get(i);
			new Thread(() -> temp.simulateCustomer()).start();
		}
		
		new Thread(() -> kitchenScreen.simulateKitchen()).start();
	}
}
