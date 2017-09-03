package imigrants.lib.imigrants;

import imigrants.lib.Town;
import imigrants.lib.Weapon;
import imigrants.lib.exc.BombBlownException;
import imigrants.lib.exc.NoMoreCitizensException;

public class RadicalIm extends Imigrant{

	private static final double SHOOT_FACTOR = 0.7;

	public RadicalIm(double cash, Town town) {
		super(ImigrantType.RADICAL, cash, town);
	}

	@Override
	public void shootWithWeapons() {
		for(Weapon w:weapons) {
			if(this.town==null) {
				return;
			}
			try {
				int bams = w.shoot();
				System.out.print(this.type + "kill ");
				if(bams<10) {
					this.town.removeCitizens(10);
					System.out.println(10 + " people in "+this.town.getName());
				}else {
					int shooted = (int)(bams*SHOOT_FACTOR);
					System.out.println(shooted + " people in "+this.town.getName());
					this.town.removeCitizens((int)(bams*SHOOT_FACTOR));
				}
			}catch (NoMoreCitizensException e) {
				System.err.println("All citizens die in town:" +this.town);
			}
		}
		
	}
}
