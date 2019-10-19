
public class PromoItem implements Item {
	Item item;
	public double getPrice() {
		return item.getPrice() * 0.8;
	}

	public int getID() {
		return item.getID();
	}

}
