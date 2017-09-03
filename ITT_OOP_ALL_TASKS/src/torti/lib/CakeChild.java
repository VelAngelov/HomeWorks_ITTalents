package torti.lib;

public class CakeChild extends Cake{
	private String imeNaDeteto;
	public CakeChild(CakeSpecial kind, double price, int pieces,String imeNaDeteto) {
		super(kind, price, pieces);
		this.imeNaDeteto=imeNaDeteto;
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
		return this.imeNaDeteto;
	}
	
}