package canteen;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> order;
	private int orderID;
	
	/**
	 * @param o List of items in order
	 * @param i ID of order
	 */
	public Order(ArrayList<Item> o, int i) {
		this.order = o;
		this.orderID = i;
	}
	
	/**
	 * @param i Item to add to order
	 */
	public void addToOrder(Item i) {
		order.add(i);
	}
	
	/**
	 * @param i Item to remove from order
	 */
	public void removeFromOrder(Item i) {
		order.remove(i);
	}
	
	
	/**
	 * @return order
	 */
	public ArrayList<Item> getItems() {
		return order;
	} 

	/**
	 * @return double Combined price of order
	 */
	public double getPrice() {
		double price = 0;
		for(Item i: order) {
			price += i.getPrice();
		}
		return price;
	}
	
	/**
	 * @return int ID of order
	 */
	public int getID() {
		return orderID;
	}
}
