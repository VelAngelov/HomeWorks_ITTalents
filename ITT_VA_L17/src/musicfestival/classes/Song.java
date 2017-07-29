package musicfestival.classes;


public class Song {
	private String title;
	private String content;
	private Time time;

	public Song(String title, String content,Time time) {
		this.title = title;
		this.content = content;
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}
	public String getContent() {
		return content;
	}
	public String getTime() {
		return time.getTime();
	}
}
