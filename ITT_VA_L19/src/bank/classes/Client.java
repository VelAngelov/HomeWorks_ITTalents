package bank.classes;

import java.util.ArrayList;

public class Client extends LegalEntity {
	private double income;
	private ArrayList<Deposit> deposits;
	private ArrayList<Credit> credits;

	public Client(String name, String adress, double cash, double income) {
		super(name, adress, cash);
		this.deposits = new ArrayList<Deposit>();
		this.credits = new ArrayList<Credit>();
		this.income = income > 0 ? income : 0;
	}
	// public methods:

	public double getIncome() {
		return income;
	}

	public double getTotalIncome() {
		if (!credits.isEmpty()) {
			double inc = this.income;
			for (Credit c : credits) {
				inc -= c.getMonthCashTransfer();
			}
			return inc;
		}
		return income;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name:%s\nAdress:%s\nMoney:%.2flv\nIncome:%.2flv\n", super.name, super.adress, super.cash,this.income));
		if (!this.credits.isEmpty()) {
			sb.append("Credits:\n");
			for (Credit c : credits) {
				sb.append(c.toString());
			}
		}
		if (!this.deposits.isEmpty()) {
			sb.append("Deposits:\n");
			for (Deposit d : deposits) {
				sb.append(d.toString());
			}
		}
		return sb.toString();
	}

	// default methods:
	boolean createCredit(Credit credit) {
		this.cash += credit.getAmount();
		this.credits.add(credit);
		return false;
	}

	boolean createDeposit(Deposit deposit) {
		this.cash -= deposit.getAmount();
		this.deposits.add(deposit);
		return false;
	}
}
