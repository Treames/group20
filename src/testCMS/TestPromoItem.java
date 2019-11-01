package testCMS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import canteen.Dish;
import canteen.PromoItem;

public class TestPromoItem {
	
	//TODO: Test exceptions: discount < 0.00 & discount > 1.00
	
	@Test
	public void promo_getPrice1() {
		Dish d = new Dish("Pizza", 50.00, 1);
		PromoItem i = new PromoItem(d, 0.8);
		double promoPrice = i.getPrice();
		assertEquals(40.00, promoPrice, 0.001);
	}
	
	@Test
	public void promo_getID1() {
		Dish d = new Dish("Pizza", 50.00, 1);
		PromoItem i = new PromoItem(d, 0.8);
		int promoID = i.getID();
		assertEquals(1, promoID);
	}
	
	@Test
	public void promo_item1() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			Dish d = new Dish("Pizza", 50.00, 1);
			new PromoItem(d, -2);
		});
		assertEquals("Discount out of bounds",ex.getMessage());
	}
	
	@Test
	public void promo_item2() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {
			Dish d = new Dish("Pizza", 50.00, 1);
			new PromoItem(d, 2);
		});
		assertEquals("Discount out of bounds",ex.getMessage());
	}
}
