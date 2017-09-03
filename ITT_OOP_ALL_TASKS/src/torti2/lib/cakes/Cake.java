package torti2.lib.cakes;

public abstract class Cake implements Comparable<Cake>{
	public enum KindsCakes{
		STANDART,WEDING,SPECIAL,CHILD
	}
	public enum StandartCakes{
		BISKVITENA,EKLEROVA,PLODOVA,SHOKOLADOVA
	}
	public enum WedingCakes{
		GOLIAMA,MALKA,SREDNA
	}
	public enum SpecialCakes{
		IUBIEINA,FIRMENA,REKLAMNA
	}
	public enum ChildCakes{
		ROJDEN_DEN,KRYSHTANE,PROSHTAPULNIK
	}
	
	private String opisanie;
	private String naimenovanie;
	private int price;
	private int pieces;
	private String kind;
	private String type;
	private String addInfo;
	
	protected Cake(String opisanie, String naimenovanie, int price, int pieces, String kind, String type, String addInfo) {
		super();
		this.opisanie = opisanie;
		this.naimenovanie = naimenovanie;
		this.price = price;
		this.pieces = pieces;
		this.kind = kind;
		this.type = type;
		this.addInfo = addInfo;
	}
	
	public String getKind() {
		return kind;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	public int getPieces() {
		return pieces;
	}

	@Override
	public String toString() {
		return "CakeKind "+kind+", "+type+", pieces:"+pieces+", price"+price+"lv"+"("+opisanie+", "+ naimenovanie+", "+addInfo+")";
	}
	/** Compare by price des*/
	@Override
	public int compareTo(Cake o) {
		return -this.price+o.price;
	}
	
}
