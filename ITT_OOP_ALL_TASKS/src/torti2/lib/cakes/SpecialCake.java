package torti2.lib.cakes;
/*
 * Стандартната торта може да бъде �?иропирана или не.
Сватбената торта �?ъдържа информаци�? за това на колко етажа е.
Специалната торта пази в �?ебе �?и името на �?ъбитието за което е �?ъздадена.
Дет�?ката торта пази името на детето, за което е правена.
 */


public class SpecialCake extends Cake{
	public SpecialCake(String opisanie, String naimenovanie, int price, int pieces, SpecialCakes type,
			String sybitie) {
		super(opisanie, naimenovanie, price, pieces, KindsCakes.SPECIAL.toString(), type.toString(), sybitie);
	}
}

