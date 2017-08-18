package imigrants.classes;

public class Cop extends Policeman {

	public Cop(String name, Town town) {
		super(name, town);
	}

	@Override
	public boolean checkImigrant(Imigrant i) {
		if(Validator.rnd(0, 100)<50) {
			return super.checkImigrant(i);
		}
		return super.letImigrantGoIn(i);
	}
}
