package court.classes.law_positions;

import court.classes.Validation;

public class Loyer extends Jurist implements ILawPosition {
	public Loyer(String name, String adress, int age, int yearsService, int actionCount) {
		super(name, adress, age, yearsService, actionCount);
		if (actionCount < 10) {
			System.err.printf("%s have not enough actions in the active.", super.name);
			actionCount = Validation.returnBiggerThanNumber(actionCount, 10);
			super.caseCount = actionCount;
		}
	}

	@Override
	public String toString() {
		String s = super.toString();
		return String.format("%sPosition:Loyer \n", s);
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
		return "Loyer";
	}

}
