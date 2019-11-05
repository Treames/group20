package canteen;

import java.util.ArrayList;

public class KitchenInterface implements UserInterface {
	private ArrayList<Order> currentOrders;
	
	public void update(OrderProcessor op) {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		System.out.println("Current active orders are:");
//		for(Order o: currentOrders) {
//			System.out.println("Order ID: " + o.getID());
//			System.out.println("Order items: ");
//			ArrayList<Item> items = o.getItems();
//			for(Item i: items) {
//				System.out.print(i.getName() + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	//Removes the completed order from the kitchens TODO screen
	public void completeOrder(Order o) {
		
	}
}
