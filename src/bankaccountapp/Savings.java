package bankaccountapp;

public class Savings extends Account{

	// List properties specific to the savings account
	private static int boxNumber = 100;
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize savings account properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	// List any methods specific to the savings account 
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = boxNumber;
		boxNumber++;
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println(
				"Your Saving Account Features: " + 
		"\n\t Safety Deposit Box ID: " + safetyDepositBoxID + 
		"\n\t Safety Deposit Box Key: " + safetyDepositBoxKey
		
				);
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
}
