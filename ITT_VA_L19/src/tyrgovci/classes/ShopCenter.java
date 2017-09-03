package tyrgovci.classes;

import java.util.ArrayList;

public abstract class ShopCenter extends Entity {
	protected int area;
	protected int danyk;
	private Trader owner;
	private ArrayList<Product> products;

	public ShopCenter(String adress, int area, int danyk, String rabVreme) {
		super(adress);
		this.area = area;
		this.danyk = danyk;
		super.setRabVreme(rabVreme);
		this.products = new ArrayList<Product>();
	}

	public boolean setOwner(Trader owner) {
		if (this.owner == null) {
			this.owner = owner;
			return true;
		}
		return false;
	}

	public boolean sellProducts() {
		if (this.products != null && !this.products.isEmpty()) {
			for (Product p : products) {
				this.addCash((int) (p.getCash() * 1.3));
			}
			this.products = new ArrayList<Product>();
			return true;
		}
		return false;
	}

	public void addProductForSale(ArrayList<Product> products) {
		this.products.addAll(products);
	}

	@Override
	public String getRabVreme() {
		return super.getRabVreme();
	}

	public int getBill() {
		return danyk;
	}

}
