package imigrants.lib.imigrants;

import imigrants.lib.Town;

public class NormalIm extends Imigrant{

	public NormalIm(double cash, Town town) {
		super(ImigrantType.NORMAL, cash, town);
	}

	@Override
	public void shootWithWeapons() {
		return;
	}

}
