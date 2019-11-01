package canteen;

import java.util.ArrayList;

public class KitchenInterface implements UserInterface{
	private ArrayList<Order> currentOrders;
	
	public void update(OrderProcessor op) {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		System.out.println("Test KitchenInterface");
		
	}
	
	//Removes the completed order from the kitchens TODO screen
	public void completeOrder(Order o) {
		
	}
}
