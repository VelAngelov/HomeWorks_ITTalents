package mortalCombat;

public class Fighter {
	String nameString;
	int MAX_LIFE = 200;
	int life = MAX_LIFE;
	int damage = 10;

	double chanceToRealizeBlock = 0.3;
	double damageDecreased = 0.6;
	boolean isBlock;

	double chanceToRealizeCriticalHit = 0.05;
	double criticalHitCoeficient = 2;
	boolean isCriticalHit;

	double chanceToAvoidDamage = 0.1;
	boolean isMiss;

	double reflectDamageChance = 0.05;
	double reflectPercentFromDamage = 0.5;
	boolean isReflect;

	Fighter enemy;

	void hit() {
		isCriticalHit = occurrence(chanceToRealizeCriticalHit);
		isBlock = occurrence(enemy.chanceToRealizeBlock);
		isMiss = occurrence(enemy.chanceToAvoidDamage);
		isReflect = occurrence(enemy.reflectDamageChance);
		int damageRealizedByAttacker = damage;
		int damageRealizedByDefender = 0;
		
		
		if (isCriticalHit) {
			damageRealizedByAttacker = (int) (damage * criticalHitCoeficient);
			System.out.printf("%s realized CRITCAL HIT to %s with damage:%d!!!%n", nameString, enemy.nameString,
					damageRealizedByAttacker);
		} else {
			if (isMiss) {
				damageRealizedByAttacker = 0;
				if (isReflect) {
					damageRealizedByDefender = (int) (enemy.damage * enemy.reflectPercentFromDamage);
					System.out.printf("%s avoid the attack and realize CONTRA ATTACK to %s with damage:%d%n",
							enemy.nameString, nameString, damageRealizedByDefender);
				} else {
					System.out.printf("%s avoid the attack from %s !%n", enemy.nameString, nameString);
				}
			} else if (isBlock) {
				damageRealizedByAttacker = (int) (damage * enemy.damageDecreased);
				if (isReflect) {
					damageRealizedByDefender = (int) (enemy.damage * enemy.reflectPercentFromDamage);
					System.out.printf(
							"%s block the attack and take damage:%d after that realize CONTRA ATTACK to %s with damage:%d%n",
							enemy.nameString, damageRealizedByAttacker, nameString, damageRealizedByDefender);
				} else {
					System.out.printf("%s block the attack and take damage:%d from %s !%n", enemy.nameString,
							damageRealizedByAttacker, nameString);
				}
			} else if (isReflect) {
				damageRealizedByDefender = (int) (enemy.damage * enemy.reflectPercentFromDamage);
				System.out.printf("%s attack %s and realize damage %d, but %s realize CONTRA ATTACK with damage %d%n",
						nameString, enemy.nameString, damageRealizedByAttacker, enemy.nameString,
						damageRealizedByDefender);
			}else {
				System.out.printf("%s attack %s and realize damage %d%n", nameString,enemy.nameString,damageRealizedByAttacker);
			}
		}
		enemy.life -= min(enemy.life, damageRealizedByAttacker);
		life -= min(life, damageRealizedByDefender);
		if(isDead()&&enemy.isDead()) {
			System.out.printf("%s and %d fall dead together %n",nameString,enemy.nameString);
			return;
		}else if(isDead()) {
			System.out.printf("%s fall dead.%nWINNER: %s%n",nameString,enemy.nameString);
		}else if(enemy.isDead()) {
			System.out.printf("%s fall dead.%nWINNER: %s%n",enemy.nameString,nameString);
		}
	}

	boolean occurrence(double chance) {
		double fact = Math.random();
		if (fact < chance) {
			return true;
		}
		return false;
	}

	boolean isDead() {
		if (life <= 0) {
			return true;
		}
		return false;
	}

	static int min(int a, int b) {
		return a > b ? b : a;
	}
}
