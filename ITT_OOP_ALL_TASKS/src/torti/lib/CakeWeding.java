package torti.lib;

public class CakeWeding extends Cake{
	private int etaji;
	public CakeWeding(CakeSpecial kind, double price, int pieces,int etaji) {
		super(kind, price, pieces);
		this.etaji=etaji;
	}

	@Override
	public int compareTo(Cake o) {
		if(this.getPieces()==o.getPieces()) {
			return 1;
		}
		return this.getPieces()- o.getPieces();
	}

	@Override
	protected String additionalInfo() {
		return etaji+"Etaja";
	}
	
}