package torti2.lib.cakes;
/*
 * Стандартната торта може да бъде �?иропирана или не.
Сватбената торта �?ъдържа информаци�? за това на колко етажа е.
Специалната торта пази в �?ебе �?и името на �?ъбитието за което е �?ъздадена.
Дет�?ката торта пази името на детето, за което е правена.
 */
public class StandartCake extends Cake{
	public StandartCake(String opisanie, String naimenovanie, int price, int pieces, StandartCakes type,
			boolean isSiroped) {
		super(opisanie, naimenovanie, price, pieces, KindsCakes.STANDART.toString(), type.toString(), isSiroped?"Siropirana":"Nesiropirana");
	}
}
