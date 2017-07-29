package court;

import court.classes.Court;
import court.classes.action_citizens.*;
import court.classes.law_positions.*;

public class CourtDemo {
	/*
	 * В съставянето на класовете е прието, че един юрист е същият като друг,
	 * който има същото име , години стаж и дела. Това приемане не е съвършенно,
	 * защото трудно се проверява дали човека, който го съдят не е самият юрист.
	 * За да се избегне това е необходимо в Citizen инстанцирането на Citizen да
	 * имаме идентификационен номер ,по който да различаваме обектите един от
	 * друг(ЕГН). Това не е реализирано ,понеже не се изисиква от задачата!
	 */
	/*
	 * Прието е че обвиняващия първи си наема адвокати,после се добавя съдия и
	 * обвинения после търси.Т.е. не може да имаме обвиняващ без поне един
	 * адвокат!
	 */
	public static void main(String[] args) {
		// Generate DB:
		Judge[] sudii = generateJudges();
		Prosecutor[] prokurori = generateProsecutors();
		Loyer[] loyers = generateLoyers();
		Jury[] juri = generateJury();
		Citizen[] accuser = generateAccusers();
		Citizen[] accused = generateAccused();
		Citizen[] witness = generateWitnesses();

		// create Court:
		Court sud = new Court("Veliko Tyrnovo", "gr.Veliko Tyrnovo ul.Car Ivan Shishman 58", sudii[0], prokurori[0],
				loyers[0], loyers[1]);
		// Import Jurists:
		sud.addJurist(sudii);
		sud.addJurist(prokurori);
		sud.addJurist(loyers);
		sud.addJurist(juri);
		// Generate Cases:
		CivilCase[] civilCases = generateRndCivilCases(accuser, accused, sudii, witness, loyers);
		CriminalCase[] criminalCases = generateRndCriminalCases(prokurori, accused, sudii, witness, loyers, juri);
		// register Cases:
		for (int i = 0; i < 3; i++) {
			sud.addCase(civilCases[i]);
			sud.addCase(criminalCases[i]);
		}
		// print info:
		System.out.println(sud);
		// excute Cases:
		for (int i = 0; i < 3; i++) {
			if (civilCases[i].checkBeforeStartCase()) {
				System.out.println(civilCases[i]);
				civilCases[i].perform();
			}
			if (criminalCases[i].checkBeforeStartCase()) {
				System.out.println(criminalCases[i]);
				criminalCases[i].perform();
			}
		}
		// print info:
		 System.out.println(sud);
		 //test:
			for (int i = 0; i < 3; i++) {
				if (civilCases[i].checkBeforeStartCase()) {
					System.out.println(civilCases[i]);
					civilCases[i].perform();
				}
				if (criminalCases[i].checkBeforeStartCase()) {
					System.out.println(criminalCases[i]);
					criminalCases[i].perform();
				}
			}
	}

	public static int rnd(int n) {
		return (int) (Math.random() * n);
	}

	public static Judge[] generateJudges() {
		Judge[] judges = new Judge[3];
		judges[0] = new Judge("Ivan Peter Petkov", "Veliko Tyrnovo", 32, 10, 23);
		judges[1] = new Judge("Dean Liubomirov Atanasov", "Silistra", 32, 10, 23);
		judges[2] = new Judge("Boyan Dimitrov Anastasov", "Veliko Tyrnovo", 32, 10, 23);
		return judges;
	}

	public static Prosecutor[] generateProsecutors() {
		Prosecutor[] prokurori = new Prosecutor[2];
		prokurori[0] = new Prosecutor("Petyr Ivanov Stoyanov", "Sofiq", 45, 15, 30);
		prokurori[1] = new Prosecutor("Lozko Antonov Lozev", "Burgas", 38, 10, 25);
		return prokurori;
	}

	public static Loyer[] generateLoyers() {
		Loyer[] loyers = new Loyer[5];
		loyers[0] = new Loyer("Toni Conev Conev", "Haskovo", 30, 8, 15);
		loyers[1] = new Loyer("Dimityr Dimitrov Stoyanov", "Pernik", 32, 5, 10);
		loyers[2] = new Loyer("Maria Marinova Marinovana", "Sliven", 45, 6, 15);
		loyers[3] = new Loyer("Vasil Stoyanov Kiliov", "Smolqn", 32, 7, 16);
		loyers[4] = new Loyer("Petko Marinov Kytov", "Primorsko", 45, 7, 15);
		return loyers;
	}

	public static Jury[] generateJury() {
		Jury[] juri = new Jury[10];
		juri[0] = new Jury("Diana Momchilova Koteva", "Pazardjik", 45, 6, 15);
		juri[1] = new Jury("Slaveq Hristova Hristoskova", "Stara Zagora", 18, 1, 2);
		juri[2] = new Jury("Ekaterina Hristova Angelova", "Burgas", 26, 2, 5);
		juri[3] = new Jury("Mariq Ivanova Lalova", "s.Smilqn", 19, 1, 6);
		juri[4] = new Jury("Aleksandyr Dimitrov Mitroshanov", "Kozlodui", 26, 3, 12);
		juri[5] = new Jury("Evgenij Manev Manolov", "Trqvna", 40, 5, 10);
		juri[6] = new Jury("Dianka Pertova Hristova", "Pazardjik", 38, 1, 12);
		juri[7] = new Jury("Liubov Mineva Petrova", "Stara Zagora", 29, 4, 15);
		juri[8] = new Jury("Silviq Liubomirova Peeva", "Smolqn", 35, 6, 8);
		juri[9] = new Jury("Ivanina Hristova Dimcheva", "Haskovo", 23, 1, 12);
		return juri;
	}

