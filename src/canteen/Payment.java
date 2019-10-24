package canteen;

import java.io.*;

public class Payment {
	private Order order;
	private User user;
	
	public void makePayemt() {
		try {
			user.removeFromBalance(order.getPrice());
		} catch (Exception e) {
			//TODO: Handle exception makePayment
			System.out.println(e.getMessage());
		}
	}
}
