
package canteen;
/**
 * 
 */

/**
 * @author Travi
 *
 */
public class User {
	private String name;
	private int id;
	private double balance;

	public User(String s, int i, double d) {
		this.name = s;
		this.id = i;
		this.balance = d;
	}

	public void addToBalance(double d) {
		if(d > 0)
			balance += d;
		// Else Exception?
	}

	public void removeFromBalance(double d) {
		if(balance - d > 0)
			balance -= d;
		// Else exception?
	}

	private int getID() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}
}
