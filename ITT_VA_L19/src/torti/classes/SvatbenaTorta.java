package torti.classes;

public class SvatbenaTorta extends Torta {
	private int etaji;

	SvatbenaTorta(int vid, String opisanie, double cena, int parcheta, int etaji) {
		super("Svatbena", vid, opisanie, cena, parcheta);
		this.etaji = etaji;
	}

}
