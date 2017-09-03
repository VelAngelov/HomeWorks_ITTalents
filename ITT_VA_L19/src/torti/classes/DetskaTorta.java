package torti.classes;

public class DetskaTorta extends Torta {
	private String dete;

	DetskaTorta(int vid, String opisanie, double cena, int parcheta, String dete) {
		super("Detska", vid, opisanie, cena, parcheta);
		this.dete = dete;
	}

}
