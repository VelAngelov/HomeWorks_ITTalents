package torti.classes;

public class SpecialnaTorta extends Torta {
	private String sybitie;

	SpecialnaTorta(int vid, String opisanie, double cena, int parcheta, String sybitie) {
		super("Specialna", vid, opisanie, cena, parcheta);
		this.sybitie = sybitie;
	}

}
