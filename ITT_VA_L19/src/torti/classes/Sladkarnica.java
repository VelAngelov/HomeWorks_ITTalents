package torti.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sladkarnica {
	private String name;
	private String telNumber;
	private String adress;
	private double cash;
	private ArrayList<Torta> torti;
	private ArrayList<Dostavchik> dostavchici;
	private ArrayList<Torta> prodadeniTorti;

	public Sladkarnica(String name, String telNumber, String adress) {
		this.name = name;
		this.telNumber = telNumber;
		this.adress = adress;
		this.dostavchici = new ArrayList<Dostavchik>();
		this.torti = new ArrayList<Torta>();
		this.prodadeniTorti = new ArrayList<Torta>();
	}

	public void generateDostavchici(int broi) {
		Dostavchik d;
		for (int i = 0; i < broi; i++) {
			d = new Dostavchik("Dostavchik" + (i + 1), "08955332" + i / 10 + i % 10);
			d.setSladcarnica(this);
			this.dostavchici.add(d);
		}
	}

	public void generateTorti(int broi) {
		Torta t;
		for (int i = 0; i < broi; i++) {
			t = Torta.generateTorta();
			this.torti.add(t);
		}
	}

	public void izpylniPorychki() {
		for (Dostavchik d : dostavchici) {
			d.izpylniPorychki();
		}
	}

	public Dostavchik getRandomDostavchik() {
		return this.dostavchici.get(new Random().nextInt(dostavchici.size()));
	}

	public boolean containsTorta(Torta t) {
		return this.torti.contains(t);
	}

	ArrayList<Torta> getTorti() {
		return torti;
	}

	void platiSmetka(double cena) {
		this.cash += cena;
	}

	void removeTorti(ArrayList<Torta> torti) {
		for (Torta t : torti) {
			this.torti.remove(t);
		}
	}

	public void printTorti() {
		if (torti == null || torti.isEmpty()) {
			System.out.println("nqma nalichni torti!");
			return;
		}
		StringBuilder sb = new StringBuilder("Sydyrjanie:\n");
		Collections.sort(torti);
		int count = 1;
		for (Torta t : torti) {
			sb.append(Integer.toString(count++) + t);
		}
		System.out.println(sb);
	}

	public double getCash() {
		return cash;
	}

	public void printDostavchik() {
		if (dostavchici != null && !dostavchici.isEmpty()) {
			Collections.sort(dostavchici, new Dostavchik("Unknown", "none"));
			StringBuilder sb = new StringBuilder("Dostavchici:\n");
			for (Dostavchik d : dostavchici) {
				sb.append(d);
			}
			System.out.println(sb);
		}
	}

	public void addProdadeniTorti(ArrayList<Torta> torti2) {
		this.prodadeniTorti.addAll(torti2);
	}

	public void printNaiProdavanaTorta() {
		Torta t;
		int broi;
		Torta naiProdavana = null;
		int maxBroi = 0;
		for (int i = 0; i < prodadeniTorti.size() - 1; i++) {
			t = prodadeniTorti.get(i);
			broi = 1;
			for (int j = i + 1; j < prodadeniTorti.size(); j++) {
				if (prodadeniTorti.get(j).equals(t)) {
					broi++;
				}
			}
			if (broi > maxBroi) {
				naiProdavana = t;
				maxBroi = broi;
			}
		}
		System.out.println("nai prodavana torta(" + maxBroi + "broq):" + naiProdavana);
	}

	public void topDostavchik() {
		int broiPorychki = 0;
		Dostavchik top = null;
		for (Dostavchik d : dostavchici) {
			if (d.getBroiPorychki() > broiPorychki) {
				top = d;
				broiPorychki = d.getBroiPorychki();
			}
		}
		System.out.println(top + " izpylneni porychki:" + top.getBroiPorychki());
	}

}
