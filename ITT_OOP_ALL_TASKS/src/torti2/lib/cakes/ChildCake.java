package torti2.lib.cakes;

/*
 * Стандартната торта може да бъде �?иропирана или не.
Сватбената торта �?ъдържа информаци�? за това на колко етажа е.
Специалната торта пази в �?ебе �?и името на �?ъбитието за което е �?ъздадена.
Дет�?ката торта пази името на детето, за което е правена.
 */
public class ChildCake extends Cake{
	public ChildCake(String opisanie, String naimenovanie, int price, int pieces, ChildCakes type,
			String nameOfChild) {
		super(opisanie, naimenovanie, price, pieces, KindsCakes.CHILD.toString(), type.toString(), nameOfChild);
	}
	@Override
	public int compareTo(Cake o) {
		return this.getPieces()-o.getPieces();
	}
}
