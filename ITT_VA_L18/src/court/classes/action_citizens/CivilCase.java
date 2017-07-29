package court.classes.action_citizens;

import court.classes.law_positions.*;
import java.util.Random;

public class CivilCase extends Case {
	private static String[] questionsFromAccuserLoyer = { "Question...", "Question...", "Question...", "Question...",
			"Question..." };
	private static String[] questionsFromAccusedLoyer = { "Question...", "Question...", "Question...", "Question...",
			"Question..." };
	private static String[] answersFromWitnesses = { "Answer...", "Answer...", "Answer...", "Answer...", "Answer..." };
	private static String[] answersFromAccused = { "Answer...", "Answer...", "Answer...", "Answer...", "Answer..." };

	public CivilCase(Citizen accuser, Citizen accused, Judge judge) {
		super(accuser, accused, judge);
	}

	@Override
	public void perform() {
		if (!checkBeforeStartCase()) {
			return;
		}
		// Делото започва:
		addCaseToJurists();

		String question;
		String answer;

		// Адвокати на обвинителя:
		for (Jurist j : super.accuser.getLoyersWithoutRemove()) {
			Loyer l = (Loyer) j;
			// ask accused:
			for (int i = 0; i < 3 && i < questionsFromAccuserLoyer.length; i++) {
				question = citizenToCitizenAskQuestion(l, super.accused, l.askQuestion(questionsFromAccuserLoyer[i]));
				answer = citizenToCitizenReceiveAns(super.accused, l, answersFromAccused[i]);
				printString(question, answer);
			}
			// ask witnesses
			for (Citizen w : super.witnesses) {
				for (int i = 0; i < 2 && i < questionsFromAccuserLoyer.length; i++) {
					question = citizenToCitizenAskQuestion(l, w, l.askQuestion(questionsFromAccuserLoyer[i]));
					answer = citizenToCitizenReceiveAns(w, l, answersFromWitnesses[i]);
					printString(question, answer);
				}
			}
		}
		// Адвокати на обвинения:
		for (Jurist j : super.accused.getLoyersWithoutRemove()) {
			Loyer l = (Loyer) j;
			// ask witnesses
			for (Citizen w : super.witnesses) {
				for (int i = 0; i < 5 && i < questionsFromAccusedLoyer.length; i++) {
					question = citizenToCitizenAskQuestion(l, w, l.askQuestion(questionsFromAccusedLoyer[i]));
					answer = citizenToCitizenReceiveAns(w, l, answersFromWitnesses[i]);
					printString(question, answer);
				}
			}
		}
		// Резултат от гласуване и присъда:
		boolean isGuilty = votingIsGuilty();
		if (isGuilty) {
			System.out.printf("%s(judge) deside to give %d years gail for %s\n", super.judge.getName(),
					3 + new Random().nextInt(41 - 3), super.accused.getName());
		} else {
			System.out.printf("%s(judge) deside %s is not guilty!\n", super.judge.getName(), super.accused.getName());
		}
		System.out.printf("%s: Case is closed!\n============Case is finished============\n", judge.getName());
		super.isClosed=true;
	}

	@Override
	public String getTypeOfAction() {
		return "Civil Case";
	}

}
