package canteen;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class CustomerInterface implements Runnable, UserInterface { 
	private KitchenInterface kitchen;
	private Order customerOrder;
	private int interfaceID;
	private int orderNumber;
	private int orderID;
	private ArrayList<Item> menuItems;
	
	public CustomerInterface(int i, KitchenInterface k) {
		this.kitchen = k;
		this.interfaceID = i;
		this.orderNumber = 0;
		this.orderID = 0;
		System.out.println("Created CustomerInterface " + interfaceID);
		newOrder();
	}
	
	public void run() {
		simulateCustomer();
	}
	
	public void update(Menu m) {
		menuItems = m.getItems();		
	}

	public void display() {
		
	}
	
	public void addToOrder(Item i){
		customerOrder.addToOrder(i);
	}
	
	public void removeFromOrder(Item i) {
		customerOrder.removeFromOrder(i);
	}

	public void sendOrder() {
		DecimalFormat df = new DecimalFormat("####0.00");
		double price = customerOrder.getPrice();
		System.out.println("ID: " + orderID + " Total price: $" + df.format(price));
		
		kitchen.receiveOrder(customerOrder);
		
		customerOrder = null;
		orderNumber++;
		newOrder();	
	}
	
	// Create a new order with ID based on interfaceID
	// e.g 5th order (starting from 0) of interface 3 gets ID 3004
	private void newOrder() {
		if(orderNumber > 999)
			orderNumber = 0;
		
		int num_digits = String.valueOf(orderNumber).length();
		String orderID_string = "0".repeat(4 - num_digits - 1) + String.valueOf(orderNumber);
		orderID = Integer.valueOf(String.valueOf(interfaceID) + orderID_string);
		
		ArrayList<Item> itemsInOrder = new ArrayList<Item>();
		customerOrder = new Order(itemsInOrder, orderID);
	}
	
	public void simulateCustomer() {
		Random random = new Random();
		//ArrayList<Item> menuItems = menuItems.getItems();
		//printMenu(menuItems);
		
		for(int i = 0; i < 10; i++) { // 10 Fake orders
			//int rScreen = random.nextInt(customerScreens.size());
			int nItems = random.nextInt(5) + 1; // Minimum 1 item
			for(int j = 0; j < nItems; j++) { // Amount of items to order
				int rItem = random.nextInt(menuItems.size()); // Random item selected
				addToOrder(menuItems.get(rItem));
			}
			sendOrder();
		}
	}
	
}

