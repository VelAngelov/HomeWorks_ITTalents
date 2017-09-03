package bank.classes;

public abstract class BankProduct {
	private static int id;
	private String type;
	protected double interestRate;
	protected int periodInMonths;
	protected double amount;
	protected Client client;
	protected Bank bank;

	private BankProduct() {
		id++;
	}

	BankProduct(String type, Bank bank, double interestRate, Client client, double amount, int periodInMonths) {
		this();
		this.type = type;
		this.bank = bank;
		this.client = client != null ? client : new Client(null, null, 0, 0);
		this.amount = amount > 0 ? amount : 0;
		this.periodInMonths = (periodInMonths > 0 && periodInMonths <= 60) ? periodInMonths : 0;
		this.interestRate = interestRate > 0 ? interestRate : 0;
	}

	public int getPeriodInMonths() {
		return periodInMonths;
	}

	public Bank getBank() {
		return bank;
	}

	public String getType() {
		return type;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public Client getClient() {
		return client;
	}

	public String getOrderId() {
		return "order" + id;
	}

	public double getMonthCashTransfer() {
		return amount * interestRate;
	}

	// Overide methods:

	public double getAmount() {
		return amount;
	}

	public abstract void monthlyBill();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Client:%s\t Bank:%s\n ", this.client.getName(), this.bank.getName()));
		sb.append(String.format("Type:%s\tMoney:%.2flv\tInterest rate:%.2f%%\tMonths left:%d\n", type, amount,
				interestRate * 100, periodInMonths));
		return sb.toString();
	}
}
