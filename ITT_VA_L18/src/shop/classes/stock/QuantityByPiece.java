package shop.classes.stock;

public class QuantityByPiece implements IQuantity {
	private int quantity;
	public QuantityByPiece(String quantity) {
		setQuantity(quantity);
	}
	private int convertToInt(String q) {
		q = q.replaceAll("[a-zA-Z]", "");
		return Integer.parseInt(q);
	}
	@Override
	public void setQuantity(String quantity) {
		this.quantity = Integer.parseInt(quantity.substring(0, quantity.length() - 1));
	}

	@Override
	public String getQuantity() {
		return String.format("%dp", quantity);
	}
	@Override
	public void addQuantity(String quantity) {
		this.quantity += Integer.parseInt(quantity.substring(0, quantity.length() - 1));
	}
	@Override
	public boolean removeQuantity(String quantity) {
		if (!quantity.toLowerCase().endsWith("p")) {
			return false;
		}
		int q = Integer.parseInt(quantity.substring(0, quantity.length() - 1));
		if (this.quantity >= q) {
			this.quantity -= q;	
			return true;
		}
		return false;
	}
	@Override
	public boolean equalQuantity(String quantity) {
		int q = convertToInt(quantity);
		return q==this.quantity;
	}
	@Override
	public boolean isBigger(String quantity) {
		int q = convertToInt(quantity);
		return this.quantity>q;
	}

}
