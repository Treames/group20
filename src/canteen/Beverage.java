package canteen;

public class Beverage implements Item {
	private String name;
	private double price;
	private int id;
	
	public Beverage(String s, double d, int i) {
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
}
