package canteen;

import java.io.*;
import java.util.ArrayList;

public class CustomerInterface implements UserInterface { 
	private Order customerOrder;
	private int interfaceID;
	private int orderNumber;
	private int orderID;
	
	public CustomerInterface(int i) {
		this.interfaceID = i;
		this.orderNumber = 0;
		this.orderID = 0;
		System.out.println("Created CustomerInterface " + interfaceID);
		newOrder();
	}
	
	public void update(OrderProcessor op) {
		// TODO Auto-generated method stub
		
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
		// TODO Send order
		double price = customerOrder.getPrice();
		System.out.println("ID: " + orderID + " Total price: $" + price);
		
		customerOrder = null;
		orderNumber++;
		newOrder();	
	}
	
	private void newOrder() {
		String orderID_string;
		if(orderNumber < 10)
			orderID_string = "0" + String.valueOf(orderNumber);
		else
			orderID_string = String.valueOf(orderNumber);
		orderID = Integer.valueOf(String.valueOf(interfaceID) + orderID_string);
		
		ArrayList<Item> itemsInOrder = new ArrayList<Item>();
		customerOrder = new Order(itemsInOrder);
	}
}
