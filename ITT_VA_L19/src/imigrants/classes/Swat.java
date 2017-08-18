package imigrants.classes;

public class Swat extends Policeman {

	public Swat(String name, Town town) {
		super(name, town);
	}

	@Override
	public boolean checkImigrant(Imigrant i) {
		if (Validator.rnd(0, 100) < 90) {
			return super.checkImigrant(i);
		}
		return super.letImigrantGoIn(i);
	}
}
