package musicfestival.classes.instruments;

import musicfestival.classes.Song;

public class Guitar extends MusicalInstrument {
	public Guitar(){
		super.instrumentsName = "guitar";
	}
	@Override
	public String sing(Song song) {
		return "dingle dingle dong...dingle dingle dong dong dingle...";
	}
}
