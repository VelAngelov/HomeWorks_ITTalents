package shop.classes.stock;

public class Quantity implements IQuantity  {
	private IQuantity stock;
	public Quantity(String quantity){
		setQuantity(quantity);
	}
	@Override
	public void setQuantity(String quantity) {
		if(quantity.toLowerCase().endsWith("kg")) {
			this.stock = new QuantityByKg(quantity);
		}else if(quantity.toLowerCase().endsWith("p")) {
			this.stock = new QuantityByPiece(quantity);
		}else {
			System.out.println("You have not specified the type of quantity");
			this.stock = null;
		}
	}
	@Override
	public String getQuantity() {
		return this.stock.getQuantity();
	}
	@Override
	public void addQuantity(String quantity) {
		this.stock.addQuantity(quantity);
	}
	@Override
	public boolean removeQuantity(String quantity) {
		if(this.stock.removeQuantity(quantity)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean equalQuantity(String quantity) {
		return this.stock.equalQuantity(quantity);
	}
	@Override
	public boolean isBigger(String quantity) {
		return this.stock.isBigger(quantity);
	}
}
