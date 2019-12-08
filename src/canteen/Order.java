package canteen;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> order;
	private int orderID;
	
	public Order(ArrayList<Item> o, int i) {
		this.order = o;
		this.orderID = i;
	}
	
	public void addToOrder(Item i) {
		order.add(i);
	}
	
	public void removeFromOrder(Item i) {
		order.remove(i);
	}
	
	public ArrayList<Item> getItems() {
		return order;
	} 

	public double getPrice() {
		double price = 0;
		for(Item i: order) {
			price += i.getPrice();
		}
		return price;
	}
	
	public int getID() {
		return orderID;
	}
}
