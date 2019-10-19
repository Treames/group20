import java.util.ArrayList;

public class ComboItem implements Item{
	private ArrayList<Item> items;
	
	public double getPrice() {
		double price = 0;
		for(Item i: items) {
			price += i.getPrice();
		}
		return price;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
