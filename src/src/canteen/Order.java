package canteen;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> items;
	
	public void addToOrder(Item i) {
		
	}
	
	public void removeFromOrder(Item i) {
		
	}
	
	public void getItems() {
		
	}

	public double getPrice() {
		double price = 0;
		for(Item i: items) {
			price += i.getPrice();
		}
		return price;
	}
}
