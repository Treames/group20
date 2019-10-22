package canteen;

import java.util.ArrayList;

public class ComboItem implements Item{
	
	private ArrayList<Item> items;
	private Double discount;
	private int id;
	
	public ComboItem(ArrayList<Item> l, double d, int i) {
		this.items = l;
		this.discount = d;
		this.id = i;
	}
	
	public double getPrice() {
		double price = 0;
		for(Item i: items) {
			price += i.getPrice();
		}
		return price * discount;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

}
