package musicfestival.classes;

import java.util.ArrayList;

public class MusicFestival {
	private String adress;
	private final Time startingTime;
	private ArrayList<Act> acts;

	public MusicFestival(String adress, Time startingTime, Act... acts) {
		this.adress = adress;
		this.startingTime = startingTime;
		this.acts = new ArrayList<Act>();
		for (Act a : acts) {
			this.acts.add(a);
		}
	}

	public void addAct(Act newAct) {
		this.acts.add(newAct);
	}

	public String showProgram() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("The music festival starts at :%s \n" + "The music festival will be at %s.%n",
				startingTime.getTime(), adress));
		Time startTime = new Time(startingTime.getTime());
		for (Act a : this.acts) {
			sb.append(a.getInfo(startTime));
			startTime = new Time(a.endTimeOfAct(startTime));
		}
		return sb.toString();
	}
	public void startFestival() {
		Time startingTime = new Time(this.startingTime.getTime());
		for(Act a : this.acts) {
			System.out.printf("Time:%s%n",startingTime.getTime());
			startingTime.addTimeAsString(a.playAct().getTime());
		}
		System.out.printf("The festival end.Time:%s%n",startingTime.getTime());
	}
}
