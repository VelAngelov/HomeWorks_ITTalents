package torti.classes;

public class StandartnaTorta extends Torta {
	private boolean siropiranaLiE;

	public StandartnaTorta(int vid, String opisanie, double cena, int parcheta, boolean siropiranaLiE) {
		super("Standartna", vid, opisanie, cena, parcheta);
		this.siropiranaLiE = siropiranaLiE;
	}

}
