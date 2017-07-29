package court.classes.law_positions;

import court.classes.Validation;
import court.classes.action_citizens.Citizen;

public abstract class Jurist extends Citizen {
	protected int yearsService;
	protected int caseCount;
	
	protected Jurist(String name, String adress, int age, int yearsService, int actionCount) {
		super(name,adress,age);
		yearsService = Validation.returnBiggerThanNumber(yearsService, 0);
		actionCount = Validation.returnBiggerThanNumber(actionCount, 0);
		this.yearsService = yearsService;
		this.caseCount = actionCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jurist) {
			Jurist j = (Jurist) obj;
			boolean isEqual = this.name.equals(j.getName());
			isEqual = isEqual && this.yearsService == j.getYearsService();
			isEqual = isEqual && this.caseCount == j.getCaseCount();
			return isEqual;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Name:%s Years in service:%d Cases:%d ", this.name, this.yearsService,
				this.caseCount);
	}
	public abstract String getPosition();

	public String getName() {
		return name;
	}

	public int getYearsService() {
		return yearsService;
	}

	public int getCaseCount() {
		return caseCount;
	}

	public void addCase() {
		this.caseCount++;
	}

	public void addYearsService() {
		this.yearsService++;
	}
}
