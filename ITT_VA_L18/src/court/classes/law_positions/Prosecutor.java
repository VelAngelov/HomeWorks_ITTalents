package court.classes.law_positions;

import court.classes.Validation;

public class Prosecutor extends Jurist implements ILawPosition {
	public Prosecutor(String name, String adress, int age, int yearsService, int actionCount) {
		super(name, adress, age, yearsService, actionCount);
		if (yearsService < 10) {
			System.out.printf("%s have not enough years in service to become a prosecutor!\n", super.name);
			yearsService = Validation.returnBiggerThanNumber(yearsService, 10);
			super.yearsService = yearsService;
		}
	}

	@Override
	public String toString() {
		String s = super.toString();
		return String.format("%sPosition:Prosecutor \n", s);
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
		return "Prosecutor";
	}

}
