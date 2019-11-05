package canteen;

public class PromoItem implements Item {
	
	private Item item;
	private Double discount;
	
	public PromoItem(Item i, double d) {
		this.item = i;
		if(d > 0 && d < 1.00)
			this.discount = d;
		else
			throw new IllegalArgumentException("Discount out of bounds");
	}
	
	public double getPrice() {
		return item.getPrice() * discount;
	}

	public int getID() {
		return item.getID();
	}

	public String getName() {
		return this.item.getName();
	}
	
}
