package testCMS;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import canteen.Beverage;
import canteen.ComboItem;
import canteen.Dish;
import canteen.Item;
import canteen.Menu;

public class TestComboItem {
	
	@Test
	public void combo_getPrice1() {
		Dish d1 = new Dish("Durum", 70.00, 1);
		Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
		
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d1);
		m.addItem(b1);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem(itemList, 0.8,3);
		double price = combo.getPrice();
		assertEquals(80.00, price, 0.001);
	}
	
	@Test
	public void combo_getID1() {
		Dish d1 = new Dish("Durum", 70.00, 1);
		Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
		
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d1);
		m.addItem(b1);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem(itemList, 0.8, 3);
		int id = combo.getID();
		assertEquals(3, id, 0.001);
	}
}
