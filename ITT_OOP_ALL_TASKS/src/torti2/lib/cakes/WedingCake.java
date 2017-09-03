package torti2.lib.cakes;
/*
 * Стандартната торта може да бъде �?иропирана или не.
Сватбената торта �?ъдържа информаци�? за това на колко етажа е.
Специалната торта пази в �?ебе �?и името на �?ъбитието за което е �?ъздадена.
Дет�?ката торта пази името на детето, за което е правена.
 */
public class WedingCake  extends Cake{
	public WedingCake(String opisanie, String naimenovanie, int price, int pieces, WedingCakes type,
			int floors) {
		super(opisanie, naimenovanie, price, pieces, KindsCakes.WEDING.toString(), type.toString(), Integer.toString(floors>0?floors:2)+" floors");
	}
	@Override
	public int compareTo(Cake o) {
		return this.getPieces()-o.getPieces();
	}
}
