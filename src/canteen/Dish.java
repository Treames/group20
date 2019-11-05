package canteen;

import java.io.*;

public class Dish implements Item {
	private String name;
	private double price;
	private int id;
	
	public Dish(String s, double d, int i) throws IllegalArgumentException {
		if(s.length() < 1)
			throw new IllegalArgumentException("Empty name");
		else
			this.name = s;
		
		if(d < 0)
			throw new IllegalArgumentException("Negative price");
		else
			this.price = d;
		this.id = i;
	}

	public double getPrice() {
		return this.price;
	}

	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
