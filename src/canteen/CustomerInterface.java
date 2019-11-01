package canteen;

import java.io.*;

public class CustomerInterface implements UserInterface { 
	private Order customerOrder;
	
	public CustomerInterface(int i) {
		System.out.println("Test CustomerInterface " + i);
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
		
	}
}
