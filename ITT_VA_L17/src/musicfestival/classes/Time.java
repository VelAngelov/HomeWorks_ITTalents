package musicfestival.classes;

public class Time {
	private int mm;
	private int hh;
	private int ss;

	public Time(int hh, int mm, int ss) {
		setNewTime(hh, mm, ss);
	}
	public Time(String time){
		setNewTimeAsString(time);
	}

	void setNewTime(int hh, int mm, int ss) {
		if (mm >= 0 && mm <= 59) {
			this.mm = mm;
		}
		if (hh >= 0 && hh <= 23) {
			this.hh = hh;
		}
		if (ss >= 0 && ss <= 59) {
			this.ss = ss;
		}
	}
	public void setNewTimeAsString(String time) {
		String[] timeString = time.split(":");
		int hh = Integer.parseInt(timeString[0]);
		int mm = Integer.parseInt(timeString[1]);
		int ss = Integer.parseInt(timeString[2]);
		setNewTime(hh,mm,ss);
	}

	public void addTime(int hh, int mm, int ss) {
		this.ss += ss;
		if(this.ss>=60) {
			this.ss-=60;
			mm++;
		}
		this.mm+=mm;
		if(this.mm>=60) {
			this.mm-=60;
			hh++;
		}
		this.hh += hh;
		if(this.hh>=24) {
			this.hh-=24;
		}
	}

	public String getTime() {
		return String.format("%02d:%02d:%02d", hh, mm, ss);
	}

	public void addTimeAsString(String time) {
		String[] timeString = time.split(":");
		int hh = Integer.parseInt(timeString[0]);
		int mm = Integer.parseInt(timeString[1]);
		int ss = Integer.parseInt(timeString[2]);
		addTime(hh, mm, ss);
	}
}
