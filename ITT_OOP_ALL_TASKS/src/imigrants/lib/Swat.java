package imigrants.lib;

import imigrants.lib.imigrants.Imigrant;
/*
 * • Спец-части – залавят около 90% от нелегалните имигранти, каквито и да
са те. Те проверяват само имигрантите, които са радикални и екстремисти.
 */
public class Swat extends Policemans{

	public Swat(Town town) {
		super(PolicemanType.SWAT, town);
	}

	@Override
	public boolean passInBorder(Imigrant imigrant) {
		if(imigrant.isNormal()) {
			return true;
		}
		double chance = Math.random();
		if(chance>this.getType().getRateToCatchImigrant()) {
			return true;
		}
		return imigrant.isLegal();
	}

}
