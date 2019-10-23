package testCMS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import canteen.User;

public class TestUser {
	
	@Test
	public void user_getbalance1() {
		User u1 = new User("George",1111,50.0);
		double balance = u1.getBalance();
		assertEquals(50,balance,0.001);
	}
	
	@Test
	public void user_set_balance() {
		User u2 = new User("Margie",1112,10.0);
		//double balance = u1.setBalance(20);
		u2.setBalance(20);
		double balance2 = u2.getBalance();
		assertEquals(20,balance2,0.0001);
	}
	
	@Test
	public void user_add_to_balance() {
		User u3 = new User("Rick",1113,50.0);
		//double balance = u1.setBalance(20);
		u3.addToBalance(20);
		double balance = u3.getBalance();
		assertEquals(70,balance,0.0001);
	}
	
	@Test
	public void user_add_to_balance2() {
		User u = new User("Rick",1113, 50.0);
		u.addToBalance(-10.0);
		double balance = u.getBalance();
		assertEquals(50, balance, 0);
	}
	
	@Test
	public void user_remove_from_balance() {
		User u4 = new User("Morty",1114,20.34);
		//double balance = u1.setBalance(20);
		u4.removeFromBalance(3);
		double balance = u4.getBalance();
		assertEquals(17.34,balance,0.0001);
	}
	
	@Test
	public void user_remove_from_balance2() {
		User u = new User("Morty", 1115, 3.00);
		u.removeFromBalance(3.50);
		double balance = u.getBalance();
		assertEquals(3.00, balance, 0);
		
	}
}
