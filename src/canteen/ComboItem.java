package canteen;

import java.util.ArrayList;

public class ComboItem implements Item {
	
	private String name;
	private ArrayList<Item> items;
	private Double discount;
	private int id;
	
	public ComboItem(String n, ArrayList<Item> l, double d, int i) throws IllegalArgumentException {
		if(n.length() < 1) 
			throw new IllegalArgumentException("Empty name");
		else
			name = n;
		
		if(l.isEmpty())
			throw new IllegalArgumentException("Empty item list");
		else
			this.items = l;
		
		if(d > 0 && d < 1.00)
			this.discount = d;
		else
			throw new IllegalArgumentException("Discount out of bounds");
		
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
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

}
