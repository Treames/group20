package testCMS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import canteen.Dish;
import canteen.PromoItem;

public class TestPromoItem {
	
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
}
