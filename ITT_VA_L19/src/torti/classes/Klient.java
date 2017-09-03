package torti.classes;

import java.util.ArrayList;
import java.util.Random;

public abstract class Klient {
	public static String[] TYPES = { "Chasten", "Korporativen" };
	private String name;
	private double cash;
	private String telNumber;
	private String type;
	private ArrayList<Torta> torti;
	protected double bakshish;

	public Klient(String name, String telNumber, double cash, String type, double bakshish) {
		this.name = name;
		this.telNumber = telNumber;
		this.cash = cash;
		this.type = type;
		this.torti = new ArrayList<Torta>();
	}

	public static ArrayList<Klient> generateKlients(int korporativni, int chastni) {
		ArrayList<Klient> klienti = new ArrayList<Klient>();
		Klient k;
		for (int i = 0; i < korporativni; i++) {
			k = new KorporativenKlient("KorporativenKlient" + i, "088323654" + i % 10, 5000, Math.random() * 0.1 + 0.05,
					0.05);
			klienti.add(k);
		}
		for (int i = 0; i < chastni; i++) {
			k = new ChastenKlient("ChastenKlient" + i, "088453654" + i % 10, 5000, 1 + new Random().nextInt(3),
					10 + new Random().nextInt(21), 0.02);
			klienti.add(k);
		}
		return klienti;
	}

	public abstract void poruchaiTorti(Sladkarnica sladkarnica);

	protected void poruchaiTorti(Sladkarnica sladkarnica, int count) {
		// sladkarnicata dava edin dostavchik
		Dostavchik d = sladkarnica.getRandomDostavchik();
		// zarejdame porychka
		ArrayList<Torta> torti = new ArrayList<Torta>();
		// opredelqme pyrvonachalnata cena
		double cena = 0;
		Torta t;
		for (int i = 0; i < count; i++) {
			t = Torta.generateTorta();
			torti.add(t);
			cena += t.getCena();
		}
		if (cena > cash) {
			System.out.println("Sorry " + name + " you have not enough money!");
			return;
		}
		Porychka p = new Porychka(this, "adres", "dnes", torti, d);
		d.addPorychka(p);
	}

	public void addTorti(ArrayList<Torta> torti) {
		this.torti.addAll(torti);
	}

	protected abstract boolean platiZaPorychka(Porychka p);

	protected boolean platiZaPorychka(Porychka p, double cena, double bakshish) {
		if (cash > cena + bakshish) {
			cash -= cena + bakshish;
			p.getSladkarnica().platiSmetka(cena);
			p.getDostavchik().platiBakshih(bakshish);
			this.torti.addAll(p.getTorti());
			p.getSladkarnica().removeTorti(p.getTorti());
			p.getSladkarnica().addProdadeniTorti(p.getTorti());
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public double getCash() {
		return cash;
	}

	@Override
	public String toString() {
		return String.format("Name:%s ,Type:%s ,TelNumber:%s,cash:%.2f", name, type, telNumber, cash);
	}
}
