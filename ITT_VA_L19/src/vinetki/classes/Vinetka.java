package vinetki.classes;

import java.util.Comparator;

public class Vinetka implements Comparator<Vinetka> {
	static String[] validnosti = { "day", "month", "year" };

	public String getValidnost() {
		return validnost;
	}

	static String[] colors = { "green", "red", "blue" };
	static String[] types = { "car", "bus", "truck" };
	String dataIzdavane;
	String validnost;
	String color;
	int price;

	String type;
	int mnojitel;

	Vinetka(String dataIzdavane, String validnost, String color) {
		this.dataIzdavane = dataIzdavane;
		this.validnost = validnost;
		this.color = color;
		opredeliCena();
	}

	Vinetka(String validnost, String color) {
		this.color = color;
		this.validnost = validnost;
	}

	private int opredeliType() {
		int n = 0;
		for (int i = 0; i < colors.length; i++) {
			if (colors[i].equals(color)) {
				n = i;
				break;
			}
		}
		type = types[n];
		if (n == 0) {
			price = 5;
		} else if (n == 1) {
			price = 7;
		} else {
			price = 9;
		}
		return n;
	}

	private void opredeliCena() {
		opredeliType();
		int validnostN = 0;
		for (int i = 0; i < validnosti.length; i++) {
			if (validnosti[i].equals(validnost)) {
				validnostN = i;
				break;
			}
		}
		mnojitel = 1;
		if (validnostN == 1) {
			mnojitel = 10;
		} else if (validnostN == 2) {
			mnojitel = 60;
		}
		price *= mnojitel;
	}

	static Vinetka generiraiVinetka(String date) {
		return new Vinetka(date, Vinetka.validnosti[Rnd.rnd(0, Vinetka.validnosti.length)],
				Vinetka.colors[Rnd.rnd(0, Vinetka.colors.length)]);
	}

	@Override
	public String toString() {
		return String.format("Color:%s(%dlv)", color, price);
	}

	public void lepniNaStykloto(Vehicle vehicle) {
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int compare(Vinetka o1, Vinetka o2) {
		return o2.price - o1.price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vinetka) {
			Vinetka v = (Vinetka) obj;
			return this.color.equals(v.color) && this.validnost.equals(v.validnost);
		}
		return false;
	}
}
