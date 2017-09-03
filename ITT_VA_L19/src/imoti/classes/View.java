package imoti.classes;

public class View {
	private Property property;
	private Agent agent;
	private Buyer buyer;
	private String date;

	public View(Property property, Agent agent, Buyer buyer, String date) {
		this.property = property;
		this.agent = agent;
		this.buyer = buyer;
		this.date = Validator.validateString(date) ? date : "no info";
	}

	public Property getProperty() {
		return property;
	}

	public Agent getAgent() {
		return agent;
	}

}
