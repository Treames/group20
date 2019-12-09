package canteen;

public class PromoItem implements Item {
	
	private Item item;
	private Double discount;
	
	/**
	 * @param i Item to receive promotion
	 * @param d Discount of item
	 */
	public PromoItem(Item i, double d) {
		this.item = i;
		if(d > 0 && d < 1.00)
			this.discount = d;
		else
			throw new IllegalArgumentException("Discount out of bounds");
	}
	
	/**
	 * @return double Discounted price of item
	 */
	public double getPrice() {
		return item.getPrice() * discount;
	}

	/**
	 * @return int ID of promotion item
	 */
	public int getID() {
		return item.getID();
	}

	/**
	 * @return String name of promotion
	 */
	public String getName() {
		return this.item.getName();
	}
	
}
