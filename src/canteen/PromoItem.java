package canteen;

public class PromoItem implements Item {
	
	private Item item;
	private Double discount;
	
	public PromoItem(Item i, double d) {
		this.item = i;
		this.discount = d;
	}
	
	public double getPrice() {
		return item.getPrice() * discount;
	}

	public int getID() {
		return item.getID();
	}

}
