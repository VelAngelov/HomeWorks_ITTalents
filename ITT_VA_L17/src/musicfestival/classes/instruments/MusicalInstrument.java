package musicfestival.classes.instruments;

import musicfestival.classes.Song;

public class MusicalInstrument implements SingSong {
	private String makeNoise = " it sounds like: alskjdlajsdajdlj.Not a pleasent sound";
	protected String instrumentsName = "no instroment";
	@Override
	public String sing(Song song) {
		return "No instrument,no sound";
	}

	public String getMakeNoise() {
		return makeNoise;
	}
	public boolean equals(MusicalInstrument instrument) {
		if (this == instrument || this.getClass() == instrument.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	public String getInstrument() {
		return instrumentsName;
	}
}
