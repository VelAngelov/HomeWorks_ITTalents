package shop.classes.stock;

public class QuantityByKg implements IQuantity {
	private double quantity;

	public QuantityByKg(String quantity) {
		setQuantity(quantity);
	}

	private double convertToDouble(String q) {
		q = q.replaceAll("[a-zA-Z]", "");
		return Double.parseDouble(q);
	}

	@Override
	public void setQuantity(String quantity) {
		this.quantity = Double.parseDouble(quantity.substring(0, quantity.length() - 2));
	}

	@Override
	public String getQuantity() {
		return String.format("%.2fkg", quantity);
	}

	@Override
	public void addQuantity(String quantity) {
		this.quantity += Double.parseDouble(quantity.substring(0, quantity.length() - 2));
	}

	@Override
	public boolean removeQuantity(String quantity) {
		if (!quantity.toLowerCase().endsWith("kg")) {
			return false;
		}
		double q = Double.parseDouble(quantity.substring(0, quantity.length() - 2));
		if (this.quantity >= q) {
			this.quantity -= q;
			return true;
		}
		return false;
	}

	@Override
	public boolean equalQuantity(String quantity) {
		double q = convertToDouble(quantity);
		return q == this.quantity;
	}

	@Override
	public boolean isBigger(String quantity) {
		double q = convertToDouble(quantity);
		return this.quantity > q;
	}

}
