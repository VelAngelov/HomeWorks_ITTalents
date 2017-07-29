package musicfestival.classes.instruments;

import musicfestival.classes.Song;

public class Drums extends MusicalInstrument{
	public Drums(){
		super.instrumentsName = "drums";
	}
	@Override
	public String sing(Song song) {
		return "rata-tata-rata dum dum rata-tata-rata-ta...";
	}
}
