package testCMS;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import canteen.Dish;
import canteen.Beverage;
import canteen.Item;
import canteen.Menu;
import canteen.Order;

public class TestOrder {
	
	@Test
	public void order_addItem1() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Order o = new Order(someList);
		Item d = new Dish("Beef", 10.00, 1);
		o.addToOrder(d);
		ArrayList<Item> items = o.getItems();
		int length = items.size();
		assertEquals(1, length);
	}
	
	@Test
	public void order_removeItem() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Order o = new Order(someList);
		Item d = new Dish("Beef", 10.00, 1);
		Item b = new Beverage("Cola", 10.00, 1);
		o.addToOrder(d);
		o.addToOrder(b);
		ArrayList<Item> items = o.getItems();
		int length = items.size();
		assertEquals(2, length);
		o.removeFromOrder(b);
		ArrayList<Item> items1 = o.getItems();
		int length1 = items1.size();
		assertEquals(1, length1);
	}
	
	@Test
	public void order_Price() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Order o = new Order(someList);
		Item d = new Dish("Beef", 10.00, 1);
		Item b = new Beverage("Cola", 10.00, 1);
		o.addToOrder(d);
		o.addToOrder(b);
		ArrayList<Item> items = o.getItems();
		int length = items.size();
		assertEquals(2, length);
		double price = o.getPrice();
		assertEquals(20.00, price, 0.0001);
	}
}