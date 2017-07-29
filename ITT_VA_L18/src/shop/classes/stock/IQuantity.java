package shop.classes.stock;

public interface IQuantity {
	public void setQuantity(String quantity);
	public String getQuantity();
	public void addQuantity(String quantity);
	public boolean removeQuantity(String quantity);
	public boolean equalQuantity(String quantity);
	public boolean isBigger(String quantity);
}
