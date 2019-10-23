package canteen;

import java.io.*;

public class Dish implements Item {
	private String name;
	private double price;
	private int id;
	
	public Dish(String s, double d, int i) throws IllegalArgumentException {
		this.name = s;
		if(d < 0)
			throw new IllegalArgumentException("Negative price");
		else
			this.price = d;
		this.id = i;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
