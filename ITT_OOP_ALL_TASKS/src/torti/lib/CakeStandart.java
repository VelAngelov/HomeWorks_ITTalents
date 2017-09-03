package torti.lib;

public class CakeStandart  extends Cake{
	private boolean isSiropirana;
	public CakeStandart(CakeSpecial kind, double price, int pieces,boolean isSiropirana) {
		super(kind, price, pieces);
		this.isSiropirana=isSiropirana;
	}

	@Override
	public int compareTo(Cake o) {
		if(this.getPrice()==o.getPrice()) {
			return 1;
		}
		return Double.compare(this.getPrice(), o.getPrice());
	}

	@Override
	protected String additionalInfo() {
		return this.isSiropirana?"Siropirana":"Nesiropirana";
	}
	
}