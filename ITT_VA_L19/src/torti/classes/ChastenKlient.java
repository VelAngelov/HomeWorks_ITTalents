package torti.classes;

import java.util.Random;

public class ChastenKlient extends Klient {
	private int broiValcheri;
	private double cashFromValcheri;

	public ChastenKlient(String name, String telNumber, double cash, int broiValcheri, int valueOfValcher,
			double bakshih) {
		super(name, telNumber, cash, "Chasten", bakshih);
		this.broiValcheri = broiValcheri;
		this.cashFromValcheri = valueOfValcher * broiValcheri;
		this.bakshish = bakshih;
	}

	@Override
	protected boolean platiZaPorychka(Porychka p) {
		double cena = p.getCena();
		double b = cena * super.bakshish;
		if (cena > cashFromValcheri) {
			cena -= cashFromValcheri;
			cashFromValcheri = 0;
		} else {
			cena = 0;
			cashFromValcheri -= cena;
		}
		return super.platiZaPorychka(p, cena, b);
	}

	@Override
	public void poruchaiTorti(Sladkarnica sladkarnica) {
		super.poruchaiTorti(sladkarnica, 1 + new Random().nextInt(3));
	}
}
