package imoti.classes;

public abstract class Property {
	protected String description;
	protected String adress;
	protected double price;
	protected String type;
	protected double area;
	protected Agent agent;
	protected Client owner;

	void setOwner(Client owner) {
		this.owner = owner;
	}

	public Client getOwner() {
		return owner;
	}

	public Agent getAgent() {
		return agent;
	}

	void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getDescription() {
		return description;
	}

	public String getAdress() {
		return adress;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public double getArea() {
		return area;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Property) {
			Property p = (Property) obj;
			if (this.adress.equals(p.adress) && this.type.equals(p.type) && this.description.equals(p.description)) {
				return true;
			}
		}
		return false;
	}

}
