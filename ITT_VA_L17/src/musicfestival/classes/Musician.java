package musicfestival.classes;

import java.util.ArrayList;

import musicfestival.classes.instruments.*;

public class Musician implements SingSong {
	protected String name;
	private MusicalInstrument instrument;
	protected ArrayList<Song> familiarSongs;

	protected Musician(String name, Song... familiarSongs) {
		this.name = name;
		this.familiarSongs = new ArrayList<Song>();
		for (Song s : familiarSongs) {
			this.familiarSongs.add(s);
		}
	}

	public Musician(String name, MusicalInstrument instrument, Song... familiarSongs) {
		this(name, familiarSongs);
		this.instrument = instrument;
	}

	public String playWithInstrumentSong(MusicalInstrument instrument, Song song) {
		StringBuilder sb = new StringBuilder(String.format("%s get %s ", this.name, instrument.getInstrument()));
		if (this.instrument.equals(instrument) && familiarSongs.contains(song)) {
			sb.append("and start:" + instrument.sing(song));
		} else if (familiarSongs.contains(song)) {
			sb.append(instrument.getMakeNoise());
		} else {
			sb.append(this.name + " says: Hah may be I can't play this song!");
		}
		return sb.toString();
	}

	@Override
	public String sing(Song song) {
		if (familiarSongs.contains(song)) {
			return playWithInstrumentSong(instrument, song);
		} else {
			return this.name + " says: Hah may be I can't play this song!";
		}
	}

	public void learnNewSong(Song song) {
		familiarSongs.add(song);
	}
	public String getName() {
		return name;
	}

}
