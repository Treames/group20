package testCMS;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import canteen.Dish;
import canteen.Item;
import canteen.Menu;
import canteen.Order;


public class TestOrder {
	@Test
	public void Order_Test_add() {
		Order o1 = new Order(5);
		Dish d = new Dish("Chicken", 10.00, 1);
		o1.addToOrder(d);
		ArrayList<Item> a1 = o1.getItems();
		int size = a1.size();
		assertEquals(1,size);
	}
	
	@Test
	public void Order_Test_remove() {
		Order o1 = new Order(5);
		Dish d = new Dish("Chicken", 10.00, 1);
		Dish d2 = new Dish("Chicken feet", 10.00, 1);
		o1.addToOrder(d);
		o1.addToOrder(d2);
		o1.removeFromOrder(d);
		ArrayList<Item> a1 = o1.getItems();
		int size = a1.size();
		assertEquals(1,size);
	}
	
	@Test
	public void Order_Test_ID() {
		Order o1 = new Order(3);
		int id = o1.getID();
		assertEquals(3, id);
	}
	
	@Test
	public void Order_Test_getPrice() {
		Order o1 = new Order(5);
		Dish d = new Dish("Chicken", 10.00, 1);
		Dish d2 = new Dish("Chicken feet", 10.00, 1);
		o1.addToOrder(d);
		o1.addToOrder(d2);
		ArrayList<Item> a1 = o1.getItems();
		double price = o1.getPrice();
		assertEquals(20.00, price, 0.0001);
	}
}