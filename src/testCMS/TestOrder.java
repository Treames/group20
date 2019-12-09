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
		
		ArrayList<Item> someList = new ArrayList<Item>();
		Dish d = new Dish("Chicken", 10.00, 1);
		Order o1 = new Order(someList, 0);
		o1.addToOrder(d);
		
		ArrayList<Item> a1 = o1.getItems();
		int size = a1.size();
		assertEquals(1,size);
	}
	
	@Test
	public void Order_Test_remove() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Dish d = new Dish("Chicken", 10.00, 1);
		Dish d2 = new Dish("Chicken feet", 10.00, 1);
		Order o1 = new Order(someList, 0);
		o1.addToOrder(d);
		o1.addToOrder(d2);
		o1.removeFromOrder(d);
		ArrayList<Item> a1 = o1.getItems();
		int size = a1.size();
		assertEquals(1,size);
	}
	
	@Test
	public void Order_Test_getPrice() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Order o1 = new Order(someList, 0);
		Dish d = new Dish("Chicken", 10.00, 1);
		Dish d2 = new Dish("Chicken feet", 10.00, 1);
		o1.addToOrder(d);
		o1.addToOrder(d2);
		double price = o1.getPrice();
		assertEquals(20.00, price, 0.0001);
	}
	
	@Test
	public void Order_Test_getID() {
		ArrayList<Item> someList = new ArrayList<Item>();
		Order o1 = new Order(someList, 5);
		Dish d = new Dish("Chicken", 10.00, 1);
		Dish d2 = new Dish("Chicken feet", 10.00, 1);
		o1.addToOrder(d);
		o1.addToOrder(d2);
		int id = o1.getID();
		assertEquals(5, id);
	}
}