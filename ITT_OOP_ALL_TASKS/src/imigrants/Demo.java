package imigrants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import imigrants.lib.Country;
import imigrants.lib.Police;
import imigrants.lib.Policemans;
import imigrants.lib.Swat;
import imigrants.lib.Town;
import imigrants.lib.Weapon;
import imigrants.lib.Weapon.WeaponType;
import imigrants.lib.exc.DieFromAngerException;
import imigrants.lib.imigrants.ExtreamIm;
import imigrants.lib.imigrants.Imigrant;
import imigrants.lib.imigrants.NormalIm;
import imigrants.lib.imigrants.RadicalIm;

/*
 * 1. Създава държава с 5 града в нея. Нека на произволен принцип да се
зададат броя жители, да се генерират на произволен принцип и
полицейски служители, които да се разпределят по равно в градовете.
2. Създава 100 имигранта, като на произволен принцип трябва да бъдат
нормални, екстремисти или радикални. Вероятността да се създаде
радикалист трябва да е 25%, екстремист – 35% , а нормален имигрант –
40%. Да им се зададат произволни имена и произволна сума пари в евро,
както и паспорт където е възможно. Радикалните имигранти трябва да
имат 35% шанс да имат паспорт. Нека всеки да има по 2 роднини от
останалите имигранти зачислен на произволен принцип.
3. Да се създадат 200 оръжия на произволен принцип. Нека всеки имигрант
да пробва да купи произволни 5 от тях, като ако 1 оръжие е продадено, не
се продава пак.
4. Нека всички имигранти на произволен принцип да имигрират в някой
град. Когато имигрант мигрира на произволен принцип се зачислява
полицейски служител, който проверява паспорта му.
5. Да се изведе за всеки имигрант, града в който пребивава в момента, дали
притежава паспорт, парите с които разполага и имената на роднините му.
6. На произволен принцип да се изберат 20 имигранти, които да стрелят или
да се взривят ако притежават бомба.
7. Да се изведат градовете сортирани по брой оцелели жители в тях,
имигрантите - по брой пари, както и всички имигранти, които са имали
бомба, но вече са я взривили.
 */
public class Demo {
	public static Random rnd = new Random();
	public static void main(String[] args) {
		//1:
		Country germany = new Country("Germany");
		for (int i = 0; i < 5; i++) {
			Town town = new Town("Town"+i, 15000+rnd.nextInt(100001), germany);
			int cops =5+ rnd.nextInt(20);
			for(int j = 0; j<cops;j++) {
				if(rnd.nextBoolean()) {
					@SuppressWarnings("unused")
					Policemans p = new Swat(town);
				}else {
					@SuppressWarnings("unused")
					Policemans p = new Police(town);
				}
			}
		}
		//2:
		ArrayList<Imigrant> imigrants = new ArrayList<>();
		int chanceNormal=40;
		int chanceRadical=25;
		int chanceExtream=35;
		for (int i = 0; i < 100; i++) {
			int chance = rnd.nextInt(chanceNormal+chanceExtream+chanceRadical);
			if(chance<chanceNormal) {
				imigrants.add(new NormalIm(2000+rnd.nextInt(4000), null));
			}else if(chance<chanceRadical+chanceNormal) {
				imigrants.add(new RadicalIm(2000+rnd.nextInt(15000), null));
			}else {
				imigrants.add(new ExtreamIm(2000+rnd.nextInt(15000), null));
			}
		}
		for (int i = 0; i < 100; i++) {
			imigrants.get(i).makeRelations(imigrants);
		}
		//3:
		ArrayList<Weapon> weapons = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			int chance=rnd.nextInt(10+50+40);
			if(chance<10) {
				weapons.add(new Weapon(WeaponType.BOMBA, 3000));
			}else if(chance<10+50) {
				weapons.add(new Weapon(WeaponType.AVTOMAT, 2000));
			}else {
				weapons.add(new Weapon(WeaponType.PISTOLET, 500));
			}
		}
		for (Iterator<Imigrant> it=imigrants.iterator(); it.hasNext();) {
			try {
				it.next().buyWeapons(weapons);
			}catch (DieFromAngerException e) {
				System.err.println("I'm dying of anger");
				it.remove();
			}
		}
		//4.
		for (int i = 0; i < imigrants.size(); i++) {
			imigrants.get(i).migrateInCountry(germany);
		}
		//5.
		for (int i = 0; i < imigrants.size(); i++) {
			Imigrant imigrant = imigrants.get(i);
			System.out.println(imigrant);
		}
		//6
		for (int i = 0; i < 20; i++) {
			Imigrant im = imigrants.get(rnd.nextInt(imigrants.size()));
			im.shootWithWeapons();
		}
	}
	
}