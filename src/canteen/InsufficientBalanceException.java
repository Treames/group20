package canteen;

public class InsufficientBalanceException extends Exception {
	/**
	 * @param errorMessage Message for error to display
	 */
	public InsufficientBalanceException(String errorMessage) {
		super(errorMessage);
	}
}
