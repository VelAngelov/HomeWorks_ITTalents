package bank.classes;

public class Deposit extends BankProduct {

	Deposit(Bank bank, double interestRate, Client client, double amount, int periodInMonths) {
		super("Deposit", bank, interestRate, client, amount, periodInMonths);
	}
	// public Methods

	public void monthlyBill() {
		if (periodInMonths > 0) {
			super.amount += getMonthCashTransfer();
			super.periodInMonths--;
		}
	}

}
