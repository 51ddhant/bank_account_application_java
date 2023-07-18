package bankaccountapp;

public class Checking extends Account{
	
	// List properties specific to the checking account
	private static long uniqueNumber = 999999999;
	private String debitCardNumber;
	private String debitCardPin;
	
	// Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2"+accountNumber;
		setDebitCard();
	}
	
	// List any methods specific to the checking account 
	
	private void setDebitCard() {
		debitCardNumber = String.valueOf((int)(Math.random()*Math.pow(10, 3))) + uniqueNumber;	
		uniqueNumber--;
		debitCardPin = String.valueOf((int)(Math.random() * Math.pow(10, 4)));
	}

	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println(
				"Your Checking Account Features: " + 
		"\n\t Debit Card Number: " + debitCardNumber + 
		"\n\t Debit Card Pin: " + debitCardPin
		
				);
		
	}

	@Override
	public void setRate() {
		rate = getBaseRate()*0.15;
		
	}
	
	
}
