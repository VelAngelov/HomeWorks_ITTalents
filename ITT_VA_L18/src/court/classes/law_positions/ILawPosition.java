package court.classes.law_positions;

public interface ILawPosition {
	String askQuestion(String qustion);

	void getAnswer(String ans);

	boolean equals(Object o);
}
