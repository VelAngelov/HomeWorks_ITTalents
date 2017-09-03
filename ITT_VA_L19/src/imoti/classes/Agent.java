package imoti.classes;

import java.util.ArrayList;
import java.util.Comparator;

public class Agent extends Entity implements Comparable<Agent>, Comparator<Agent> {
	private static int id;
	private ArrayList<Seller> sellers;
	private ArrayList<Buyer> buyers;
	private Agency agency;

	public Agent(String name, String telNumber, Agency agency) {
		super(telNumber);
		id++;
		this.name = Validator.validateString(name) ? name : ("Agent" + id);
		this.sellers = new ArrayList<Seller>();
		this.buyers = new ArrayList<Buyer>();
		this.agency = agency;
	}

	Agency getAgency() {
		return agency;
	}

	public boolean addSeller(Seller seller) {
		if (seller == null || sellers.contains(seller)) {
			return false;
		}
		this.sellers.add(seller);
		return true;
	}

	public boolean addBuyer(Buyer buyer) {
		if (buyer == null || buyers.contains(buyer)) {
			return false;
		}
		this.buyers.add(buyer);
		return true;
	}

	public View goToViewProp(ArrayList<Property> properties, Buyer buyer, int attempts) {
		if (attempts > 50) {
			return null;
		}
		int num = Validator.rnd(0, properties.size());
		attempts++;
		if (properties.get(num).getPrice() < buyer.getCash()) {
			View v = new View(properties.get(num), this, buyer, null);
			buyer.addView(v);
			return v;
		}
		return goToViewProp(properties, buyer, attempts);
	}

	public ArrayList<Buyer> getBuyers() {
		return buyers;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Agent) {
			Agent a = (Agent) obj;
			return this.name.equals(a.getName()) && this.telNumber.equals(a.getTelNumber());
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s(%.2flv)", this.name, this.cash);
	}

	@Override
	public int compare(Agent o1, Agent o2) {
		return (int) ((-o1.cash + o2.cash) * 100);
	}

	@Override
	public int compareTo(Agent o) {
		return this.name.compareTo(o.getName());
	}
}
