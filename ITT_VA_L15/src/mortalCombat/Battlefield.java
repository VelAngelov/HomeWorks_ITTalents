package mortalCombat;

public class Battlefield {
	public static void main(String[] args) {
		Fighter subZero = new Fighter();
		subZero.nameString = "SubZero";
		Fighter scorpion = new Fighter();
		scorpion.nameString = "Scorpion";

		subZero.enemy = scorpion;
		scorpion.enemy = subZero;
		int count = 0;
		while (!scorpion.isDead() && !subZero.isDead()) {
			System.out.printf("%n%n========================ROUND  %d==============================%n", ++count);
			if (!scorpion.isDead() && !subZero.isDead()) {
				dellay((int) (Math.random() * 500));
				scorpion.hit();
			}
			if (!scorpion.isDead() && !subZero.isDead()) {
				dellay((int) (Math.random() * 500));
				subZero.hit();
			}
			
			System.out.printf("%s life:%d%n", scorpion.nameString, scorpion.life);
			System.out.printf("%s life:%d%n", subZero.nameString, subZero.life);
			dellay(3000);
		}
	}

	static void dellay(int ms) {
		try {
			Thread.sleep(500 + ms);
		} catch (InterruptedException ex) {
		}
	}
}
