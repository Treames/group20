
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

	//TODO: concurrency?
	public User(String s, int i, double d) throws IllegalArgumentException {
		this.name = s;
		this.id = i;
		if(d < 0)
			throw new IllegalArgumentException("Negative balance");
		else
			this.balance = d;
	}

	public void addToBalance(double d) throws IllegalArgumentException {
		if(d > 0)
			balance += d;
		else 
			throw new IllegalArgumentException("Negative or zero add");
	}

	public void removeFromBalance(double d) throws InsufficientBalanceException {
		if(balance - d > 0)
			balance -= d;
		else
			throw new InsufficientBalanceException("Insufficient balance");
	}

	public int getID() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double d) throws IllegalArgumentException {
		if(d < 0)
			throw new IllegalArgumentException("Negative balance");
		else
			this.balance = d;
	}
}
