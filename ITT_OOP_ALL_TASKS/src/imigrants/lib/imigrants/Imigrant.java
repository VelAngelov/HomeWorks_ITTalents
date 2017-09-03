package imigrants.lib.imigrants;

import java.util.ArrayList;
import java.util.Random;

import imigrants.lib.Country;
import imigrants.lib.Policemans;
import imigrants.lib.Town;
import imigrants.lib.Weapon;
import imigrants.lib.Weapon.WeaponType;
import imigrants.lib.exc.DieFromAngerException;

/*
 * Един имигрант има следните характеристики:
• Паспорт;
• Начална сума пари в евро;
• Град и държава, в които се намира в момента.
• Списък от роднини, които също са имигранти;
• Списък от оръжия с които разполага.
Паспортът на един имигрант съдържа следните данни:
• Име;
• Години.
• Държава и град по рождение.

Имигрантите биват:
• Нормални имигранти – те задължително имат паспорт, не притежават
оръжие и имат до 10 роднини.
• Радикални имигранти – не винаги носят паспорт, имат неограничен брой
роднини (може и да нямат), и имат максимум до 5 оръжия в себе си, но без
бомби.
• Имигранти-екстремисти – не притежават паспорт, имат неограничен брой
роднини (може и да нямат) и може да притежават неограничен брой
оръжия в себе си от всякакъв тип.
Във всеки град има определен брой жители и имигранти, като няма градове без
жители. В дадена държава и определен неин град могат да навлизат имигранти,
като за всеки имигрант, който иска да влезе се зачислява на произволен принцип
полицейски служител, който го проверя. Ако имигрантът е нормален, той се
пропуска и се добавя към списъка с имигранти в съответния град. Ако не е (т.е. е
радикален или екстремист) и ако няма паспорт, съответния полицейски служител
от града (определен на произволен принцип) с определената за него вероятност
го залавя и се изкарва съобщение. В този случай имигрантът не влиза в града.

 */
public abstract class Imigrant {
	public static final int ATEMPTS_TO_BUY_WEAPON = 5;
	public static Random rnd = new Random();
	public static class Pasport {
		private String name;
		private String country;
		private int age;
		public Pasport(String name, String country, int age) {
			this.name = name;
			this.country = country;
			this.age = age;
		}
	}
	public enum ImigrantType{
		NORMAL(0,10,false,true),
		RADICAL(5,Integer.MAX_VALUE,false,true),
		EXTREAM(Integer.MAX_VALUE,Integer.MAX_VALUE,true,false);
		private int maxNumberWeapons;
		private int maxNumberRelations;
		private boolean canHasBomb;
		private boolean canHasPasport;
		
		private ImigrantType(int maxNumberWeapons, int maxNumberRelations, boolean canHasBomb, boolean canHasPasport) {
			this.maxNumberWeapons = maxNumberWeapons;
			this.maxNumberRelations = maxNumberRelations;
			this.canHasBomb = canHasBomb;
			this.canHasPasport = canHasPasport;
		}

		public int maxNumberWeapons() {
			return maxNumberWeapons;
		}

		public int maxNumberRelations() {
			return maxNumberRelations;
		}

		public boolean canHasBomb() {
			return canHasBomb;
		}

		public boolean canHasPasport() {
			return canHasPasport;
		}
		
		
	}
	protected ImigrantType type;
	private Pasport pasport;
	private double cash;
	protected Town town;
	private ArrayList<Imigrant> friends;
	protected ArrayList<Weapon> weapons;
//	Addtitional values:
	private boolean hasBomb;
	private int numberOfWeapons;
	
	/** town can be null from intialize first*/
	@SuppressWarnings("serial")
	public Imigrant(ImigrantType type, double cash, Town town) {
		this.type = type;
		if(type.canHasPasport) {
			if(ImigrantType.NORMAL==type) {
				this.pasport = generatePasport();
			}else {
				if(rnd.nextBoolean()) {
					this.pasport = generatePasport();
				}
			}
		}
		this.cash = cash;
		this.town = town;
		this.weapons = new ArrayList<>();
		this.friends = new ArrayList<Imigrant>() {
			@Override
			public boolean add(Imigrant e) {
				if(!this.contains(e)) {
					return super.add(e);
				}
				return false;
			}
		};
	}
	
	private Pasport generatePasport() {
		String[] names = {"Im1","Im2","Im3","Im4","Im5","Im6","Im7","Im8"};
		Pasport p = new Pasport(names[rnd.nextInt(names.length)], "TerrorLands",18+rnd.nextInt(20));
		return p;
	}
	
	public void migrateInCountry(Country country) {
		//break the recursion:
		if(this.town!=null) {
			return;
		}
		Town t = country.getRndTownToMigrateIn();
		migrateInTown(t);
	}
	
	private void callMyFriends(Town town) {
		for(Imigrant i:friends) {
			i.migrateInTown(town);
		}
	}
	
	private void migrateInTown(Town town) {
		if(this.town!=null) {
			return;
		}
		Policemans p = town.getRndPoliceman();
		if(p.passInBorder(this)) {
			this.town = town;
			callMyFriends(town);
			System.out.println("new Imigrant "+this.type.toString() + "go in town "+town.getName());
		}
	}
	/**
	 * 
	 * @param weapons
	 * throw DieFromAngerException
	 */
	public void buyWeapons(ArrayList<Weapon> weapons) {
		for (int i = 0; i < ATEMPTS_TO_BUY_WEAPON; i++) {
			if(numberOfWeapons<this.type.maxNumberWeapons) {
				if(weapons.isEmpty()) {
					return;
				}
				Weapon w = weapons.get(rnd.nextInt(weapons.size()));
				if(this.cash >= w.getCost()) {
					weapons.remove(w);
					this.weapons.add(w);
					this.cash-=w.getCost();
					if(w.getType()==WeaponType.BOMBA) {
						this.hasBomb = true;
					}
				}
			}
		}
		if(this.type==ImigrantType.EXTREAM&&this.weapons.size()==0) {
			throw new DieFromAngerException();
		}
	}
	
	public void makeRelations(ArrayList<Imigrant> imigrants) {
		Imigrant friend1 = imigrants.get(rnd.nextInt(imigrants.size()));
		Imigrant friend2 = imigrants.get(rnd.nextInt(imigrants.size()));
		if(friend1 != this) {
			this.friends.add(friend1);
		}
		if(friend2 != this) {
			this.friends.add(friend2);
		}
	}
		
	public abstract void shootWithWeapons();


	public boolean isNormal() {
		return this.type==ImigrantType.NORMAL;
	}

	public boolean isLegal() {
		return this.pasport!=null;
	}

	public boolean isCarryingBomb() {
		return hasBomb;
	}
	/*
	 * 5. Да се изведе за всеки имигрант, града в който пребивава в момента, дали
притежава паспорт, парите с които разполага и имената на роднините му.
	 */

	@Override
	public String toString() {
		String info="Imigrant " + type + ", " + (pasport!=null?"has":"has not") + " a pasport, cash=" + cash + ", town=" + (town==null?"not in town":town.getName());
		for(Imigrant fr:friends) {
			info += " friend:"+fr.type;
		}
		return info;
	}
	
}
