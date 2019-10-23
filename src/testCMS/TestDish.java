package testCMS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import canteen.Dish;

public class TestDish {
	
	@Test
	public void dish_getPrice1() {
		Dish d1 = new Dish("Noodles", 19.95, 1);
		double price = d1.getPrice();
		assertEquals(19.95, price, 0);
	}
	
	@Test
	public void dish_getPrice2() {
		Dish d1 = new Dish("Noodles", 0, 1);
		double price = d1.getPrice();
		assertEquals(0, price, 0);
	}
	
	@Test
	public void dish_getPrice3() {
		Dish d1 = new Dish("Noodles", -0.01, 1);
		double price = d1.getPrice();
		assertEquals(-1.0, price, 0);
	}
	
	@Test
	public void dish_getPrice4() {
		Dish d1 = new Dish("Noodles", -10.0, 1);
		double price = d1.getPrice();
		assertEquals(-1.0, price, 0);
	}
	
	@Test
	public void dish_getID1() {
		Dish d = new Dish("Fish", 1.00, 2);
		int id = d.getID();
		assertEquals(2, id);
	}
}
