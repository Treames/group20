package testCMS;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.ArrayList;

import canteen.*;


public class testTest {
	
	@Test
	public void dish_getPrice1(){
		Dish d1 = new Dish("Noodles", 19.95,1);
		double price = d1.getPrice();
		assertEquals(19.95,price,0.001);
	}
	
	@Test
	public void dish_getID1() {
		Dish d = new Dish("Fish", 1.00,2);
		int id = d.getID();
		assertEquals(2,id);
	}
	
	@Test
	public void bev_getPrice1() {
		Beverage b = new Beverage("Carlsberg ofc",49.95,1);
		double price = b.getPrice();
		assertEquals(49.95,price,0);
	}	
	
	@Test
	public void bev_getID1() {
		Beverage b = new Beverage("Tuborg, danish again",50.00,2);
		int id = b.getID();
		assertEquals(2,id);
	}
	
	@Test
	public void promo_getPrice1() {
		Dish d = new Dish("Pizza",50.00,1);
		PromoItem i = new PromoItem(d,0.8);
		double promoPrice = i.getPrice();
		assertEquals(40.00,promoPrice,0.001);
	}
	
	@Test
	public void promo_getID1() {
		Dish d = new Dish("Pizza",50.00,1);
		PromoItem i = new PromoItem(d,0.8);
		int promoID = i.getID();
		assertEquals(1,promoID);
	}
	
	@Test
	public void combo_getPrice1() {
		
		Dish d1 = new Dish("Durum",70.00,1);
		Beverage b1 = new Beverage("Ginger Ale",30.00,2);
		
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d1);
		m.addItem(b1);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem(itemList,0.8,3);
		double price = combo.getPrice();
		assertEquals(80.00,price,0.001);
	}
	
	@Test
	public void combo_getID1() {
		
		Dish d1 = new Dish("Durum",70.00,1);
		Beverage b1 = new Beverage("Ginger Ale",30.00,2);
		
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d1);
		m.addItem(b1);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(d1);
		itemList.add(b1);		
		ComboItem combo = new ComboItem(itemList,0.8,3);
		int id = combo.getID();
		assertEquals(3,id,0.001);
	}

	@Test
	public void menu_add1() {
		Dish d = new Dish("Chicken",10.00,1);
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d);
		Item[] items = m.getItems();
		int length = items.length;
		assertEquals(1,length);
	}

	@Test
	public void menu_remove1() {
		Dish d = new Dish("Chicken",10.00,1);
		Dish d1 = new Dish("Human",10.00,1);
		Dish d2 = new Dish("Human leg",10.00,1);
		ArrayList<Item> someList = new ArrayList<Item>();
		Menu m = new Menu(someList);
		m.addItem(d);
		m.addItem(d1);
		m.addItem(d2);
		m.removeItem(d1);
		Item[] items = m.getItems();
		int length = items.length;
		assertEquals(2,length);
	}	
	
}
 