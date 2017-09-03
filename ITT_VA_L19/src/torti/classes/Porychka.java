package torti.classes;

import java.util.ArrayList;

public class Porychka {
	private Klient klient;
	private String adres;
	private String dataIChas;
	private ArrayList<Torta> torti;
	private double cena;
	private Dostavchik dostavchik;
	private Sladkarnica sladkarnica;

	public Porychka(Klient klient, String adres, String dataIChas, ArrayList<Torta> torti, Dostavchik dostavchik) {
		this.klient = klient;
		this.adres = adres;
		this.dataIChas = dataIChas;
		this.torti = torti;
		this.dostavchik = dostavchik;
		calculatePrice();
	}

	private void calculatePrice() {
		cena = 0;
		if (torti != null && !torti.isEmpty()) {
			for (Torta t : torti) {
				cena += t.getCena();
			}
		}
	}

	public double getCena() {
		calculatePrice();
		return cena;
	}

	void setCena(double cena) {
		this.cena = cena;
	}

	Klient getKlient() {
		return klient;
	}

	ArrayList<Torta> getTorti() {
		return torti;
	}

	public void setDostavchik(Dostavchik dostavchik) {
		this.dostavchik = dostavchik;
		this.sladkarnica = dostavchik.getSladcarnica();
	}

	Dostavchik getDostavchik() {
		return dostavchik;
	}

	Sladkarnica getSladkarnica() {
		return sladkarnica;
	}

}
