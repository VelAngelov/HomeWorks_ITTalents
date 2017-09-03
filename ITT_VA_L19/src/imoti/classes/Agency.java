package imoti.classes;

import java.util.ArrayList;
import java.util.Collections;

public class Agency extends Entity {
	private String adress;
	private ArrayList<Agent> agents;
	private ArrayList<Property> katalog;
	// katalog

	public Agency(String name, String telNumber, String adress) {
		super(telNumber);
		this.name = Validator.validateString(name) ? name : "Talanti Esteits";
		this.adress = Validator.validateString(adress) ? adress : "gr.Sofiq bul.Bulgaria";
		this.agents = new ArrayList<Agent>();
		this.katalog = new ArrayList<Property>();
	}

	public Agent getRndAgent() {
		return this.agents.get(Validator.rnd(0, this.agents.size()));
	}

	public boolean addAgent(Agent agent) {
		if (agent == null || agents.contains(agent)) {
			return false;
		}
		this.agents.add(agent);
		return true;
	}

	public void generateAgents(int number) {
		for (int i = 0; i < number; i++) {
			Agent a = new Agent(null, null, this);
			addAgent(a);
		}
	}

	public boolean registerPropertyForSale(Seller seller) {
		Property p = seller.getImot();
		if (p == null || this.katalog.contains(p)) {
			return false;
		}
		this.katalog.add(p);
		Agent a = getRndAgent();
		a.addSeller(seller);
		p.setAgent(a);
		return true;
	}

	public void registerNewBuyer(Buyer buyer) {
		Agent a = getRndAgent();
		a.addBuyer(buyer);
	}

	public void goToViewPropertiesWithAgents() {
		for (Agent a : agents) {
			for (Buyer b : a.getBuyers()) {
				a.goToViewProp(this.katalog, b, 0);
			}
		}
	}

	void removeImotFromCatalog(Property p) {
		this.katalog.remove(p);
	}

	public void printResultsForAgents() {
		Collections.sort(agents,new Agent(null, null, null));
		for (Agent a : agents) {
			System.out.println(a);
		}
	}

	@Override
	public String toString() {
		return String.format("Agency:%s balance is %.2f\n", this.name, this.cash);
	}
}
