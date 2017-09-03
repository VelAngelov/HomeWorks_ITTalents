package torti.lib;

public class CakeSpecial extends Cake{
	private String sybitie;
	public CakeSpecial(CakeSpecial kind, double price, int pieces,String sybitie) {
		super(kind, price, pieces);
		this.sybitie=sybitie;
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
		return this.sybitie;
	}
	
}
