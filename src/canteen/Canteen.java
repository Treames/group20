package canteen;

import java.util.ArrayList;

import canteen.*;

public class Canteen {
	// One interface for kitchen (Make log file > read from other process)
	private KitchenInterface kitchenScreen;
	// One interface for customerScreen showing available items (Console window) (rest simulated)
	private ArrayList<CustomerInterface> customerScreens;
	private OrderProcessor op;
	
	public void runInterfaces() {
		kitchenScreen = new KitchenInterface();
		kitchenScreen.display();
		
		ArrayList<CustomerInterface> customerScreens = new ArrayList<CustomerInterface>();
		for(int i = 1; i <= 5; i++)
			customerScreens.add(new CustomerInterface(i));
	}
}
