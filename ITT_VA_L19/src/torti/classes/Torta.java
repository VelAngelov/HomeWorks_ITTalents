package torti.classes;

import java.util.Random;

public abstract class Torta implements Comparable<Torta> {
	public static String[] TYPES = { "Standartna", "Specialna", "Svatbena", "Detska" };
	String[] vidove;
	private String name;
	private String opisanie;
	private double cena;
	private int parcheta;
	private String type;

	Torta(String type, int vid, String opisanie, double cena, int parcheta) {
		this.type = type;
		this.opisanie = opisanie;
		this.cena = cena;
		this.parcheta = parcheta;
		switch (type) {
		case "Standartna":
			this.vidove = new String[4];
			vidove[0] = "biskvitena";
			vidove[1] = "eklerova";
			vidove[2] = "eklerova";
			vidove[3] = "eklerova";
			break;
		case "Specialna":
			this.vidove = new String[3];
			vidove[0] = "iubileina";
			vidove[1] = "firmena";
			vidove[2] = "reklamna";
			break;
		case "Svatbena":
			this.vidove = new String[3];
			vidove[0] = "golqma";
			vidove[1] = "malka";
			vidove[2] = "sredna";
			break;
		case "Detska":
			this.vidove = new String[3];
			vidove[0] = "za rojden den";
			vidove[1] = "za kryshtane";
			vidove[2] = "za proshtapulnik";
			break;
		default:
			vidove = null;
		}
		this.name = vidove[vid];
	}

	public double getCena() {
		return cena;
	}

	public static Torta generateTorta() {
		int chance;
		Torta t;
		chance = new Random().nextInt(4);
		switch (chance) {
		case 1:
			t = new StandartnaTorta(new Random().nextInt(4), "Sydyrjanie....", 30, 9, new Random().nextBoolean());
			break;
		case 2:
			t = new SpecialnaTorta(new Random().nextInt(3), "Sydyrjanie....", 50, 16, "nqkakvo sybitie");
			break;
		case 3:
			t = new SvatbenaTorta(new Random().nextInt(3), "Sydyrjanie....", 150, 50, 2 + new Random().nextInt(2));
			break;
		default:
			t = new DetskaTorta(new Random().nextInt(3), "Sydyrjanie....", 15, 9, "nqkakvo dete");
			break;
		}
		return t;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Torta) {
			Torta t = (Torta) obj;
			return this.type.equals(t.type) && this.name.equals(t.name);
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s %s, Opisanie: %s ,Cena:%.2f,Broi parcheta:%d\n", type, name, opisanie, cena, parcheta);
	}

	String getType() {
		return type;
	}

	@Override
	public int compareTo(Torta o) {
		int value1 = this.type.compareTo(o.type);
		if (value1 != 0) {
			return value1;
		}
		int value2 = this.name.compareTo(o.name);
		return value2;
	}
}
