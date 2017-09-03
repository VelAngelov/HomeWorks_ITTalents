package imigrants.lib;

import imigrants.lib.imigrants.Imigrant;
/*
 * • Полицаи – те залавят около 50% от нелегалните имигранти (радикални и
екстремисти). Не могат да залавят обаче имигранти, които носят бомба в
себе си. Те проверят всички имигранти, независимo от типа им и дали
имат паспорт.
 */
public class Police extends Policemans{

	public Police(Town town) {
		super(PolicemanType.POLICE, town);
	}

	@Override
	public boolean passInBorder(Imigrant imigrant) {
		if(imigrant.isCarryingBomb()) {
			return true;
		}
		double chance = Math.random();
		if(chance>this.getType().getRateToCatchImigrant()) {
			return true;
		}
		return imigrant.isLegal();
	}

}
