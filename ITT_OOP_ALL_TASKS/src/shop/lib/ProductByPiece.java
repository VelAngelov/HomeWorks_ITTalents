package shop.lib;

public class ProductByPiece extends Product {

	public ProductByPiece(String name, double pricePerUnit, int quantity) {
		super(name, pricePerUnit, quantity, "piece");
	}

}
