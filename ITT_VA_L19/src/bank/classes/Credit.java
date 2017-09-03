package bank.classes;

public class Credit extends BankProduct {
	private double monthPayment;

	Credit(Bank bank, double interestRate, Client client, double amount, int periodInMonths) {
		super("Credit", bank, interestRate, client, amount, periodInMonths);
		calculateMonthPayment();
	}

	private void calculateMonthPayment() {
		this.monthPayment = super.amount * Math.pow(1 + super.interestRate, super.periodInMonths) / periodInMonths;
	}

	public void monthlyBill() {
		if (periodInMonths > 0) {
			super.amount -= getMonthCashTransfer();
			super.periodInMonths--;
		}
	}

	@Override
	public double getMonthCashTransfer() {
		return this.monthPayment;
	}

}
