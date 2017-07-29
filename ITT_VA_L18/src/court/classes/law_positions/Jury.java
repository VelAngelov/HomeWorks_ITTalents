package court.classes.law_positions;

public class Jury extends Jurist implements ILawPosition {
	public Jury(String name, String adress, int age, int yearsService, int actionCount) {
		super(name, adress, age, yearsService, actionCount);
	}

	@Override
	public String toString() {
		String s = super.toString();
		return String.format("%sPosition:Jury \n", s);
	}

	@Override
	public String askQuestion(String question) {
		return question;
	}

	@Override
	public void getAnswer(String ans) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPosition() {
		return "Jury";
	}

}
