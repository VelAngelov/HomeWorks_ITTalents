package bank.classes;

import java.util.ArrayList;

public class Bank extends LegalEntity {
	private ArrayList<BankProduct> products;
	private double reserve;

	public Bank(String name, String adress, double cash) {
		super(name, adress, cash);
		this.products = new ArrayList<BankProduct>();
	}

	// Private Methods:

	private boolean clientCanMakeDeposit(Client client, double amount) {
		return client != null && client.getCash() >= amount && amount > 0;
	}

	private void createDeposit(Deposit deposit) {
		this.products.add(deposit);
		this.cash += deposit.getAmount();
		this.reserve += 0.9 * deposit.getAmount();
	}

	private double calculateAbilityOfBankForCredit() {
		if (products.isEmpty()) {
			return super.cash;
		}
		double money = super.cash;
		for (BankProduct p : products) {
			if (p.getType().equals("Deposit")) {
				money -= p.getAmount() * 0.1;
			}
		}
		return money;
	}

	private Credit clientCredit(Client client, double interestRate, double amount, int period) {
		if (client == null || amount < 0) {
			return null;
		}
		if (period > 60) {
			System.out.printf("%s to %s: we can't create credit with period over 60 months.Sorry.\n", super.name,
					client.getName());
			return null;
		}
		Credit credit = new Credit(this, interestRate, client, amount, period);
		if (client.getTotalIncome() - credit.getMonthCashTransfer() < 0.5 * client.getIncome()) {
			if (amount <= calculateAbilityOfBankForCredit()) {
				return credit;
			}
			System.out.printf("%s to %s: The bank have not enough money for your credit.Sorry!\n", super.name,
					client.getName());
		}
		System.out.printf("%s to %s: we can't create credit for you,becouse you have low income!\n", super.name,
				client.getName());
		return null;
	}

	private void createCredit(Credit credit) {
		this.products.add(credit);
		this.cash -= credit.getAmount();
	}

	// default Methods:

	// public Methods:

	public boolean createShortDeposit(Client client, double amount) {
		if (clientCanMakeDeposit(client, amount)) {
			Deposit deposit = new Deposit(this, 0.03, client, amount, 3);
			client.createDeposit(deposit);
			this.createDeposit(deposit);
			return true;
		}
		return false;
	}

	public boolean createLongDeposit(Client client, double amount) {
		if (clientCanMakeDeposit(client, amount)) {
			Deposit deposit = new Deposit(this, 0.05, client, amount, 12);
			client.createDeposit(deposit);
			this.createDeposit(deposit);
			return true;
		}
		return false;
	}

	public boolean createHomeCredit(Client client, double amount, int periodInMonths) {
		Credit credit = clientCredit(client, 0.06, amount, periodInMonths);
		if (credit != null) {
			client.createCredit(credit);
			this.createCredit(credit);
			return true;
		}
		return false;
	}

	public boolean createConsumerCredit(Client client, double amount, int periodInMonths) {
		Credit credit = clientCredit(client, 0.10, amount, periodInMonths);
		if (credit != null) {
			client.createCredit(credit);
			this.createCredit(credit);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Bank:%s\nBank money:%.2flv\nBank reserve:%.2f", super.name, super.cash, this.reserve);
	}

}
