package imoti.classes;

public abstract class Client extends Entity {
	private Agent agent;
	protected Property imot;

	Client(String telNumber) {
		super(telNumber);
	}

	public Agent getAgent() {
		return agent;
	}

	void setAgent(Agent agent) {
		this.agent = agent;
	}

	void addCesh(double cash) {
		super.cash += cash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client c = (Client) obj;
			return this.name.equals(c.getName()) && this.getTelNumber().equals(c.getTelNumber());
		}
		return false;
	}
}
