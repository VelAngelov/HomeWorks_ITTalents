package imigrants.lib.imigrants;

import imigrants.lib.Town;
import imigrants.lib.Weapon;
import imigrants.lib.exc.BombBlownException;
import imigrants.lib.exc.NoMoreCitizensException;

public class ExtreamIm extends Imigrant{

	private static final double SHOOT_FACTOR = 0.7;

	public ExtreamIm(double cash, Town town) {
		super(ImigrantType.EXTREAM, cash, town);
	}

	@Override
	public void shootWithWeapons() {
		for(Weapon w:weapons) {
			if(this.town==null) {
				return;
			}
			try {
				int bams = w.shoot();
				if(this.isCarryingBomb()) {
					throw new BombBlownException();
				}
				System.out.print(this.type + "kill ");
				if(bams<10) {
					System.out.println("10 people in "+this.town.getName());
					this.town.removeCitizens(10);
				}else {
					int shooted = (int)(bams*SHOOT_FACTOR);
					System.out.println(shooted + " people in "+this.town.getName());
					this.town.removeCitizens(shooted);
				}
			}catch (BombBlownException e) {
				System.err.println("Bomb blown in town:" +this.town.getName());
			}catch (NoMoreCitizensException e) {
				System.err.println("All citizens die in town:" +this.town.getName());
			}
		}
	}

}
