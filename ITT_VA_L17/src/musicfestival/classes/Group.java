package musicfestival.classes;

import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Musician> musicians;

	public Group(String name, Musician... band) {
		this.name = name;
		this.musicians = new ArrayList<Musician>();
		for (Musician m : band) {
			this.musicians.add(m);
		}
	}
	public void playSong(Song song) {
		System.out.printf("=\"%s\" from %s=%n",song.getTitle(),this.name);
		for(Musician m:this.musicians) {
			if(!(m instanceof Vocalist))
			System.out.println(m.sing(song));
		}
		for(Musician m:this.musicians) {
			if(m instanceof Vocalist)
			System.out.println(m.sing(song));
		}
	}

	public void addMusician(Musician musician) {
		if (musicians.contains(musician)) {
			System.out.println("this musician is alredy in the group");
			return;
		}
		musicians.add(musician);
	}
	public String getName() {
		return name;
	}
	public ArrayList<Musician> getMusicians(){
		return this.musicians;
	}



}
