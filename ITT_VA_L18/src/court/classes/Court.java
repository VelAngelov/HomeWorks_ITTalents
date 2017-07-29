package court.classes;

import court.classes.action_citizens.Case;
import court.classes.law_positions.Judge;
import court.classes.law_positions.Jurist;
import court.classes.law_positions.Jury;
import court.classes.law_positions.Loyer;
import court.classes.law_positions.Prosecutor;
import court.classes.lists.CaseList;
import court.classes.lists.JuristList;

public class Court {
	private String name;
	private String adress;
	private JuristList jurists;
	private CaseList cases;

	public Court(String name, String adress, Judge judge, Prosecutor prosecutor, Loyer loyer1, Loyer loyer2) {
		name = Validation.validateName(name);
		adress = Validation.validateString(adress);
		this.name = name;
		this.adress = adress;
		jurists = new JuristList();
		cases = new CaseList();
		if (judge == null || prosecutor == null || loyer1 == null || loyer2 == null || loyer1.equals(loyer2)) {
			throw new IllegalArgumentException("Invalid jurists entered!");
		}
		jurists.add(judge);
		jurists.add(prosecutor);
		jurists.add(loyer1);
		jurists.add(loyer2);
	}

	public boolean addCase(Case newCase) {
		if (newCase.getJudge() == null) {
			System.out.println("You can not register case without Judge!");
			newCase.setClosed(true);
			return false;
		} else if (!newCase.getAccused().hasLoyer()) {
			System.out.println("You can not register case ,because accused have no loyer!");
			newCase.setClosed(true);
			return false;
		} else if (!newCase.getAccuser().hasLoyer()) {
			if (!(newCase.getAccuser() instanceof Prosecutor)) {
				System.out.println("You can not register case ,because accuser have no loyer!");
				newCase.setClosed(true);
				return false;
			}
		}
		return this.cases.add(newCase);
	}

	public void addJurist(Jurist... jurists) {
		for (Jurist j : jurists) {
			this.jurists.add(j);
		}
	}

	public boolean containsJurist(Jurist jurist) {
		return this.jurists.contains(jurist);
	}

	public boolean containsCase(Case oldCase) {
		return this.jurists.contains(oldCase);
	}

	public Jurist getJuristByName(String name) {
		name = Validation.validateName(name);
		for (Jurist j : jurists) {
			if (j.getName().equals(name)) {
				return j;
			}
		}
		System.out.printf("Jurist %s not found!\n", name);
		return null;
	}

	public Case getCaseByNumber(int id) {
		id--;
		Case c = this.cases.get(id);
		if (c == null) {
			System.out.println("Case not found!");
			return null;
		}
		return c;
	}

	public String viewListCases() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (Case c : cases) {
			sb.append("Case " + i++);
			sb.append(c.toString());
		}
		return sb.toString();
	}

	private void sortByNamesJurists() {
		Jurist[] temp = new Jurist[jurists.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = jurists.remove(0);
		}
		Jurist jurist;
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[i].getName().compareTo(temp[j].getName()) > 0) {
					jurist = temp[i];
					temp[i] = temp[j];
					temp[j] = jurist;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			jurists.add(temp[i]);
		}
	}

	@Override
	public String toString() {
		sortByNamesJurists();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Court:%s\nAdress:%s\n", this.name, this.adress));
		sb.append("Judges:\n");
		for (Jurist j : jurists) {
			if (j instanceof Judge) {
				sb.append(String.format("Judge: %s(%d years Service)(%d cases)\n", j.getName(), j.getYearsService(),
						j.getCaseCount()));
			}
		}
		sb.append("Prosecutors:\n");
		for (Jurist j : jurists) {
			if (j instanceof Prosecutor) {
				sb.append(String.format("Prosecutor: %s(%d years Service)(%d cases)\n", j.getName(),
						j.getYearsService(), j.getCaseCount()));
			}
		}
		sb.append("Loyers:\n");
		for (Jurist j : jurists) {
			if (j instanceof Loyer) {
				sb.append(String.format("Loyer: %s(%d years Service)(%d cases)\n", j.getName(), j.getYearsService(),
						j.getCaseCount()));
			}
		}
		sb.append("Jury:\n");
		for (Jurist j : jurists) {
			if (j instanceof Jury) {
				sb.append(String.format("Jury: %s(%d years Service)(%d cases)\n", j.getName(), j.getYearsService(),
						j.getCaseCount()));
			}
		}
		return sb.toString();
	}
}
