package musicfestival.classes.instruments;

import musicfestival.classes.Song;

public class Trompet extends MusicalInstrument {
	public Trompet(){
		super.instrumentsName = "trompet";
	}
	@Override
	public String sing(Song song) {
		return "uahh uahh ua...uaha uah ua...";
	}
}
