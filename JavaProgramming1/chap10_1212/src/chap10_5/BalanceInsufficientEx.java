package chap10_5;

public class BalanceInsufficientEx extends Exception {
	public BalanceInsufficientEx() {}
	public BalanceInsufficientEx(String message) {
		super(message);
	}
}
