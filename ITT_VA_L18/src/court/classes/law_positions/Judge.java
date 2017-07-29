package court.classes.law_positions;

import court.classes.Validation;

public class Judge extends Jurist implements ILawPosition {
	public Judge(String name,String adress, int age, int yearsService, int actionCount) {
		super(name,adress,age, yearsService, actionCount);
		if (yearsService < 5) {
			yearsService = Validation.returnBiggerThanNumber(yearsService, 5);
			super.yearsService = yearsService;
		}
	}
	@Override
	public String toString() {
		String s = super.toString();
		return String.format("%sPosition:Judge \n",s);
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
		return "Judge";
	}

}
