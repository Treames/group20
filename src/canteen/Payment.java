package canteen;

public class Payment {
	private Order order;
	private User user;
	
	public void makePayemt() {
		user.setBalance(user.getBalance() - order.getPrice());
	}
}
