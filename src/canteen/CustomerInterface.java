package canteen;

import java.io.*;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class CustomerInterface implements Runnable, UserInterface { 
	private KitchenInterface kitchen;
	private Order customerOrder;
	private int interfaceID;
	private int orderNumber;
	private int orderID;
	private ArrayList<Item> menuItems;
	private long openTime;
	
	/**
	 * @param i ID of interface
	 * @param k Kitchen linked to customer interface
	 * @param t Time kitchen opened
	 */
	public CustomerInterface(int i, KitchenInterface k, long t) {
		this.kitchen = k;
		this.interfaceID = i;
		this.orderNumber = 0;
		this.orderID = 0;
		this.openTime = t;
		System.out.println("Created CustomerInterface " + interfaceID);
		newOrder();
	}
	
	public void run() {
		simulateCustomer();
	}
	
	/**
	 * @param m Menu to update for printing
	 */
	public void update(Menu m) {
		menuItems = m.getItems();		
	}

	public void display() {
		
	}
	
	/**
	 * @param i Item to add to order
	 */
	public void addToOrder(Item i){
		customerOrder.addToOrder(i);
	}
	
	/**
	 * @param i Item to remove from order
	 */
	public void removeFromOrder(Item i) {
		customerOrder.removeFromOrder(i);
	}

	private void sendOrder() {
		DecimalFormat df = new DecimalFormat("####0.00");
		double price = customerOrder.getPrice();
		System.out.println("[C] ID: " + orderID + " Total price: $" + df.format(price));
		
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
		
		int nOrders = random.nextInt(100);
		int orderTime = random.nextInt(100) + 10;
		try {
			for(int i = 0; i < nOrders; i++) {
				Thread.sleep(orderTime);
				
				long currentTime = Instant.now().getEpochSecond();
				if(currentTime > openTime + 10) break;
				
				int nItems = random.nextInt(5) + 1; // Minimum 1 item
				for(int j = 0; j < nItems; j++) { // Amount of items to order
					int rItem = random.nextInt(menuItems.size()); // Random item selected
					addToOrder(menuItems.get(rItem));
				}
				sendOrder();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

