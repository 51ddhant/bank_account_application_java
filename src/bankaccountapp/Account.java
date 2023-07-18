package bankaccountapp;

public abstract class Account implements IBaseRate{
	
	// List Common properties for savings and checking accounts
	private String name;
	private String sSN; // Social Security Number
	private double balance;
	
	protected String accountNumber;
	protected double rate;
	
	private static int index = 10000; 
	
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		// Set account number
		this.accountNumber = setAccountNumber();
		index++;
		setRate();
	}
	
	private String setAccountNumber() {
		String lastTwoSSN = sSN.substring(sSN.length()-2);
		int uniqueID = index;
		int randomNumber = (int)(Math.random()*Math.pow(10, 3));
 		return lastTwoSSN + uniqueID + randomNumber;
	}
	
	// List common methods
	
	public void compund() {
		double accruedInterest = balance * (rate/100);
		System.out.println("Accrued Interest: $" + accruedInterest);
		deposit(accruedInterest);
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrwing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your Balance is now: $"+balance);
	}
	
	public abstract void setRate();
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: $" + balance + 
				"\nRATE: " + rate + "%"
				);
		
		
	}

}
