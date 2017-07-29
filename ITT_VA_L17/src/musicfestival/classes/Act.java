package musicfestival.classes;

import java.util.ArrayList;

public class Act {
	private String actName;
	private Group group;
	private ArrayList<Song> repertoire;

	public Act(String actName, Group group, Song... songs) {
		this.actName = actName;
		this.group = group;
		this.repertoire = new ArrayList<Song>();
		for (Song s : songs) {
			this.repertoire.add(s);
		}
	}

	public void addSongToRepertoire(Song song) {
		if (repertoire.contains(song)) {
			System.out.println("this song is alredy in the repertoire!");
			return;
		}
		repertoire.add(song);
	}

	public String endTimeOfAct(Time startingTime) {
		Time time = new Time(startingTime.getTime());
		for (Song s : repertoire) {
			time.addTimeAsString(s.getTime());
			// pause:
			time.addTime(0, 1, 0);
		}
		return time.getTime();
	}

	private String startNewSong(Song song) {
		return String.format("The group %s start to play %s", this.group.getName(), song.getTitle());
	}

	public Time playAct() {
		System.out.printf("========ACT:%s========%n", this.actName.toUpperCase());
		Time timeElapsed = new Time(0, 0, 0);
		for (Song s : repertoire) {
			System.out.println(startNewSong(s));
			this.group.playSong(s);
			System.out.println("~Applause from the audience\n\n");
			timeElapsed.addTimeAsString(s.getTime());
			// add pause:
			timeElapsed.addTime(0, 1, 0);
		}
		return timeElapsed;
	}

	public String getInfo(Time startingTime) {
		return String.format("%s - %s Group:%s%n", startingTime.getTime(), endTimeOfAct(startingTime), group.getName());
	}
}
