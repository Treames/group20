package canteen;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import java.util.Random;


public class KitchenInterface implements Runnable, UserInterface {
	private ArrayList<Order> currentOrders;
	private ArrayList<Item> menuItems;
	private long openTime;
	private int completed = 0;
	private double sales = 0;
	
	static Semaphore semaphore = new Semaphore(1, true);
	
	/**
	 * @param t Time kitchen opened
	 */
	KitchenInterface(long t) {
		currentOrders = new ArrayList<Order>();
		menuItems = new ArrayList<Item>();
		openTime = t;
	}
	
	public void run() {
		System.out.println("MyRunnable running");
		display();
	}
	
	public void update(Menu m) {
		menuItems = m.getItems();		
	}

	public void display() {
		System.out.println("[K] Current active orders are:\n{");
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
	
	/**
	 * @param o Order received from customer interface
	 */
	public void receiveOrder(Order o) {
		try {
			semaphore.acquire();
			try {
				currentOrders.add(o);
				sales += o.getPrice();
				display();				
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param o Order to be completed and removed from waiting list
	 */
	public void completeOrder(Order o) {
		try {
			semaphore.acquire();
			try {
				currentOrders.remove(o);
				display();			
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		completed++;
	}
	
	public void simulateKitchen() {
		Random random = new Random();
		long currentTime = Instant.now().getEpochSecond();
		
		while(currentOrders.size() >= 0 && currentTime < openTime + 20) {
			if(currentOrders.size() > 0) {
				int processDelay = random.nextInt(25);
				try {
					Thread.sleep(processDelay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int toComplete = random.nextInt(3);
				
				toComplete = Integer.min(toComplete, currentOrders.size());
				
				for(int i = 0; i < toComplete; i++)
					completeOrder(currentOrders.get(0));
			}
			
			currentTime = Instant.now().getEpochSecond();
		}
		
		printClose();
	}
	
	private void printClose() {
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println("\n------------------------------");
		System.out.println("Order completed: " + completed);
		System.out.println("Sales: $" + df.format(sales));
	}
}