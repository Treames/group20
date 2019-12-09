package canteen;

import java.io.*;

public class Dish implements Item {
	private String name;
	private double price;
	private int id;
	
	/**
	 * @param s Name of dish
	 * @param d Price of dish
	 * @param i item ID
	 * @throws IllegalArgumentException Empty name or negative price
	 */
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

	/**
	 * @return double price of dish
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return ID of dish
	 */
	public int getID() {
		return this.id;
	}
	
	
	/**
	 * @return name of dish
	 */
	public String getName() {
		return this.name;
	}
}
