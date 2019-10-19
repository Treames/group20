
public class CustomerInterface implements UserInterface {
	private Order customerOrder;
	public void update(OrderProcessor op) {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
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
