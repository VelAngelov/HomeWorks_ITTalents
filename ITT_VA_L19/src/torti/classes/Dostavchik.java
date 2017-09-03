package torti.classes;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Dostavchik implements Comparator<Dostavchik> {
	private String name;
	private String telNumber;
	private Queue<Porychka> porychki;
	private double cash;
	private Sladkarnica sladcarnica;
	private int broiPorychki;
	public Dostavchik(String name, String telNumber) {
		this.name = name;
		this.telNumber = telNumber;
		this.porychki = new LinkedList<Porychka>();
	}

	public void setSladcarnica(Sladkarnica sladcarnica) {
		this.sladcarnica = sladcarnica;
	}

	public void addPorychka(Porychka p) {
		this.porychki.add(p);
		p.setDostavchik(this);
	}

	private void izpylniPoruchka() {
		if (this.porychki.isEmpty()) {
			return;
		}
		// mahame porychkata:
		Porychka p = this.porychki.poll();
		// ostavat samo nalichnite torti;
		p.getTorti().retainAll(sladcarnica.getTorti());
		if ((p.getTorti().isEmpty() && p.getTorti() == null) || !p.getKlient().platiZaPorychka(p)) {
			System.out.println(name + ":Sorry " + p.getKlient().getName() + " za teb nqma torti!");
		} else {
			System.out.println(name + " uspeshno izpylni porychka!");
			broiPorychki++;
		}
	}

	public void izpylniPorychki() {
		while (!porychki.isEmpty()) {
			izpylniPoruchka();
		}
	}

	public void platiBakshih(double bakshish) {
		cash += bakshish;
	}

	Sladkarnica getSladcarnica() {
		return sladcarnica;
	}

	@Override
	public int compare(Dostavchik o1, Dostavchik o2) {
		return (int) (100 * (-o1.cash + o2.cash));
	}

	@Override
	public String toString() {
		return String.format("Name:%s, TelNumber:%s, Cash:%.2f\n", name, telNumber, cash);
	}
	int getBroiPorychki() {
		return broiPorychki;
	}
}
