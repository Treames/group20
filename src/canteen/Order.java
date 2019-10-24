package canteen;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> items;
	
	public void addToOrder(Item i) {
		items.add(i);
	}
	
	public void removeFromOrder(Item i) {
		items.remove(i);
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public double getPrice() {
		double price = 0;
		for(Item i: items) {
			price += i.getPrice();
		}
		return price;
	}
}
