
package canteen;

public class User {
	private String name;
	private int id;
	private double balance;

	/**
	 * @param s Name of user
	 * @param d Balance of user
	 * @param i ID of user
	 * @throws IllegalArgumentException Name or balance invalid
	 */
	public User(String s, double d, int i) throws IllegalArgumentException {
		if(s.length() < 1)
			throw new IllegalArgumentException("Empty name");
		else
			this.name = s;
		
		if(d < 0)
			throw new IllegalArgumentException("Negative balance");
		else
			this.balance = d;
		
		this.id = i;
	}

	/**
	 * @param d Amount to add to balance
	 * @throws IllegalArgumentException Negative or zero value
	 */
	public void addToBalance(double d) throws IllegalArgumentException {
		if(d > 0)
			balance += d;
		else 
			throw new IllegalArgumentException("Negative or zero add");
	}

	/**
	 * @param d Amount to remove from balance
	 * @throws InsufficientBalanceException Insufficient balance
	 */
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

	/**
	 * @param d Amount to set balance to
	 * @throws IllegalArgumentException Negative balance
	 */
	public void setBalance(double d) throws IllegalArgumentException {
		if(d < 0)
			throw new IllegalArgumentException("Negative balance");
		else
			this.balance = d;
	}
}
