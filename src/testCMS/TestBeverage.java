package testCMS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import canteen.Beverage;

public class TestBeverage {
	
	@Test
	public void bev_getPrice1() {
		Beverage b = new Beverage("Carlsberg ofc", 49.95, 1);
		double price = b.getPrice();
		assertEquals(49.95, price, 0);
	}	
	
	@Test
	public void bev_getPrice2() {
		Beverage b = new Beverage("Carlsberg ofc", 0, 1);
		double price = b.getPrice();
		assertEquals(0, price, 0);
	}	
	
	@Test
	public void bev_getPrice3() {
		Beverage b = new Beverage("Carlsberg ofc", -0.01, 1);
		double price = b.getPrice();
		assertEquals(-1.0, price, 0);
	}	
	
	@Test
	public void bev_getPrice4() {
		Beverage b = new Beverage("Carlsberg ofc", -10.0, 1);
		double price = b.getPrice();
		assertEquals(-1.0, price, 0);
	}	
	
	@Test
	public void bev_getID1() {
		Beverage b = new Beverage("Tuborg, danish again", 50.00, 2);
		int id = b.getID();
		assertEquals(2, id);
	}
}
