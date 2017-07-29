package musicfestival.classes;

public class Vocalist extends Musician {

	public Vocalist(String name, Song... familiarSongs) {
		super(name, familiarSongs);
	}

	@Override
	public String sing(Song song) {
		if (familiarSongs.contains(song)) {
			return String.format("%s start to singing:%n\t%s", this.name, song.getContent());
		} else {
			return this.name + " says: Sorry but I don't know this song!";
		}
	}
}
