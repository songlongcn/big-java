package chapter3;

/**
 * Created by michael.song on 8/18/2016.
 */
public class BankAccount {
	private double amount;

	/**
	 *
	 * @param amount
	 */
	public void BankAccount(double amount){
		this.amount = amount;
	}
	public BankAccount(){
		this.amount = 100;
	}

	/**
	 * Gets the current balance of the bank account
	 * @return the current balance
	 */
	public double getAmount(){
		return this.amount;
	}
	public static void main(String args[]){
		BankAccount account = new BankAccount();
		System.out.println(account.getAmount());
		account.BankAccount(123.5);
		System.out.println(account.getAmount());
	}
}
