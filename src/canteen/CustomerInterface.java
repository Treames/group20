package canteen;

import java.io.*;

public class CustomerInterface implements UserInterface { 
	private Order customerOrder;
	private int interfaceID;
	private int orderNumber;
	
	public CustomerInterface(int i) {
		interfaceID = i;
		orderNumber = 0;
		System.out.println("Test CustomerInterface " + interfaceID);
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
		int orderID = Integer.valueOf(String.valueOf(interfaceID) + orderID_string);
		customerOrder = new Order(orderID);
		System.out.println(orderID);
	}
}
