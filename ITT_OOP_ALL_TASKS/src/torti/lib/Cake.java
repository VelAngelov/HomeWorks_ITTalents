package torti.lib;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Тортите биват:
1. стандартна торта (бисквитена, еклерова, плодова и шоколадова);

2. сватбена торта (голяма, малка и средна);
3. специална торта (юбилейна, фирмена и рекламна);
4. детска торта (за рожден ден, за кръщене и за прощапулник).
Стандартната торта може да бъде сиропирана или не.
Сватбената торта съдържа информация за това на колко етажа е.
Специалната торта пази в себе си името на събитието за което е създадена.
Детската торта пази името на детето, за което е правена.
Тортите са категоризирани по вид (стандартна, сватбена, специална и детска), като за всеки
вид във витрините се съдържат подредени по тип, а за всеки тип може да има няколко торти в
наличност. Стандартните и специалните торти са подредени по цена, в низходящ ред, а
сватбените и детските – по брой парчета.
 */
public abstract class Cake implements Comparable<Cake>{
	public enum CakeType{
		STANDART,WEDING,SPECIAL,CHILD;
	}
	public interface CakeKind{
		CakeType getType();
	}
	public enum CakeStandart implements CakeKind{
		BISKVITENA(CakeType.STANDART),
		EKLEROVA(CakeType.STANDART),
		PLODOVA(CakeType.STANDART),
		SHOKOLADOVA(CakeType.STANDART);
		private CakeType type;
		private CakeStandart(CakeType type) {
			this.type=type;
		}
		public CakeType getType() {
			return type;
		}
	}
	public enum CakeWeding implements CakeKind{
		GOLQMA(CakeType.WEDING),
		MALKA(CakeType.WEDING),
		SREDNA(CakeType.WEDING);
		private CakeType type;
		private CakeWeding(CakeType type) {
			this.type=type;
		}
		public CakeType getType() {
			return type;
		}
	}
	public enum CakeSpecial implements CakeKind{
		IUBILEINA(CakeType.SPECIAL),
		FIRMENA(CakeType.SPECIAL),
		REKLAMNA(CakeType.SPECIAL);
		private CakeType type;
		private CakeSpecial(CakeType type) {
			this.type=type;
		}
		public CakeType getType() {
			return type;
		}
	}
	public enum CakeChild implements CakeKind{
		ROJDEN_DEN(CakeType.STANDART),
		KRYSHTANE(CakeType.STANDART),
		PROSHTAPULNIK(CakeType.STANDART);
		private CakeType type;
		private CakeChild(CakeType type) {
			this.type=type;
		}
		public CakeType getType() {
			return type;
		}
	}
	
	private String type;
	private String kind;
	private double price;
	private int pieces;
	protected abstract String additionalInfo();
	
	public Cake(CakeKind kind, double price, int pieces) {
		this.type = kind.getType().toString();
		this.kind = kind.toString();
		this.price = price;
		this.pieces = pieces;
	}
	public int getPieces() {
		return pieces;
	}
	public double getPrice() {
		return price;
	}
	public String getKind() {
		return kind;
	}
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Cake " + type + ", kind=" + kind + ", price=" + price + ", pieces=" + pieces;
	}
	
}