	public static Citizen[] generateAccusers() {
		Citizen[] accuser = new Citizen[5];
		accuser[0] = new Citizen("Velichko Zvezdalinov Angelov", "Zlatograd", 26);
		accuser[1] = new Citizen("Petko Petkov Petkov", "Sofiq", 35);
		accuser[2] = new Citizen("Ivan Ivanov Ivanov", "Sofiq", 35);
		accuser[3] = new Citizen("Dako Dakov Dakov", "Sofiq", 35);
		accuser[4] = new Citizen("Petyr Petrov Petrov", "Sofiq", 35);
		return accuser;
	}

	public static Citizen[] generateAccused() {
		Citizen[] accused = new Citizen[5];
		accused[0] = new Citizen("Mariika Kraliwa Kradleva", "Sofiq", 26);
		accused[1] = new Citizen("Ubiec Ivanov Petrov", "Sofiq", 65);
		accused[2] = new Citizen("Kradec Lukavov Lyjev", "Sofiq", 43);
		accused[3] = new Citizen("Murder Ivanov Slavov", "Sofiq", 35);
		accused[4] = new Citizen("Malka Kradliva Ivanova ", "Sofiq", 29);
		return accused;
	}

	public static Citizen[] generateWitnesses() {
		Citizen[] witness = new Citizen[10];
		witness[0] = new Citizen("Svidetel Svidetel Svidetel", "Sofiq", 23);
		witness[1] = new Citizen("Anton Ivanov Atanasov", "Sofiq", 23);
		witness[2] = new Citizen("Slavi Vladimirov Anastasov", "Sofiq", 23);
		witness[3] = new Citizen("Mihail Petrov Peev", "Sofiq", 23);
		witness[4] = new Citizen("Stanimir Hristo Petkov", "Sofiq", 23);
		witness[5] = new Citizen("Hristo Ginev Milev", "Sofiq", 23);
		witness[6] = new Citizen("Diana Ivanova Slaveeva", "Sofiq", 23);
		witness[7] = new Citizen("Aleksandra Todorova Dimitrova", "Sofiq", 23);
		witness[8] = new Citizen("Milena Ivanova Ivanova", "Sofiq", 23);
		witness[9] = new Citizen("Zlatimir Zarkov Zaikov", "Sofiq", 23);
		return witness;
	}

	public static CivilCase[] generateRndCivilCases(Citizen[] accusers, Citizen[] accused, Judge[] sudii,
			Citizen[] witness, Loyer[] loyers) {
		CivilCase[] civilCases = new CivilCase[3];
		Citizen accuser;
		Citizen defender;
		Judge judge;
		Citizen w;
		for (int i = 0; i < 3; i++) {
			accuser = accusers[rnd(accusers.length)];
			if (!accuser.hasLoyer()) {
				setLoyerToCitizen(accuser, loyers);
			}
			defender = accused[rnd(accused.length)];
			if (!defender.hasLoyer()) {
				setLoyerToCitizen(defender, loyers);
			}
			verifyLoyers(accuser, defender, loyers);
			judge = sudii[rnd(sudii.length)];
			civilCases[i] = new CivilCase(accuser, defender, judge);
			int numberWitnesses = rnd(4);
			for (int j = 0; j < numberWitnesses; j++) {
				w = witness[rnd(witness.length)];
				civilCases[i].addWitness(w);
			}
		}
		return civilCases;
	}

	public static void setLoyerToCitizen(Citizen citizen, Loyer[] loyers) {
		Loyer loyer;
		if (!citizen.hasLoyer()) {
			loyer = loyers[rnd(loyers.length)];
			if (!citizen.addLoyer(loyer)) {
				setLoyerToCitizen(citizen, loyers);
			}
		}
	}

	public static boolean verifyLoyers(Citizen acc, Citizen def, Loyer[] loyers) {

		Jurist[] forAcc = acc.getLoyersWithoutRemove();
		if (forAcc.equals(5)) {
			acc.removeMyLoyer();
		}
		for (Jurist a : forAcc) {
			if (def.hasJurist(a)) {
				def.removeLoyer(a);
			}
		}
		if (def.hasLoyer()) {
			return true;
		} else {
			setLoyerToCitizen(def, loyers);
			return verifyLoyers(acc, def, loyers);
		}
	}

	public static void setJuristsToCriminalCase(CriminalCase theCase, Jurist... jurists) {
		for (Jurist j : jurists) {
			theCase.addJurist(j);
		}
	}

	public static CriminalCase[] generateRndCriminalCases(Prosecutor[] prosecutors, Citizen[] accused, Judge[] sudii,
			Citizen[] witness, Loyer[] loyers, Jury[] jurita) {
		CriminalCase[] criminalCases = new CriminalCase[3];
		Citizen defender;
		Prosecutor prosecutor;
		Judge judge;
		Citizen w;
		for (int i = 0; i < 3; i++) {
			prosecutor = prosecutors[rnd(prosecutors.length)];
			defender = accused[rnd(accused.length)];
			if (!defender.hasLoyer()) {
				setLoyerToCitizen(defender, loyers);
			}
			judge = sudii[rnd(sudii.length)];
			criminalCases[i] = new CriminalCase(prosecutor, defender, judge);
			int numberWitnesses = rnd(4);
			for (int j = 0; j < numberWitnesses; j++) {
				w = witness[rnd(witness.length)];
				criminalCases[i].addWitness(w);
			}
			setJuristsToCriminalCase(criminalCases[i], jurita);
		}
		return criminalCases;
	}
}