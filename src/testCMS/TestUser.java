package testCMS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import canteen.InsufficientBalanceException;
import canteen.User;

public class TestUser {
	
	@Test
	public void user_getbalance1() {
		User u1 = new User("George", 50.0, 1111);
		double balance = u1.getBalance();
		assertEquals(50,balance,0.001);
	}
	
	@Test
	public void user_negative_constructor() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			new User("George", -50.00, 1115);
		});
		assertEquals("Negative balance", ex.getMessage());
	}
	
	@Test
	public void user_zero_constructor() {
		User u = new User("George", 0.00, 1115);
		double balance = u.getBalance();
		assertEquals(0, balance, 0);
	}
	
	@Test
	public void user_set_balance() {
		User u2 = new User("Margie" ,10.0, 1112);
		u2.setBalance(20);
		double balance2 = u2.getBalance();
		assertEquals(20,balance2,0.0001);
	}
	
	@Test
	public void user_set_balance2() {
		User u = new User("Morty", 3.00, 1115);
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			u.setBalance(-100.0);
		});
		assertEquals("Negative balance", ex.getMessage());
		double balance = u.getBalance();
		assertEquals(3.00,balance,0);
	}
	
	@Test
	public void user_add_to_balance() {
		User u = new User("Rick", 50.0, 1113);
		try {
			u.addToBalance(20.0);
		} catch (Exception e) {
			
		}
		double balance = u.getBalance();
		assertEquals(70,balance,0);
	}
	
	@Test
	public void user_add_to_balance1() {
		User u = new User("Rick", 50.0, 1113);
		try {
			u.addToBalance(0.0);
		} catch (Exception e) {
			assertEquals("Negative or zero add", e.getMessage());
		}
		double balance = u.getBalance();
		assertEquals(50,balance,0);
	}
	
	@Test
	public void user_add_to_balance2() {
		User u = new User("Rick", 50.0, 1113);
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			u.addToBalance(-10.0);
		});
		assertEquals("Negative or zero add", ex.getMessage());
		double balance = u.getBalance();
		assertEquals(50, balance, 0);
	}
	
	@Test
	public void user_remove_from_balance() {
		User u = new User("Morty", 20.00, 1114);
		try {
			u.removeFromBalance(3.50);
		}catch (Exception e) {
			
		}
		double balance = u.getBalance();
		assertEquals(16.50,balance,0.0001);
	}
	
	@Test
	public void user_remove_from_balance2() {
		User u = new User("Morty", 3.00, 1115);
		Throwable ex = assertThrows(InsufficientBalanceException.class, () -> {
			u.removeFromBalance(3.50);
		});
		double balance = u.getBalance();
		assertEquals(3.00, balance, 0);
	}
	
	@Test
	public void user_getId() {
		User u = new User("a", 5.00, 1200);
		int id = u.getID();
		assertEquals(1200, id);
	}
}
