package canteen;

import java.util.ArrayList;
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
		
		menu = new Menu(items);
	}
	
	private void printMenu(Item menuItems[]) {
		for(int i = 0; i < menuItems.length; i++) {
			System.out.println("[" + menuItems[i].getID() + "] " + menuItems[i].getName() + "\t| $" + menuItems[i].getPrice());
		}
	}
	
	private void simulateCustomer() {
		Random random = new Random();
		Item menuItems[] = menu.getItems();
		printMenu(menuItems);
		
		for(int i = 0; i < 10; i++) { // 10 Fake orders
			int rScreen = random.nextInt(customerScreens.size());
			int nItems = random.nextInt(5) + 1; // Minimum 1 item
			for(int j = 0; j < nItems; j++) { // Amount of items to order
				int rItem = random.nextInt(menuItems.length); // Random item selected
				customerScreens.get(rScreen).addToOrder(menuItems[rItem]);
			}
			customerScreens.get(rScreen).sendOrder();
		}
	}
	
	public void runInterfaces() {
		kitchenScreen = new KitchenInterface();
		customerScreens = new ArrayList<CustomerInterface>();
		op = new OrderProcessor();
		
		fillMenu();
		
		for(int i = 1; i <= 5; i++)
			customerScreens.add(new CustomerInterface(i));
		
		simulateCustomer();
		
		//kitchenScreen.display();
	}
}
