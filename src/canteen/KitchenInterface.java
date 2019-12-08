package canteen;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class KitchenInterface implements Runnable, UserInterface {
	private ArrayList<Order> currentOrders;
	private ArrayList<Item> menuItems;
	
	static Semaphore semaphore = new Semaphore(1, true);
	
	KitchenInterface() {
		currentOrders = new ArrayList<Order>();
		menuItems = new ArrayList<Item>();
	}
	
	public void run() {
		System.out.println("MyRunnable running");
		display();
	}
	
	public void update(Menu m) {
		menuItems = m.getItems();		
	}

	public void display() {
		System.out.println("Current active orders are:\n{");
		for(Order o: currentOrders) {
			System.out.print(o.getID() + ": { ");
			ArrayList<Item> items = o.getItems();
			for(Item i: items) {
				System.out.print(i.getName() + ", ");
			}
			System.out.println("}");
		}
		System.out.println("}");
		
	}
	
	public void receiveOrder(Order o) {
		try {
			semaphore.acquire();
			try {
				currentOrders.add(o);
				display();				
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Removes the completed order from the kitchens TODO screen
	public void completeOrder(Order o) {
		currentOrders.remove(o);
		display();
	}
}