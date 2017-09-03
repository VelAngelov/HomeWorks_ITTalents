package imoti.classes;

import java.util.ArrayList;

public class Buyer extends Client {
	private static int id;
	private ArrayList<View> views;

	private Buyer(String telNumber) {
		super(telNumber);
		id++;
		this.views = new ArrayList<View>();
	}

	public Buyer(String name, String telNumber, double cash) {
		this(telNumber);
		this.name = Validator.validateString(name) ? name : ("Buyer" + id);
		super.cash = cash > 0 ? cash : 150000;
	}

	public void addView(View view) {
		this.views.add(view);
		System.out.printf("Buyer:%s says: I have see new %s with %s.\n", this.name, view.getProperty().getType(),
				view.getAgent().getName());
	}

	public double getCash() {
		return cash;
	}

	public void buyRndProperty() {
		Property p = views.get(Validator.rnd(0, views.size())).getProperty();
		super.imot = p;
		if (p == null) {
			System.out.println("oops!");
			return;
		}
		double price = p.getPrice();
		Client seller = p.getOwner();
		Agent agent = p.getAgent();
		Agency agency = agent.getAgency();
		seller.addCesh(price * 0.93);
		agent.addCesh(0.06 * price);
		agency.addCesh(0.06 * price);
		this.cash -= price;
		p.setOwner(this);
		agency.removeImotFromCatalog(p);
		System.out.printf("%s buyed new %s,%s for %.2f\n", this.name, p.getType(), p.getDescription(), p.getPrice());
	}
}
