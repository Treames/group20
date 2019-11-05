package canteen;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> items;
	private int id;
	
	public Order(int _id) {
		id = _id;
		items = new ArrayList<Item>();
	}
	
	public void addToOrder(Item i) {
		items.add(i);
	}
	
	public void removeFromOrder(Item i) {
		items.remove(i);
	}
	
	public ArrayList<Item> getItems() {
		ArrayList<Item> allItems = new ArrayList<Item>();
		for(Item i: items) {
			allItems.add(i);
		}
		return allItems;
	}
	
	public int getID() {
		return this.id;
	}

	public double getPrice() {
		double price = 0;
		for(Item i: items) {
			price += i.getPrice();
		}
		return price;
	}
}
