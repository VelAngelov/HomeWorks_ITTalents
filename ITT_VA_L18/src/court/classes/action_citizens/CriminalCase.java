package court.classes.action_citizens;

import java.util.Random;

import court.classes.law_positions.*;

public class CriminalCase extends Case {
	private static String[] questionsFromAccuser = { "Question...", "Question...", "Question...", "Question...",
			"Question..." };
	private static String[] questionsFromAccusedLoyer = { "Question...", "Question...", "Question...", "Question...",
			"Question..." };
	private static String[] answersFromWitnesses = { "Answer...", "Answer...", "Answer...", "Answer...", "Answer..." };
	private static String[] answersFromAccused = { "Answer...", "Answer...", "Answer...", "Answer...", "Answer..." };

	public CriminalCase(Prosecutor accuser, Citizen accused, Judge judge) {
		super(accuser, accused, judge);
	}

	@Override
	public boolean checkBeforeStartCase() {
		if (isClosed) {
			System.out.println("This case is closed!");
			return false;
		}
		// Проверка за нови адвокати:
		checkForNewLoyers();
		// Проверка за изчезнали хора от делото:
		if (accused == null || accuser == null) {
			System.out.println("Some of the participants in the case escaped in an exotic country.Case is closed");
			isClosed = true;
			return false;
		}
		// Проверка за наличност на адвокати и съдия
		if (accused.loyers.size() == 0) {
			System.out.printf("%s has no loyer, the case is closed!\n", accused.getName());
			isClosed = true;
			return false;
		}
		if (judge == null) {
			System.out.println("The judge died mysteriously!Case is closed!");
			isClosed = true;
			return false;
		}
		return true;
	}

	@Override
	public void perform() {
		if (!checkBeforeStartCase() || !checkForNecesseryJurist()) {
			return;
		}
		// Делото започва:
		addCaseToJurists();

		String question;
		String answer;

		// Прокурора задава въпроси:
		// ask accused:
		Prosecutor prosecutor = (Prosecutor) super.accuser;
		for (int i = 0; i < 5 && i < questionsFromAccuser.length; i++) {
			question = citizenToCitizenAskQuestion(prosecutor, super.accused,
					(prosecutor.askQuestion(questionsFromAccuser[i])));
			answer = citizenToCitizenReceiveAns(super.accused, prosecutor, answersFromAccused[i]);
			printString(question, answer);
		}
		// ask witnesses
		for (Citizen w : super.witnesses) {
			for (int i = 0; i < 5 && i < questionsFromAccuser.length; i++) {
				question = citizenToCitizenAskQuestion(prosecutor, w, prosecutor.askQuestion(questionsFromAccuser[i]));
				answer = citizenToCitizenReceiveAns(w, prosecutor, answersFromWitnesses[i]);
				printString(question, answer);
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
		return "Criminal Case";
	}

	private boolean checkForNecesseryJurist() {
		if (jurists.size() >= 13) {
			return true;
		}
		System.out.printf("There is no enough jurists for this case(%d/%d)!Case is closed!", super.jurists.size(), 13);
		return false;
	}

	public int getNumberOfJurists() {
		return super.jurists.size();
	}

}
