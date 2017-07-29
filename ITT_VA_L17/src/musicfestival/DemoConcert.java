package musicfestival;

import musicfestival.classes.*;
import musicfestival.classes.instruments.*;

public class DemoConcert {
	public static void main(String[] args) {
		/*
		 * DB for the concert:
		 */
		Time startTime = new Time(20, 0, 0);

		Song[] songs = new Song[9];
		// chalga
		songs[0] = new Song("Тез червени домати", "Тез червени домати, кой ги мама разклати...", new Time(0, 3, 23));

		songs[1] = new Song("Тигре Тигре", "Ооо тигре тигре имаш ли пари,имаш ли пари хубави жени...",
				new Time(0, 5, 15));
		songs[2] = new Song("Шопска салата", "Обичам шопската салата,\nмастика ледена да пия,\n"
				+ "вълните морски да ме галят\n и руси мацки покрай мен...\n", new Time(0, 3, 25));
		// heavy metal
		songs[3] = new Song("For Whom The Bell Tolls",
				"Make his fight on the hill in the early day\n"
						+ "Constant chill deep inside\nShouting gun, on they run through the endless grey...\n",
				new Time(0, 5, 12));
		songs[4] = new Song("Fade to black", "Life it seems to fade away\nDrifting further everyday\n"
				+ "Getting lost within myself\nNothing matters no one else", new Time(0, 5, 12));
		songs[5] = new Song("Master of Puppets",
				"You guys like that song, don't ya?\nSure, if you play it right\n"
						+ "So you guys are tired, huh? (no)\nWe're just getting warmed up and you guys are tired...\n",
				new Time(0, 5, 12));
		// only sound
		songs[6] = new Song("Most evolved spanish guitar", null, new Time(0, 5, 50));
		songs[7] = new Song("My nightmare", null, new Time(0, 5, 30));
		songs[8] = new Song("Time to guitar", null, new Time(0, 3, 11));

		MusicalInstrument trompet = new Trompet();
		MusicalInstrument guitar = new Guitar();
		MusicalInstrument drums = new Drums();
		Musician[] musicians = new Musician[6];

		musicians[0] = new Vocalist("Rado Shiharkata", songs[0], songs[1], songs[2]);
		musicians[1] = new Musician("bai Georgi", trompet, songs[0], songs[1], songs[2]);

		musicians[2] = new Vocalist("James Hetfield", songs[3], songs[4], songs[5]);
		musicians[3] = new Musician("Kirk Hammett ", guitar, songs[3], songs[4], songs[5]);
		musicians[4] = new Musician("Lars Ulrich", drums, songs[3], songs[4], songs[5]);

		musicians[5] = new Musician("Ewan Dobson", guitar, songs[6], songs[7], songs[8]);

		Group[] groups = new Group[3];
		groups[0] = new Group("Шишарката бенд", musicians[0], musicians[1]);
		groups[1] = new Group("Metallica", musicians[2], musicians[3], musicians[4]);
		groups[2] = new Group("ED", musicians[5]);

		Time startingTime = new Time(startTime.getTime());
		Act[] acts = new Act[3];
		acts[0] = new Act("Chalga Time", groups[0],  songs[0], songs[1], songs[2]);
		startingTime.addTimeAsString(acts[0].endTimeOfAct(startingTime));
		acts[1] = new Act("Heavy Metal time\\m/", groups[1],  songs[3], songs[4], songs[5]);
		startingTime.addTimeAsString(acts[1].endTimeOfAct(startingTime));
		acts[2] = new Act("Time to guitar", groups[2], songs[6], songs[7], songs[8]);

		MusicFestival concert = new MusicFestival("Sofia, Arena Armeec", startTime, acts[0], acts[1], acts[2]);
		System.out.println(concert.showProgram());
		concert.startFestival();

		System.out.printf("\n\nThe audience wants from %s to sing %s\n", groups[1].getName(), songs[1].getTitle());
		groups[1].playSong(songs[1]);

		System.out.printf("\n\nThe audience wants from %s to sing with Drums %s\n", musicians[5].getName(),
				songs[6].getTitle());
		System.out.println(musicians[5].playWithInstrumentSong(drums, songs[6]));

		System.out.printf("\n\nThe audience wants from %s to sing with %s %s\n", groups[1].getName(),
				musicians[0].getName(), songs[1].getTitle());
		groups[1].addMusician(musicians[0]);
		groups[1].playSong(songs[1]);
		musicians[3].learnNewSong(songs[1]);
		musicians[4].learnNewSong(songs[1]);
		System.out.printf("%s teach %s and %s to sing the song\n", musicians[0].getName(), musicians[3].getName(),
				musicians[4].getName());
		groups[1].playSong(songs[1]);
	}
}
