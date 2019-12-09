package canteen;

public class Beverage implements Item {
	private String name;
	private double price;
	private int id;
	
	/**
	 * @param s Name of beverage
	 * @param d Price of beverage
	 * @param i item ID
	 */
	public Beverage(String s, double d, int i) {
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
	 * @return double price of object
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return int item ID
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * @return String name of beverage
	 */
	public String getName() {
		return this.name;
	}
}
