package testCMS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import canteen.Beverage;
import canteen.ComboItem;
import canteen.Dish;
import canteen.Item;
import canteen.Menu;

public class TestComboItem {
	
	//TODO: Test exceptions: empty combo list, discount < 0.00 & discount > 1.00
	@Test
	public void combo_getPrice1() {
		Dish d1 = new Dish("Durum", 70.00, 1);
		Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem("combo",itemList, 0.8,3);
		double price = combo.getPrice();
		assertEquals(80.00, price, 0.001);
	}
	
	@Test
	public void combo_getID1() {
		Dish d1 = new Dish("Durum", 70.00, 1);
		Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);

		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem("coombo",itemList, 0.8, 3);
		int id = combo.getID();
		assertEquals(3, id, 0.001);
	}
	@Test
	public void combo_item_1() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			ArrayList<Item> itemList = new ArrayList<Item>();
			ComboItem combo = new ComboItem("combo",itemList, 0.8,3);
			
		});
		assertEquals("Empty item list",ex.getMessage());
	}
	@Test
	public void combo_item_2() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			Dish d1 = new Dish("Durum", 70.00, 1);
			Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
			ArrayList<Item> itemList = new ArrayList<Item>();
			itemList.add(d1);
			itemList.add(b1);		
			new ComboItem("combo1",itemList, -3,3);
			
		});
		assertEquals("Discount out of bounds",ex.getMessage());
	}
	@Test
	public void combo_item_3() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			Dish d1 = new Dish("Durum", 70.00, 1);
			Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);

			ArrayList<Item> itemList = new ArrayList<Item>();
			itemList.add(d1);
			itemList.add(b1);		
			new ComboItem("combo",itemList, 120,3);
			
		});
		assertEquals("Discount out of bounds",ex.getMessage());
	}
	@Test
	public void combo_item_4() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			Dish d1 = new Dish("Durum", 70.00, 1);
			Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
			
			ArrayList<Item> itemList = new ArrayList<Item>();
			itemList.add(d1);
			itemList.add(b1);		
			new ComboItem("",itemList, 120,3);
			
		});
		assertEquals("Empty name",ex.getMessage());
	}
	@Test
	public void combo_getName() {
		Dish d1 = new Dish("Durum", 70.00, 1);
		Beverage b1 = new Beverage("Ginger Ale", 30.00, 2);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem("combo",itemList, 0.8, 3);
		String name = combo.getName();
		assertEquals("combo", name);
	}
}
