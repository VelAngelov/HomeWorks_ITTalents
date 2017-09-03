package torti.classes;

import java.util.Random;

public class KorporativenKlient extends Klient {
	private double otstypka;

	public KorporativenKlient(String name, String telNumber, double cash, double otstypka, double bakshih) {
		super(name, telNumber, cash, "Korporativen", bakshih);
		this.otstypka = otstypka;
		this.bakshish = bakshih;
	}

	@Override
	protected boolean platiZaPorychka(Porychka p) {
		double cena = p.getCena();
		double b = cena * super.bakshish;
		cena = cena * (1 - otstypka);
		return platiZaPorychka(p, cena, b);
	}

	@Override
	public void poruchaiTorti(Sladkarnica sladkarnica) {
		super.poruchaiTorti(sladkarnica, 3 + new Random().nextInt(3));
	}

}
