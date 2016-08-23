package chapter6;

/**
 * Created by michael.song on 8/23/2016 for bigJava
 */
public class Investment {
	private double balance;
	private double rate;
	private int years;

	/**
	 * Construct an investment object  from a starting balance and interest rate
	 *
	 * @param aBalance the starting balance
	 * @param aRate    the interest rate in percent
	 */
	public Investment(double aBalance, double aRate) {
		balance = aBalance;
		rate = aRate;
		years = 0;
	}
}
