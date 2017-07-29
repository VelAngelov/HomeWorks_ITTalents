package court.classes.action_citizens;

import court.classes.law_positions.*;
import court.classes.lists.CizenList;
import court.classes.lists.JuristList;

public abstract class Case {
	private static int id;
	protected Judge judge;
	protected JuristList jurists;
	protected Citizen accuser;
	protected Citizen accused;
	protected CizenList witnesses;
	protected boolean isClosed = false;

	private Case() {
		id++;
	}

	public abstract void perform();

	public abstract String getTypeOfAction();

	public Case(Prosecutor accuser, Citizen accused, Judge judge) {
		this();
		if (accuser != null && accused != null && judge != null) {
			this.accused = accused;
			this.accuser = accuser;
			this.judge = judge;
			this.jurists = new JuristList();
			jurists.add(accuser);
			jurists.add(judge);
			addJurist(accused.getLoyersWithoutRemove());
			this.witnesses = new CizenList();
		} else {
			throw new NullPointerException("This action have no accuser or accused or judge!");
		}
	}

	public Case(Citizen accuser, Citizen accused, Judge judge) {
		this();
		if (accuser != null && accused != null && judge != null) {
			this.accused = accused;
			this.accuser = accuser;
			this.judge = judge;
			this.jurists = new JuristList();
			jurists.add(judge);
			addJurist(accuser.getLoyersWithoutRemove());
			addJurist(accused.getLoyersWithoutRemove());
			this.witnesses = new CizenList();
		} else {
			System.out.println("This action have no accuser or accused or judge!");
			isClosed = true;
		}
	}

	protected void addWitness(Citizen witness) {
		if (!witnesses.add(witness)) {
			System.out.printf("%s is already a witness in this action!", witness.getName());
		}
	}

	public void addWitness(Citizen... witness) {
		for (Citizen w : witness) {
			addWitness(w);
		}
	}

	public boolean addJurist(Jurist... jurists) {
		if (jurists == null || jurists.length == 0) {
			return false;
		}
		for (Jurist j : jurists) {
			if (!this.jurists.add(j)) {
				System.out.printf("Jurist %s is already in this action!\n", j.getName());
				return false;
			}
		}
		return true;
	}

	protected void checkForNewLoyers() {
		Jurist[] loyers;
		loyers = accuser.getLoyersWithoutRemove();
		if (loyers == null || loyers.length == 0) {
			return;
		}
		for (Jurist l : accuser.getLoyersWithoutRemove()) {
			if (!jurists.contains(l)) {
				addJurist(l);
			}
		}
		loyers = accused.getLoyersWithoutRemove();
		if (loyers == null || loyers.length == 0) {
			return;
		}
		for (Jurist l : accused.getLoyersWithoutRemove()) {
			if (!jurists.contains(l)) {
				addJurist(l);
			}
		}
	}

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
		if (accuser.loyers.size() == 0) {
			System.out.printf("%s has no loyer, the case is closed!\n", accuser.getName());
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

	protected void addCaseToJurists() {
		// Добяване на ново дело за всеки юрист
		for (Jurist j : this.jurists) {
			j.addCase();
		}
	}

	protected String citizenToCitizenAskQuestion(Citizen asker, Citizen asked, String question) {
		return String.format("%s asked %s :%s?", asker.getName(), asked.getName(), question);
	}

	protected String citizenToCitizenReceiveAns(Citizen asked, Citizen asker, String ans) {
		return String.format("%s answered to %s :%s.", asked.getName(), asker.getName(), ans);
	}

	protected void printString(String... strings) {
		for (String s : strings) {
			System.out.println(s);
		}
	}

	protected boolean votingIsGuilty() {
		int guiltyVotes = 0;
		int allVotes = jurists.size();
		for (int i = 0; i < allVotes; i++) {
			if (isGuilty()) {
				guiltyVotes++;
			}
		}
		System.out.printf("Votes for guilty:%d/%d\n", guiltyVotes, allVotes);
		return guiltyVotes > allVotes / 2;
	}

	private boolean isGuilty() {
		double chance = 0.5;
		if (Math.random() < chance) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("=======TYPE CASE:%s=======\n", this.getTypeOfAction()));
		sb.append(String.format("Accuser: %s\nAccused: %s\n", accuser.getName(), accused.getName()));
		if (!this.getTypeOfAction().equals("Criminal Case")) {
			sb.append("Accuser loyers: ");
			for (Jurist l : accuser.getLoyersWithoutRemove()) {
				sb.append(l.getName() + "\n");
			}
		} else {
			sb.append("Accuser is prosecutor!\n");
		}
		sb.append("Accused loyers: ");
		for (Jurist l : accused.getLoyersWithoutRemove()) {
			sb.append(l.getName() + "\n");
		}
		sb.append(String.format("Judge: %s\n", this.judge.getName()));
		sb.append("Jury: ");
		for (Jurist j : jurists) {
			if (accused.hasJurist(j) || accuser.hasJurist(j) || j.equals(this.judge)) {
				continue;
			}
			sb.append(String.format("%s %s\n", j.getName(), j.getPosition()));
		}
		sb.append("Witnesses: ");
		for (Citizen w : witnesses) {
			sb.append(String.format("%s\n", w.getName()));
		}
		sb.append("Status:" + (isClosed ? "Closed\n" : "Opened\n"));
		return sb.toString();
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Judge getJudge() {
		return judge;
	}

	public Citizen getAccuser() {
		return accuser;
	}

	public Citizen getAccused() {
		return accused;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Case) {
			return ((Case) obj).getId() == this.getId();
		}
		return false;
	}

}
